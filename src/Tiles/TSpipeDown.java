
package Tiles;

import Graphic.Assets;


public class TSpipeDown extends Tile
{
    public TSpipeDown(int id)
    {
        super(Assets.pipeDown, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
