package Entities;

import Graphic.Assets;
import java.awt.Graphics;
import mega_man.Handler;


public class StaticCar extends Entity
{

    public StaticCar(Handler handler, float x, float y) 
    {
        super(handler, x, y, 0, 0);
    }

   

    @Override
    public void draw(Graphics g) 
    {
       g.drawImage(Assets.car, (int) (x - handler.getGameCamera().getXOffset()), (int)y, null);
    }

    @Override
    public void update() 
    {
        
    }  
}
