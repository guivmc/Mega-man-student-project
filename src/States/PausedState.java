package States;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import mega_man.Handler;


public class PausedState extends State
{
    private String[] pausedChoices = new String[3];
    private int currentPaused = -1;
    
    public PausedState(Handler handler) 
    {
        super(handler);
        pausedChoices[0] = "Return to menu";
        pausedChoices[1] = "Resume";
        pausedChoices[2] = "Exit";
    }
    
    private void getInput()
    {
        if(timer > 100)
        {
            if(handler.getKeyManager().up)
            {  
                currentPaused--;
                if(currentPaused < 0) currentPaused = 0;
                
                timer = 0;
            }
        
            if(handler.getKeyManager().down)
            {   
                currentPaused++;
                if(currentPaused > 2)currentPaused = 2;
                
                timer = 0;
            }
        }
        
        if(handler.getKeyManager().enter)
        {
            switch (currentPaused) 
            {
                case 0:
                    handler.setState(handler.getMenuState());
                    break;
                case 1:
                    handler.setState(handler.getGameState());
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
            handler.setPaused(false);
        }
    }

    @Override
    public void update() 
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        getInput();
    }

    @Override
    public void draw(Graphics g) 
    {
        handler.getLevel().draw(g);
        
        g.setFont(new Font("MyFont", Font.PLAIN, 30));
        g.setColor(Color.white);
        g.drawString("PAUSED", 250, 130);
        for (int i = 0; i < pausedChoices.length; i++) 
        {
            if(i == currentPaused) g.setColor(Color.yellow);
            else g.setColor(Color.white);
            
            g.drawString(pausedChoices[i], 250, 180 + (i * 50));
        }
    }
    
}
