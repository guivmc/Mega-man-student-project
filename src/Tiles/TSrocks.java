
package Tiles;

import Graphic.Assets;

public class TSrocks extends Tile 
{
    public TSrocks(int id) 
    {
        super(Assets.rocks, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
