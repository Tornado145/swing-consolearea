import javax.swing.*;
import java.io.*;
/**
 * An ConsoleArea designed to read a certain string value.
 * 
 * 
 * @author Vatsal Varma 
 * @version v0.1
 */
public class ConsoleAreaIn extends ConsoleArea
{
    private boolean state;
    
    private ConsoleAreaReader reader;
    
    /**
     * Class constructor-- Activates the console area and the 
     * reader thread.
     * 
     * @param cnsl The ConsoleArea that will be used
     * @param name The name of the console.
     */
    public ConsoleAreaIn(JTextArea cnsl, String name){
        super(cnsl,name);
        reader = new ConsoleAreaReader(getConsoleArea());
        reader.start();
    }
    
    /**
     * Class constructor-- Activates the console area and the 
     * reader thread.
     * 
     * @param cnsl The ConsoleArea that will be used.
     */
    public ConsoleAreaIn(JTextArea cnsl){
        super(cnsl);
        reader = new ConsoleAreaReader(getConsoleArea());
        reader.start();
    }
    
    
    /**
     * @return The state of the console, whether its active or not.
     */
    @Override
    public boolean isActive(){
        return state;
    }
    
    
    /**
     * A method to activate the console.
     */
    public void activate(){
        if(!state)
            reader.startThread();
            state = true;
    }
    
    
    /**
     * A method to deactivate the console.
     */
    public void deactivate(){
        if(state)
            reader.stopThread();
            state = false;
    }
}
