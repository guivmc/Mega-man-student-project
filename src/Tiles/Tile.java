package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Tile 
{
    //STATIC STUFF
    
    public static Tile[] tilesArray = new Tile[25];
    
    public static Tile tileTSbackgroundGreen = new TSbackgroundGreen(0);
    public static Tile tileTSrocks = new TSrocks(1);
   //public static Tile tileTSbrokenfence = new TSbrokenfence(2);
    
    public static Tile tileTSstreet1 = new TSstreet1(2);
    public static Tile tileTSstreet2 = new TSstreet2(3);
    public static Tile tileTSbrokenstreet1 = new TSbrokenstreet1(4);
    public static Tile tileTSbrokenstreet2 = new TSbrokenstreet2(5);
    
    public static Tile tileTSpipes1 = new TSpipes1(7);
    public static Tile tileTSpipes2 = new TSpipes2(8);
    public static Tile tileTSpipeUp = new TSpipeUp(9);
    public static Tile tileTSpipeDown = new TSpipeDown(10);
    
  
  
  
    
    
    //CLASS
    public static final int TILESIZE = 16, TILESIZEBITS = 4;//2^TILESIZEBITS = TILESIZE
    public Rectangle bounds;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        bounds = new Rectangle(0 ,0 , TILESIZE, TILESIZE);   
        
        tilesArray[id] = this;
    }
    
    public void update()
    {
        
    }
    
    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILESIZE, TILESIZE, null);
    }
    
    // Collision
    public boolean isSolid()
    {
        return false;
    }
    
   /* public static int pixelsToTiles(int pixels)
    {
        return pixels >> TILESIZEBITS;
        //It will take the binary number and move it to
        //right TILESIZEBITS times.
        //pixels = 12 = 1100
        //0110-0011-0001-0000-> It will return 0.
        //Helps avoid negatives.
    }
    
    public static int tilesToPixels(int tiles)
    {
        return tiles << TILESIZEBITS;
        //It will take the binary number and move it to
        //left TILESIZEBITS times.
        //pixels = 12 = 1100
        //1000-0000-0000-0000-> It will return 0.
        //Helps avoid negatives.
    }*/
    
    public int getID()
    {
        return id;
    }
    
}
