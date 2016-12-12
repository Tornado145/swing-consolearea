import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;

/**
 * A thread that reads the console area as it gets updated.
 * 
 * @author Vatsal Varma 
 * @version v0.2
 */
public class ConsoleAreaReader extends ConsoleThread{
    /*
     * Instance variables that help the Thread.
     */
    private JTextArea readConsole;
    
    private volatile String lastString;
    
    private volatile boolean running = false;
    
    private int msUpdate = UPDATE_TIME;
    
    /**
     * The class constructor, identifies which JTextArea to take input from.
     * 
     * @param cnsl The JTextArea to take input from.
     */
    public ConsoleAreaReader(JTextArea cnsl){
        readConsole = cnsl;
    }
    
    
    /**
     * Imitates the starting of a thread, but in fact sets a value to true, enabling the thread to update the value of lastString.
     */
    @Override
    public void startThread(){
        running = true;
    }
    
    
    /**
     * Imitates the stopping of a thread, but in fact sets a value to false, disablig the thread to update the value of lastString.
     */
    @Override
    public void stopThread(){
        running = false;
    }
    
    
    /**
     * @return The last line on the console.
     */
    public String getLastLine(){
        return lastString;
    }
    
    
    /**
     * @param text The array of strings sorted by newlines("\n");
     * 
     * @return The last line on the console, used only by the thread.
     */
    private String getLastLine(String[] text){
       return text[text.length - 1];
    }
    
    
    /**
     * @param lineNum The line at the specific number in the array.
     * @param text The array from which the String is recieved.
     * 
     * @return The line at that number. 
     */
    private String getLineAt(int lineNum,String[] text){
    
        try{
            //The try catch is used to make sure the program does not stop if an OutOfBounds Exception is thrown.
            
            return text[lineNum];
        }catch(Exception e){
            //Catches the OutOfBounds Exception
            
            return "OUT OF BOUNDS: CALLAGAIN";
        }
    }
    
    @Override
    public boolean getActiveState(){
        return running;
    }
    
    /**
     * Overrides the run method in thread.
     */
    @Override
    public void run(){
        while(true){
            //Splits the text on the console.
            //IS CONTINUALLY UPDATED.
            
            String[] text = readConsole.getText().split("\n");
            if(running){
                //Sets the value of lastString.
                
                lastString = getLastLine(text);
            }
            
            //Sleeps the thread for UPDATE_TIME milliseconds.
            try{ Thread.sleep(UPDATE_TIME);} 
            
            catch (Exception e){ e.printStackTrace();}
        }
    }
    
    
}
