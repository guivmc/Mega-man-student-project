package Tiles;

import Graphic.Assets;


public class TSbrokenstreet2 extends Tile 
{
    public TSbrokenstreet2(int id) 
    {
        super(Assets.brokenstreet2, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
    
}
