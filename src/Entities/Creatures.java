package Entities;

//Class which all game creatures will inherit

import Tiles.Tile;
import mega_man.Handler;

public abstract class Creatures extends Entity
{
    protected int HP;
    protected boolean facingL,
                      canJump, falling, jumping;
    protected float speedX, speedY;
    protected float xMove, yMove,
                    gravity, velFall, jumpVel;
    
    
    
    public Creatures(Handler handler, float x, float y, int w, int h) 
    {
        super(handler,x, y, w, h);
              
        facingL = false;
        falling = true;
        gravity = 0.5f;       
    }
    
    public void physics()
    {
        //if(!checkEntityCollision(xMove, 0))
        moveX();
      
        //if(!checkEntityCollision(0, yMove))
        moveY();
    
        if(!jumping)
        {
            fall(7);
            jumpVel = 10;
        }
        else
        {
            jump(4);
        }
        //if(!falling)velFall = 0;
        
    }
     
    //Collision
    public void moveX()
    {    
         if(xMove > 0)
         {
             //Moving right     right side
             txRight = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILESIZE;
             //                                upper side && lower side
             if(!collisionWithTile(txRight, (int) (y + bounds.y) / Tile.TILESIZE) &&
                !collisionWithTile(txRight, (int) (y + bounds.y + bounds.height) / Tile.TILESIZE))
             {
                 x += xMove; 
             }
         }
         else if (xMove < 0)
         {
             //Moving left      left side
             txLeft = (int) (x + xMove + bounds.x) / Tile.TILESIZE; 
             //                                upper side && lower side
             if(!collisionWithTile(txLeft, (int) (y + bounds.y) / Tile.TILESIZE)  &&
                !collisionWithTile(txLeft, (int) (y + bounds.y + bounds.height) / Tile.TILESIZE))
             {
                 x += xMove; 
             }
         }
    }
    
    //Collision
    public void moveY()
    {
      
         if (yMove < 0)
         {
             //Moving up    
             //               upper side
             tyUp = (int) (y + yMove + bounds.y) / Tile.TILESIZE;
             //                           left side && right side
             if(collisionWithTile((int) (x + bounds.x) / Tile.TILESIZE, tyUp) || 
                collisionWithTile((int) (x + bounds.x + bounds.width - 16) / Tile.TILESIZE, tyUp))
             {
                canJump = false;
                jumping = false;
                falling = true;
             }
             else
             {
                 falling = true;
                 y += yMove; 
             }
         }
         else if (yMove > 0)
         {
              //Moving down 
              //                  lower side
              tyDown = (int) (y + yMove + bounds.y + bounds.height)/ Tile.TILESIZE;
              //                    left side && right side
              if(collisionWithTile((int) (x + bounds.x) / Tile.TILESIZE, tyDown) ||
                 collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILESIZE, tyDown))              
              {
                 falling = false;
                 canJump = true;
                 y = tyDown * Tile.TILESIZE - bounds.y - bounds.height - 1;
              }
              else 
              {
                  canJump = false;
                  falling = true;
                  y += yMove;
              }
         }
         else
         {
              tyDown = (int) (y + bounds.y + bounds.height) / Tile.TILESIZE + 1;
              //                    left side && right side
              if(collisionWithTile((int) (x + bounds.x) / Tile.TILESIZE, tyDown) ||
                 collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILESIZE, tyDown))              
              {
                   falling = false;
                   canJump = true;
              }
              else 
              {
                  falling = true;
                  canJump = false;
                  
              } 
         }      
    }
    
    
    public void jump(float maxJumpVel)
    {  
        canJump = false;
        jumpVel -= 0.2;
        if(jumpVel < maxJumpVel)
        {
            jumping = false;
        }
        yMove = -jumpVel;
    }
    
    public void fall(float maxVelFall)
    {     
        if(falling)
        {
            velFall += gravity;
            if(velFall > maxVelFall) velFall = maxVelFall;
        }
        else velFall = 0;
        
        yMove = velFall;  
    }
    
    public void die()
    {
        if(HP <= 0) handler.getLevel().getEntityManager().removeCreature(this);
    }
    
  
    //gets
    public int getHP()
    {
        return HP;
    }
    
    public float getSpeedX()
    {
        return speedX;
    }
    
    public float getSpeedY()
    {
        return speedY;
    }
    
    
    public float getXMove()
    {
        return xMove;
    }
    
    public float yMove()
    {
        return yMove;
    }
    
    
    //sets
    public void setHP(int hp)
    {
        this.HP = hp;
    }
    
    public void setSpeedX(float speedX)
    {
        this.speedX = speedX;
    }
    
    public void setSpeedY(float speedY)
    {
        this.speedY = speedY;
    }
    
    public void setXMove(float xmove)
    {
        this.xMove = xmove;
    }
    
    public void setYMove(float ymove)
    {
        this.yMove = ymove;
    }
}
