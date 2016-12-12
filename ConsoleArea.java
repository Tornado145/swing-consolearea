import javax.swing.*;
import java.io.*;


/**
 * The class that creates and is able to read and write from a JTextArea.
 * 
 * @author Vatsal Varma 
 * @version v0.1
 */
public abstract class ConsoleArea{
    private JTextArea cnsl;
    private String cnslName;
    private PrintStream out;
    private int cnslNum = 0;
    
    
    /**
     * Class constructor, this creates a console on a JTextArea without a name.
     * 
     * @param cnsl The JTextArea that will be read from or written to whenever the Console requires.
     */
    public ConsoleArea(JTextArea cnsl){
        this.cnsl = cnsl;
        out = new PrintStream(new ConsoleAreaOutputStream(cnsl));
        cnslName = "Console " + cnslNum;
        cnslNum++;
    
    }
    
    
    /**
     * Class constructor, this creates a console on a JTextArea with a name.
     * 
     * @param cnsl The JTextArea that will be read from or written to.
     * @param name The name of the console, useful for identification purposes.
     */
    public ConsoleArea(JTextArea cnsl,String name){
        this.cnsl = cnsl;
        out = new PrintStream(new ConsoleAreaOutputStream(cnsl));
        cnslName = name;
        cnslNum++;
    }
    
    
    /**
     * @return The number of consoles formed by this class.
     */   
    public int getConsoleNumber(){
        return cnslNum;
    }
    
    
    /**
     * @return The name of that specific console.
     */
    public String getConsoleName(){
        return cnslName;
    }
    
    
    /**
     * @return The JTextArea this ConsoleArea is referring to. 
     */
    public JTextArea getConsoleArea(){
        return cnsl;
    }
    
    /**
     * @return The PrintStream out that can be used for extensions of this class
     */
    public PrintStream getPrintStream(){
        return out;
    }
    
    /**
     * @return A ConsoleAreaIn which allows for reading input from a ConsoleArea.
     */
    public static ConsoleAreaIn convertToInput(ConsoleArea cnslArea){
        return (ConsoleAreaIn)cnslArea;
    }
    
    
    /**
     * @return A ConsoleAreaOut which allows for writing output to a ConsoleArea.
     */
    public static ConsoleAreaOut convertToOutput(ConsoleArea cnslArea){
        return (ConsoleAreaOut)cnslArea;
    }
    
    
    /**
     * Methods that all subclasses will need to implement.
     */
    public abstract boolean isActive();
    public abstract void activate();
    public abstract void deactivate();
    
}
