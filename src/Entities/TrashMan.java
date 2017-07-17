package Entities;

import Graphic.Animation;
import Graphic.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import mega_man.Handler;

public class TrashMan extends Creatures
{
    //Animation
    private Animation Enter, Attack, AttackSides, AttackUp;
    private Animation anims[] = new Animation[4];
    private BufferedImage staticAnim[] = new BufferedImage[4];
       
    private Random rand;
    
    
    private int currentAnimation, imageW, imageH, action;
    private boolean enter, performingAction;
    private long lastTime, timerFire, actionTimer;
    
    public TrashMan(Handler handler, float x, float y)
    {
       super(handler, x, y, 22, 30);
       
       bounds.x = 3;
       bounds.y = 2;
       bounds.width = 15;
       bounds.height = 26;
       HP = 50;
       
       timerFire = 0;
       actionTimer = 0;
       lastTime = System.currentTimeMillis();
        
       enter = true;
       performingAction = false;
       
       rand = new Random();
       
       Enter = new Animation(200, Assets.trashManEnter);
       Attack = new Animation(200, Assets.trashManAttack);
       AttackSides = new Animation(200, Assets.trashManAttackSides);
       AttackUp = new Animation(200, Assets.trashManAttackUp);
       
       anims[0] = Enter;
       anims[1] = Attack; 
       anims[2] = AttackSides;
       anims[3] = AttackUp;
       
       staticAnim[0] = Assets.trashManIdle;
       staticAnim[1] = Assets.trashManAttackIdle;
       staticAnim[2] = Assets.trashManAttackSidesIdle;
       staticAnim[3] = Assets.trashManAttackUpIdle;
       
       facingL = x <= 320;   

    }

    @Override
    public void update() 
    {
       die();
       // System.out.println((int) (x + bounds.x + bounds.width + 2));
       physics();
       
       /*if (x <= 640)
       {
           facingL = true;
       }
       else  facingL = false;*/
       
       if(currentAnimation <= 3)
       {
           anims[currentAnimation].update();
       }
       
      if(!performingAction) action = rand.nextInt(3) + 1;
      else
      {
          timerFire += System.currentTimeMillis() - lastTime;
          actionTimer += System.currentTimeMillis() - lastTime;
          lastTime = System.currentTimeMillis();
      }
          
      AI();
    }

    @Override
    public void draw(Graphics g) 
    {
        if(facingL)
        {
            g.drawImage(getCurrentImage(), (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), null);
        }        
        else
        {
            g.drawImage(getCurrentImage(), (int) (x + bounds.x + bounds.width + 2 - handler.getGameCamera().getXOffset()) , 
                    (int) (y- handler.getGameCamera().getYOffset()), -imageW, imageH, null);
        }
       /*g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXOffset()),
               (int) (y + bounds.y - handler.getGameCamera().getYOffset()),
                bounds.width, bounds.height);*/
   }
    
     public void animationManager()
     {
     }
     
     public void AI()
     {
         if(enter)
         {
             currentAnimation = 0;
             if(anims[0].isAnimationFinisihed())
             {
                 currentAnimation = 4;
                 enter = false;
             }
         }
         else
         {
             currentAnimation = action;
             switch(action)
             {
                 case 1:
                 {
                     if(anims[1].isAnimationFinisihed())
                     {
                         currentAnimation = 5;
                         if(timerFire > 300)
                         {
                            if(facingL)
                            {
                                handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x + 30 - handler.getGameCamera().getXOffset(),
                                        y + 14 - handler.getGameCamera().getYOffset(), 5, 5, 2, false));
                            }
                            else
                            {
                                handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x - 20 - handler.getGameCamera().getXOffset(),
                                        y + 14 - handler.getGameCamera().getYOffset(), 5, 5, -2, false));
                            }
                            timerFire = 0;
                         }
                     }
                     performingAction = true;
                     break;
                 }
                 case 2:
                     if(anims[2].isAnimationFinisihed())
                     {
                         currentAnimation = 6;
                          if(timerFire > 300)
                          {
                            handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x + 20,
                                     y + 14, 5, 5, 2, false));
                            handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x - 15,
                                    y + 14, 5, 5, -2, false));
                            timerFire = 0;
                          }
                     }
                     performingAction = true;
                     break;
                 case 3:
                     if(anims[3].isAnimationFinisihed())
                     {
                          currentAnimation = 7;
                          if(timerFire > 300)
                          {
                            handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x - 5,
                                    y + 10, 5, 5, 2, true));
                            handler.getLevel().getEntityManager().addBullet(new Bullet(handler, x + 20,
                                    y + 10, 5, 5, 2, true));
                            timerFire = 0;
 
                          }
                     }
                     performingAction = true;
                     break;
                 default:
                     System.out.println(action);                
             }
             
          if(actionTimer > 2000)
          {
              if(rand.nextInt(100) > 80)
              {
                    anims[currentAnimation - 4].setIsFinished(false);
                    performingAction = false;
                    actionTimer = 0;
              }
          }
                           
         }
     }
     
     //Gets
     private BufferedImage getCurrentImage()
     {
         if(currentAnimation <= 3)
         {
             imageW = anims[currentAnimation].getCurrentFrame().getWidth();
             imageH = anims[currentAnimation].getCurrentFrame().getHeight();
             return anims[currentAnimation].getCurrentFrame();
         }
         else
         {
             imageW = staticAnim[currentAnimation - 4].getWidth();
             imageH = staticAnim[currentAnimation - 4].getHeight();
             return staticAnim[currentAnimation - 4];
         }
     }     
}
