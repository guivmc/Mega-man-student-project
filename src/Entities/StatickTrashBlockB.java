package Entities;

import Graphic.Assets;
import java.awt.Graphics;
import mega_man.Handler;


public class StatickTrashBlockB extends Entity
{

    public StatickTrashBlockB(Handler handler, float x, float y)
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
        g.drawImage(Assets.trashBlockB, (int) (x - handler.getGameCamera().getXOffset()), (int) y, null);
    }
    
}
