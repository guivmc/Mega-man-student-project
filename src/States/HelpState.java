
package States;

import Graphic.Animation;
import Graphic.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mega_man.Handler;


public class HelpState extends State
{
    private String[] Commands = new String[5];
    private int currentCommand = -1;
    private Animation walk, climb;

    public HelpState(Handler handler) 
    {
        super(handler);
        Commands[0] = "Move";
        Commands[1] = "Climb";     //"Move use → and ←";
        Commands[2] = "Attack";    //"Climb use ↑ and ↓";
        Commands[3] = "Pause";    //"Attack use X";
        Commands[4] = "Resume";     //"Pause use ESC";
        
        walk = new Animation(100, Assets.playerWalkL);
        climb = new Animation(270, Assets.playerClimb);
    }
    private void getInput()
    {
        if(timer > 100)
        {
            if(handler.getKeyManager().up)
            {  
                currentCommand--;
                if(currentCommand < 0) currentCommand = 0;
                
                timer = 0;
            }
        
            if(handler.getKeyManager().down)
            {   
                currentCommand++;
                if(currentCommand > 4)currentCommand = 4;
                
                timer = 0;
            }  
            
        }
        
        if(handler.getKeyManager().enter)
        {
            if(currentCommand == 4)
            {
                currentCommand = -1;
                handler.setState(handler.getMenuState());
            }
        }
        
    }
    
    private BufferedImage getCurrentAnimationFrame()
    {
       switch(currentCommand)
        {
            case 0:
                return walk.getCurrentFrame();
            case 1:
                return climb.getCurrentFrame();
        }
        return null;
    }

    @Override
    public void update() 
    {    
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        switch(currentCommand)
        {
            case 0:
                walk.update();
                break;
            case 1:
                climb.update();
                break;
        }
        
        getInput();
    }

    @Override
    public void draw(Graphics g) 
    {   
        //Background
        g.setColor(Color.black);
        g.fillRect(0, 0, handler.getWindowWidth(), handler.getWindowHeight());
        //Commands
        g.setFont(new Font("MyFont", Font.PLAIN, 30));
        g.setColor(Color.white);
        g.drawString("Commands List", 200, 130);
        
        for (int i = 0; i < Commands.length; i++) 
        {   
            if(i == currentCommand) g.setColor(Color.yellow);
            else g.setColor(Color.white);
            g.drawString(Commands[i], 200, 180 + (i * 50));
        }  
        
        g.setColor(Color.yellow);
        switch(currentCommand)
        {
            case 0:
                g.drawString("use → and ←", 300, 180);
                g.drawImage(getCurrentAnimationFrame(), 500, 155, 20, 25, null);
                break;
            case 1:
                g.drawString("use ↑ and ↓", 300, 230);
                g.drawImage(getCurrentAnimationFrame(), 500, 205, 20, 25, null);
                break;
            case 2:
                g.drawImage(Assets.playerAttackIdleL, 500, 260, null);
                g.drawString("use X", 300, 280);
                break;
            case 3:
                g.drawString("use ESC", 300, 330);
            default:
        }
                
    }
    
}
