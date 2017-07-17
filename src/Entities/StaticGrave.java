package Entities;

import Graphic.Assets;
import java.awt.Graphics;
import mega_man.Handler;


public class StaticGrave extends Entity
{

    public StaticGrave(Handler handler, float x, float y) 
    {
        super(handler, x, y, 0, 0);
    }

    @Override
    public void update() 
    {
       
    }

    @Override
    public void draw(Graphics g) 
    {
       g.drawImage(Assets.upperGrave, (int) (x - handler.getGameCamera().getXOffset()), (int) y, null);
       g.drawImage(Assets.bottomGrave, (int) (x - handler.getGameCamera().getXOffset()), (int) (y + 16 * 3), null);
    }
    
}
