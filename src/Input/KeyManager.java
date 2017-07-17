
package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener
{
    public boolean keys[] = new boolean[5];
    public boolean up, down, left, right, spaceBar, enter, esc, fire;
    
    public KeyManager()
    {

    }
     
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_UP) up = true;
        if(key == KeyEvent.VK_DOWN) down = true;
        if(key == KeyEvent.VK_LEFT) left = true;
        if(key == KeyEvent.VK_RIGHT) right = true;
        if(key == KeyEvent.VK_SPACE) spaceBar = true;
        if(key == KeyEvent.VK_ENTER) enter = true;
        if(key == KeyEvent.VK_ESCAPE) esc = true;
        if(key == KeyEvent.VK_X) fire = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_UP) up = false;
        if(key == KeyEvent.VK_DOWN) down = false;
        if(key == KeyEvent.VK_LEFT) left = false;
        if(key == KeyEvent.VK_RIGHT) right = false;
        if(key == KeyEvent.VK_SPACE) spaceBar = false;
        if(key == KeyEvent.VK_ENTER) enter = false;
        if(key == KeyEvent.VK_ESCAPE) esc = false;
        if(key == KeyEvent.VK_X) fire = false;
    }  
    
    public boolean NoKeysDown()
    {
        keys[0] = up;
        keys[1] = down;
        keys[2] = left;
        keys[3] = right;
        keys[4] = spaceBar;
        //keys[5] = spaceBar;

        for (int i = 0; i < keys.length; i++) 
        {
           if(keys[i] == true) return false;
        }
 
        return true;
    }
}
