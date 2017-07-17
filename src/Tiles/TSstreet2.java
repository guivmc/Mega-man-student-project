
package Tiles;

import Graphic.Assets;


public class TSstreet2 extends Tile
{
    
    public TSstreet2(int id) 
    {
        super(Assets.street2, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
