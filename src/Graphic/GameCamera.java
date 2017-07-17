package Graphic;

import Entities.Entity;
import Tiles.Tile;
import mega_man.Handler;


public class GameCamera 
{
    private float xOffset, yOffset;
    private Handler handler;
    
    public GameCamera(Handler handler , float xOffset, float yOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void checkBlankSpace()
    {
        if (xOffset < 0) 
        {
            xOffset = 0;
        }
        else if(xOffset > handler.getLevel().getLevelWidth() * Tile.TILESIZE - handler.getWindowWidth())
        {
            xOffset = handler.getLevel().getLevelWidth() * Tile.TILESIZE - handler.getWindowWidth();
        }
        
        if(yOffset < 0)
        {
            yOffset = 0;
        }
        else if (yOffset > handler.getLevel().getLevelHeight() * Tile.TILESIZE - handler.getWindowHeight())
        {
            yOffset = handler.getLevel().getLevelHeight() * Tile.TILESIZE - handler.getWindowHeight();
        }
    }
    
    public void centerOnEntity(Entity e)
    {
        xOffset = e.getX() - (handler.getWindowWidth() / 2) + (e.getWidth() / 2);
        yOffset = e.getY() - (handler.getWindowHeight()/ 2) + (e.getHeight() / 2);
        checkBlankSpace();
       // System.out.println(xOffset);
    }
    
     public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    
    
    
    //Sets
    public void setXOffset(float xOffset)
    {
        this.xOffset = xOffset;
    }
    
    public void setYOffset(float yOffset)
    {
        this.yOffset = yOffset;
    }
    
    //Gets
    
    public float getXOffset()
    {
        return xOffset;  
    }
    
    public float getYOffset()
    {
        return yOffset;  
    }
    
}
