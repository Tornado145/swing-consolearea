import javax.swing.*;
import java.io.*;
/**
 * An ConsoleArea designed to output a certain string as the value of that String gets updated.
 * 
 * 
 * @author Vatsal Varma 
 * @version v0.1
 */
public class ConsoleAreaOut extends ConsoleArea
{
    private ConsoleAreaWriter writer;
    
    private boolean state = false;
    
    
    /**
     * Class constructor-- Activates the console area and the 
     * writer thread.
     * 
     * @param cnsl The ConsoleArea that will be used
     * @param name The name of the console.
     */
    public ConsoleAreaOut(JTextArea cnsl, String name){
        super(cnsl,name);
        writer = new ConsoleAreaWriter(getPrintStream());
        writer.start();
    }

    
    /**
     * Class constructor-- Activates the console area and the 
     * writer thread.
     * 
     * @param cnsl The ConsoleArea that will be used
     */
    public ConsoleAreaOut(JTextArea cnsl){
        super(cnsl);
    }
    
    
    /**
     * Sets the message to print on the console.
     */
    public void setOutput(String output){
        writer.setOutMessage(output);
    }
    
    
    /**
     * @return The state of the console, whether its active or not.
     */
    public boolean isActive(){
        return state;
    }
    
    
    /**
     * A method to activate the console.
     */
    public void activate(){
        if(!state)
            writer.startThread();
            state = true;
    }
    
    
    /**
     * A method to deactivate the console.
     */
    public void deactivate(){
        if(state)
            writer.stopThread();
            state = false;
    }
}
