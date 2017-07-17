package mega_man;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import Graphic.Assets;
import Graphic.GameCamera;
import Input.KeyManager;
import States.State;

public class Game implements Runnable
{
    //game variables
    private int width, height;
    private String title;
    private boolean running = false;
    
    //Graphical stuff
    private Thread thread;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    
    //input
    private KeyManager km;
    
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    
    
    public Game(String t, int w, int h)
    {
        this.width = w;
        this.height = h;
        this.title = t;
        km = new KeyManager();
    }
    
    private void init()
    {
        //display and input
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(km);
        //init Assets
        Assets.init();
        
        //Handler
        handler = new Handler(this);
        
        //gameCamera
        gameCamera = new GameCamera(handler, 0, 0);
        
        //state
        handler.setState(handler.getMenuState());
    }
    
    private void update()
    {
        //States update
        if(State.getState() != null)
        {
            State.getState().update();
        }

    }
    
    private void draw()
    {
        //get the canvas in the memory
        bs = display.getCanvas().getBufferStrategy();
        //if bs does was not set, set it to have 3 canvas in the memory 
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        //get bs to draw
        g = bs.getDrawGraphics();
        //clear
        g.clearRect(0, 0, width, height);
        //draw
        if(State.getState() != null)
        {
            State.getState().draw(g);
        }
        //end draw
        bs.show();
        g.dispose();
    }
    
    public void run()
    {
       init(); 
       
       //FPS
       int fps = 60;
       double timePerUpdate = 1000000000 / fps;
       double delta = 0;
       long now;
       long lastTime = System.nanoTime();
       
       while(running)
       {
           //FPS
           now = System.nanoTime();
           delta += (now - lastTime) / timePerUpdate;
           lastTime = now;
           
           if(delta >= 1)
           {               
               update();
               draw();
               delta--;
           }
       }
       
       stop();
    }
    
    //Create and start only one thread  
    public synchronized void start()
    {
        if(running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        //call run();
        thread.start();
    }
    
    //Stop that thread
    public synchronized void stop()
    {
        if(!running)
        {
            return;
        }
        running = false;
        try 
        {
            thread.join();
        } 
        catch (InterruptedException ex) 
        {
            //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    
    
    //Gets
    
    //Input
    public KeyManager getKeyManager()
    {
        return km;
    }
    
    //Camera
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
    
    //Screen size
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}
