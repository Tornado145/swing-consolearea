import javax.swing.*;
import java.io.*;
/**
 * Instance of an OutputStream that will be able to write to the console.
 * 
 * @author Vatsal Varma 
 * @version v0.1
 */
public class ConsoleAreaOutputStream extends OutputStream{
    
    private JTextArea outputConsole;
    
    /**
     * The class constructor for the OutputStream.
     */
    public ConsoleAreaOutputStream(JTextArea cnsl){
        outputConsole = cnsl;
    }
    
    
    /**
     * This is the write method required for an OutputStream 
     */
    public void write(int b){
        //Appends the ASCII value of b).
        outputConsole.append(String.valueOf((char) b));
    }
}
