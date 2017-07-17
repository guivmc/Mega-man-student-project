
package States;

import java.awt.Graphics;
import mega_man.Handler;


public abstract class State 
{
    //Game State Manager
    private static State currentState = null;
   
   
    public static void setState (State s)
    {
        currentState = s;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    //CLASS
    
    protected Handler handler;
    protected long lastTime, timer;
    
    
    public State(Handler handler)
    {
        this.handler = handler;
        
    }
    
    public abstract void update();
    
    public abstract void draw(Graphics g);
}
