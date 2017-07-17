package Graphic;

import java.awt.image.BufferedImage;

public class Animation 
{
    private int speed, index;
    private boolean isFinished;
    private long lastTime, timer;
    private BufferedImage[] frames;
    
    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        isFinished = false;
        lastTime = System.currentTimeMillis();
    }
    
    public void update()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed)
        {
            index++;
            timer = 0;
            
            if(index >= frames.length)
            {
                isFinished = true;
                index = 0;
            }
        }
    }
    
    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }
    
    public boolean isAnimationFinisihed()
    {
       return isFinished;
    }
    
    public void setIsFinished(boolean isFinished)
    {
        this.isFinished = isFinished;
    }
}
