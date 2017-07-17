package Entities;

import Tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;
import mega_man.Handler;


public class Bullet extends Entity
{
    private float vel;
    private int screenCurrentWidth;
    private boolean up;
    
    public Bullet(Handler handler, float x, float y, int w, int h, float vel, boolean up) 
    {
        super(handler, x, y, w, h);
        this.vel = vel;
        this.up = up;
    }


    @Override
    public void update() 
    {
        if(vel > 0)
        { 
           txRight = (int) (x + vel + bounds.x + bounds.width) / Tile.TILESIZE;
        }  
        else
        {
           txLeft = (int) (x + vel + bounds.x) / Tile.TILESIZE; 
        }
        
        screenCurrentWidth = (int) (handler.getGameCamera().getXOffset() + handler.getWindowWidth());
                 
        if(collisionWithTile(txRight, (int) (y + bounds.y) / Tile.TILESIZE) ||
           collisionWithTile(txRight, (int) (y + bounds.y + bounds.height) / Tile.TILESIZE) ||
           collisionWithTile(txLeft, (int) (y + bounds.y) / Tile.TILESIZE)  ||
           collisionWithTile(txLeft, (int) (y + bounds.y + bounds.height) / Tile.TILESIZE) ||
           x >  screenCurrentWidth || x < 0 || y < 0)
        {
            handler.getLevel().getEntityManager().removeBullet(this);
        }   
                 
       if(!up) x += vel; 
       else y -= vel;
    }

    @Override
    public void draw(Graphics g) 
    {   
        g.setColor(Color.yellow);
        g.fillRect((int) (x - handler.getGameCamera().getXOffset()), (int) y, width, height);      
    }
            
    //gets
    public float getVel()
    {
        return vel;
    }
}
