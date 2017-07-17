package Tiles;

import Graphic.Assets;


public class TSpipeUp extends Tile
{
    public TSpipeUp(int id)
    {
        super(Assets.pipeUp, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
