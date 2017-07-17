package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import mega_man.Handler;

//Class with characteristics that other specific class will inherit
public abstract class Entity 
{
    protected float x, y;
    protected int width, height;
    protected int tyUp, tyDown, txRight, txLeft;
    protected Rectangle bounds;
    
    //To pick keyManager
    protected Handler handler;
    
    public Entity(Handler handler, float x, float y, int w, int h)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getLevel().getTile(x , y).isSolid();
    }
    
    
    public abstract void update();
    
    public abstract void draw(Graphics g);
    
     
    //gets
    public float getX()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
   /* public boolean checkEntityCollision(float xOffset, float yOffset)
    {
        for (Entity e : handler.getLevel().getEntityManager().getEntities()) 
        {
            if(e.equals(this))
            {
                //Skips the collision detection with the entity itself.
                //Go to the next entity in the array.
                continue;
            }
            if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset)))
            {
                return true;
            }
        }
     
         return false;
    }*/
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    
    //sets
    public void setX(float x)
    {
        this.x = x;
    }
    
    public void setY(float y)
    {
        this.y = y;
    }
    
    public void setWidth(int w)
    {
        this.width = w;
    }
    
    public void setHeight(int h)
    {
        this.height = h;
    }
}
