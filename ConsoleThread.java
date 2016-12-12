
/**
 * Abstract class ConsoleThread - This is the class that all threads associated with ConsoleArea will
 * extend.
 * 
 * @author Vatsal Varma
 * @version v0.2
 */
public abstract class ConsoleThread extends Thread
{
    private int threadNum = 0;
    protected static int UPDATE_TIME = 500;
    
    public ConsoleThread(){
        threadNum++;
    }
    
    public int getThreadNum(){
        return threadNum;
    }
    
    
     /**
     * Sets the update time so that the console does not continually update.
     * 
     * @param int ms The time in milliseconds.
     */
    public void setUpdateTime(int ms){
        UPDATE_TIME = ms;
    }
    
    /**
     * Abstract methods that need to be implemented by all subclasses.
     */
    public abstract void run();
    public abstract boolean getActiveState();
    public abstract void startThread();
    public abstract void stopThread();
}