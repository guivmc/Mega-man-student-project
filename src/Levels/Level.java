package Levels;

import Entities.EntityManager;
import Entities.Player;
import Entities.StaticCar;
import Entities.StaticGrave;
import Entities.StatickTrashBlockB;
import Entities.TrashMan;
import Tiles.Tile;
import Utils.Util;
import java.awt.Graphics;
import mega_man.Handler;

public class Level 
{
   //Level width and height
   private int width, height;
   private int spawnX, spawnY;
   
   //rows X and columns Y
   private int [][] levelTile;
   
   private Handler handler;
   
    
   //Entities
   private EntityManager entityManager;
   
   public Level(Handler handler,String path)
   {
       this.handler = handler;
       
       //Player
       entityManager = new EntityManager(handler);
       //Level
       loadLevel(path);
       entityManager.addCreature(new Player (handler, spawnX, spawnY));
       
       //Bosses
       entityManager.addCreature(new TrashMan(handler, 20, 340));
       entityManager.addCreature(new TrashMan(handler, 600, 340));
       entityManager.addCreature(new TrashMan(handler, 20, 220));
       //StaticsEntities
       entityManager.addStaticEntity(new StaticCar (handler, 0, 368));
       entityManager.addStaticEntity(new StaticCar (handler, 400, 368));
       entityManager.addStaticEntity(new StaticGrave (handler, 280, 240));
       entityManager.addStaticEntity(new StatickTrashBlockB(handler, 150, 368));
       entityManager.addStaticEntity(new StatickTrashBlockB(handler, 600, 257));
   }
   
   private void loadLevel(String path)
   {
       String file = Util.loadFileAsString(path);
       //Separetes the characters in the String. Uses the space as the condition
       //to separete them... It ignores the space character.
       String[] tokens = file.split("\\s+");
       
       //Sets width to the first number in the string
       width = Util.parseInt(tokens[0]);
       //Sets height to the second number in the string
       height = Util.parseInt(tokens[1]);
       
       spawnX = Util.parseInt(tokens[2]);
       spawnY = Util.parseInt(tokens[3]);
       
       //Defines the size of the level
       levelTile = new int [width][height];
       
       for (int y = 0; y < height; y++)
        {
             for(int x = 0; x < width; x++)
             {
                 //Set the id of the tiles in there current position.
                 //                     Convert tokens to a 1 dimensional Array
                 //                     and ignore the first for number( + 4)
                 //                     because those 4 number are the width, height,
                 //                     and player x and y.
                 levelTile[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
             }
        }
       
       //gatherSolidTiles();
   }
   
   public void update()
   {
       entityManager.update();
   }
   
   public void draw(Graphics g)
   {
       //This will only draw the tiles that we can see.
       //xStart will be the biggest number... 0 or (xOffset / 16).
       int xStart = (int) Math.max(0, handler.getGameCamera().getXOffset() / Tile.TILESIZE);
       //xEnd will be the smallest number... 0 or ((xOffset + game width) / 16) + 1... game width = 640.
       int xEnd = (int) Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWindowWidth()) / Tile.TILESIZE + 1);
       
       int yStart = (int) Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILESIZE);
       
       int yEnd = (int) Math.min(height, (handler.getGameCamera().getYOffset() + handler.getWindowHeight()) / Tile.TILESIZE + 1);
       
       //Draw Level
        for (int y = yStart; y < yEnd; y++)
        {
             for(int x = xStart; x < xEnd; x++)
             {
                 //Set the tiles positions, so it will draw tiles with 16 pixels
                 //                                 of distance from each other.
                 getTile(x, y).draw(g,(int) (x * Tile.TILESIZE - handler.getGameCamera().getXOffset()), 
                         (int) (y * Tile.TILESIZE - handler.getGameCamera().getYOffset()));
             }
        }
        
        entityManager.draw(g);
   }
   
   public Tile getTile(int x, int y)
   {
       if(x < 0 || y < 0 || x >= width || y >= height)
       {
           return Tile.tileTSbackgroundGreen;
       }
       
       //Set t to be the tile in the tilesArray in the position of levelTile on X and Y
       Tile t = Tile.tilesArray[levelTile[x][y]];
       
       if (t == null)
       {
           return Tile.tileTSbackgroundGreen;
       }
       
       return t;
   }
   
   
   
   //Gets
   public int getLevelWidth()
   {
       return width;
   }
   
   public int getLevelHeight()
   {
       return height;
   }
   
   public EntityManager getEntityManager()
   {
       return entityManager;
   }
}
