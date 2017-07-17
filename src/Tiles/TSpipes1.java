package Tiles;

import Graphic.Assets;


public class TSpipes1 extends Tile
{
    public TSpipes1(int id)
    {
        super(Assets.pipes1, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
