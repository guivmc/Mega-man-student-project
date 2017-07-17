package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import mega_man.Handler;


public class EntityManager
{
    private Handler handler;

    private Player player;
    
    
    private ArrayList <Entity> staticEntities;
    
    private ArrayList <Bullet> bullets;

    private ArrayList <Creatures> creatures;
    
    public EntityManager(Handler handler)
    {
        this.handler = handler;
 
        staticEntities = new ArrayList <Entity>();
        bullets = new ArrayList <Bullet>();

        creatures = new ArrayList <Creatures>();

    }
 
    public void update()
    {
        if(!handler.getPaused())
        {
            for(int i = 0; i < creatures.size(); i++)
            {
                //entities[i]       at
                Creatures c = creatures.get(i);
                c.update();
                
                if(!bullets.isEmpty())
                {
                    for (int j = 0; j < bullets.size(); j++) 
                    {
                        Bullet b = bullets.get(j);
                        //Hit detection;
                        if(c.getCollisionBounds(b.getVel(), 0).intersects(b.getCollisionBounds(0, 0)))
                        {
                            c.HP -= 5;
                            removeBullet(b);
                        }
                    }
                } 
            }
            for (int i = 0; i < bullets.size(); i++) 
            {
                Bullet b = bullets.get(i);
                b.update();
            }
            
            //hit();
        }

    }
    
    public void draw(Graphics g)
    {
        //This is equal the for loop in update above
        for(Entity se : staticEntities)
        {
            se.draw(g);
        }
        
        for(Bullet b : bullets)
        {
            b.draw(g);
        }
        
        for(Creatures c : creatures)
        {
            c.draw(g);
        }
    }
        
    
    public void addStaticEntity(Entity se)
    {
        staticEntities.add(se);
    }
    
    public void addBullet(Bullet b)
    {
        bullets.add(b);
    }
    
    public void addCreature(Creatures c)
    {
        creatures.add(c);
    }
  
    
    public void removeBullet(Bullet b)
    {
        bullets.remove(b);
    }
    
    public void removeCreature(Creatures c)
    {
        creatures.remove(c);
    }
      
    //Gets
    public Handler getHandler()
    {
        return handler;
    }

    public ArrayList<Entity> getStaticEntities()
    {
        return staticEntities;
    }
    
    public ArrayList<Bullet> getBullets()
    {
        return bullets;
    }
    
    public ArrayList<Creatures> getCreatures()
    {
        return creatures;
    }
    
    //Sets
    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }
    
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public void setStaticEntities(ArrayList <Entity> staticEntities)
    {
        this.staticEntities = staticEntities;
    }
}
