//when making method, do not add curly brackets, there is no body use a semi colon instead
//cannot make variables in interface
package beginnerai;

/**
 * GameObject
 * 
 * @author hanna
 */
public interface GameObject {
    
    /**
     * start
     */
    public void start();
    
    /**
     * earlyUpdate
     */
    public void earlyUpdate();
    
    /**
     * update
     */
    public void update();
    
    /**
     * lateUpdate
     */
    public void lateUpdate();
    
    /**
     * onEnable
     */
    public void onEnable();
    
    /**
     * setEnable
     * @param enable whether it is enabled or not
     */
    public void setEnable(boolean enable);
    
    /**
     * stop
     */
    public void stop();
    
}//end of gameObject
