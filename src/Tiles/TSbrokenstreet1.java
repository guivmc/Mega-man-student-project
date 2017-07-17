package Tiles;

import Graphic.Assets;


public class TSbrokenstreet1 extends Tile 
{
    public TSbrokenstreet1(int id) 
    {
        super(Assets.brokenstreet1, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
