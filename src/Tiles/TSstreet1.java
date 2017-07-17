
package Tiles;

import Graphic.Assets;


public class TSstreet1 extends Tile
{
     public TSstreet1(int id) 
    {
        super(Assets.street1, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
