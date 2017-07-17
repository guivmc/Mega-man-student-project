package States;

import Graphic.Assets;
import Levels.Level;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import mega_man.Handler;


public class MenuState extends State
{
    private String[] choices = new String[3];
    private int currentChoice = -1;
    
    private Level level;
    
    public MenuState(Handler handler)
    {
        super(handler);
        choices[0] = "START";
        choices[1] = "HELP";
        choices[2] = "EXIT";
        
        
        timer = 0;
        lastTime = System.currentTimeMillis();      
    }
    
    private void getInput()
    {
        if(timer > 100)
        {
            if(handler.getKeyManager().up)
            {  
                currentChoice--;
                if(currentChoice < 0) currentChoice = 0;
                
                timer = 0;
            }
        
            if(handler.getKeyManager().down)
            {   
                currentChoice++;
                if(currentChoice > 2)currentChoice = 2;
                
                timer = 0;
            }  
            
        }
        if(handler.getKeyManager().enter)
        {
            switch(currentChoice)
            {
                case 0:
                    level = new Level(handler, "src/res/worlds/Level1.txt");
                    handler.setLevel(level);
                    handler.setState(handler.getGameState());
                    break;
                case 1:
                    timer = 0;
                    handler.setState(handler.getHelpState());
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
            }
            currentChoice = -1;
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
        //Background
        g.setColor(Color.black);
        g.fillRect(0, 0, handler.getWindowWidth(), handler.getWindowHeight());
        //Logo
        g.drawImage(Assets.logo, 5, 20, null);
        //Choices
        g.setFont(new Font("MyFont", Font.PLAIN, 30));
        for (int i = 0; i < choices.length; i++) 
        {
            if(i == currentChoice) g.setColor(Color.yellow);
            else g.setColor(Color.white);
            
            g.drawString(choices[i], 270, 240 + (i * 50));
        }
           
    }
    
    
}
