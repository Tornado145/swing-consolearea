import javax.swing.*;
import java.io.*;
/**
 * Instance of an OutputStream that will be able to write to the console.
 * 
 * @author Vatsal Varma 
 * @version v0.2
 */
public class ConsoleAreaWriter extends ConsoleThread{     
    //Instance Variables
    private PrintStream out;
    
    private String output;
    
    private volatile boolean running = false;
    
    
    
    /**
     * A class constructor that takes in values for the Thread.
     * 
     * @param out The Prinstream that this thread writes to.
     */
    public ConsoleAreaWriter(PrintStream out){
        this.out = out;
    }
    
    
    /**
     * @return Whether the thread is printing out or not. Represented by the active state.
     */
    public boolean getActiveState(){
        return running;
    }
    
    
    /**
     * Imitates the starting of a thread.
     */
    @Override
    public void startThread(){
        running = true;
    }
    
    
    /**
     * Imitates the stopping of a thread.
     */
    @Override
    public void stopThread(){
        running = false;
    }
    
    
    /**
     * Sets the message to print.
     * 
     * @param output The string to print to the specified PrintStream.
     */
    public void setOutMessage(String output){
        this.output = output;
    }
    
    
    /**
     * The run method of the thread.
     */
    @Override
    public void run(){
        while(true){
            if(running){
                
                //Prints the output message.
                out.println(output);
            }
            
            //Sleeps the thread for UPDATE_TIME milliseconds.
            try{ Thread.sleep(UPDATE_TIME);} 
            
            catch (Exception e){ e.printStackTrace();}
        }
    }
    

}

