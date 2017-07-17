
package Tiles;

import Graphic.Assets;


public class TSpipes2 extends Tile
{
    public TSpipes2(int id)
    {
        super(Assets.pipes2, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
