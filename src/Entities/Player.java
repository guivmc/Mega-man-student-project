package Entities;

import Graphic.Animation;
import Graphic.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mega_man.Handler;


public class Player extends Creatures 
{
    //Animations
    private Animation IdleL, IdleR, WalkL, WalkR, WalkAttackL, WalkAttackR;
    private Animation anims[] = new Animation[6];
    private BufferedImage staticAnim[] = new BufferedImage[6];
    
    private int currentAnimation = 0;
    private long lastTime, timerFire;
    
            
    public Player(Handler handler, float x, float y) 
    {
        super(handler, x, y, 20, 25);
        
        bounds.x = 2;
        bounds.y = 2;
        bounds.width = 16;
        bounds.height = 22;
        
        speedX = 1.5f;
        
        timerFire = 0;
        lastTime = System.currentTimeMillis();
        
        HP = 50;
        //Animation
        IdleL = new Animation(500, Assets.playerIdleL);
        WalkL = new Animation(100, Assets.playerWalkL);
        WalkR = new Animation(100, Assets.playerWalkR);
        IdleR = new Animation(270, Assets.playerIdleR);  
        WalkAttackL = new Animation(100, Assets.playerWalkAttackL);
        WalkAttackR = new Animation(100, Assets.playerWalkAttackR);
        
        anims[0] = IdleL;
        anims[1] = WalkL;
        anims[2] = WalkR;
        anims[3] = IdleR;  
        anims[4] = WalkAttackL;
        anims[5] = WalkAttackR;
        
        staticAnim[0] = Assets.playerAttackIdleL;
        staticAnim[1] = Assets.playerAttackIdleR;
        staticAnim[2] = Assets.playerAttackJumpL;
        staticAnim[3] = Assets.playerAttackJumpR;
        staticAnim[4] = Assets.playerJumpL;
        staticAnim[5] = Assets.playerJumpR;            
    }

    @Override
    public void update() 
    {
        timerFire += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        die();
       
        //Animation
        if(currentAnimation <= 5)
        {
            anims[currentAnimation].update();
        }
    
        //Movement
        physics();
        handler.getGameCamera().centerOnEntity(this);
         
        getInput();
        
        animationManager();
    }
  
    @Override
    public void draw(Graphics g) 
    {
        //(image, coordinates, size/scale, imageObserver)     
        g.drawImage(getCurrentImage(), (int) (x - handler.getGameCamera().getXOffset()),
                (int) (y - handler.getGameCamera().getYOffset()), null);
        
       //Draw collision box
       /* g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXOffset()),
               (int) (y + bounds.y - handler.getGameCamera().getYOffset()),
                bounds.width, bounds.height); */
    }
    
    //Gets
    private BufferedImage getCurrentImage()
    {
        if(currentAnimation <=5)
        {
            return anims[currentAnimation].getCurrentFrame();
        }
        else
        {
            return staticAnim[ currentAnimation - 6];
        }
    }
      
    private void getInput()
    {       
        if(handler.getKeyManager().left)
        {
            xMove = -speedX;
            facingL = true;
        }    
        else if(handler.getKeyManager().right)
        {

            xMove = speedX;
            facingL = false;
        }
        else xMove = 0;
        
        if(handler.getKeyManager().spaceBar && canJump)
        {
            jumping = true;
        }
              
        
        if(handler.getKeyManager().esc)
        {    
            handler.setPaused(true);
            handler.setState(handler.getPausedState());   
        }
        
        
        if(handler.getKeyManager().fire)
        {  
            if(timerFire > 300)
            {
                if(facingL)
                {
                    handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x - 5, y + 10, 5, 5, -2, false));
                }
                else
                {
                    handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x + 30, y + 10, 5, 5, 2, false));
                }
                timerFire = 0;
            }
        }
    }   
    
    public void animationManager()
    {
        if(xMove < 0)
        {
            if(!falling)
            {
                if(!handler.getKeyManager().fire) currentAnimation = 1;
                else currentAnimation = 4;
            }
            else
            {
                if(handler.getKeyManager().fire) currentAnimation = 8;                    
                else currentAnimation = 10;
            }
        }
        else if (xMove > 0) 
        {
           if(!falling)
           {
               if(!handler.getKeyManager().fire) currentAnimation = 2;
               else currentAnimation = 5;
           }
           else
           {
               if(handler.getKeyManager().fire)  currentAnimation = 9;  
               else currentAnimation = 11;
           }
        }
        else
        {
            if(handler.getKeyManager().NoKeysDown() && !falling)
            {
                if(facingL) currentAnimation = 0;
                else currentAnimation = 3;
            }
            if(falling)
            {
                if(handler.getKeyManager().fire)
                {
                    if (facingL) currentAnimation = 8;
                    else currentAnimation = 9;
                }
                else
                {
                   if (facingL) currentAnimation = 10;
                   else currentAnimation = 11;
                }
            } 
            else
            {
                if(handler.getKeyManager().fire)
                {
                    if (facingL) currentAnimation = 6;
                    else currentAnimation = 7;
                }
            }
        }
    }
}
