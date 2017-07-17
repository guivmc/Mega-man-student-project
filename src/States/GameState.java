
package States;

import java.awt.Graphics;
import mega_man.Handler;


public class GameState extends State
{
   
    
    public GameState(Handler handler)
    {
        super(handler);
    }
       
    @Override
    public void update() 
    {
        handler.getLevel().update(); 
    }

    @Override
    public void draw(Graphics g)
    {
        handler.getLevel().draw(g);
    }
   
    
}
