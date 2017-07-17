
package Tiles;

import Graphic.Assets;


public class TSbrokenfence extends Tile
{

     
    public TSbrokenfence(int id) 
    {
        super(Assets.brokenfence, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
    
}
