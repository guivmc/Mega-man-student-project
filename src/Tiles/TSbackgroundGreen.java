package Tiles;

import Graphic.Assets;


public class TSbackgroundGreen extends Tile
{
    public TSbackgroundGreen(int id) 
    {
        super(Assets.backgroundGreen, id);
    }   
    
    
    @Override
    public boolean isSolid()
    {
        return false;
    }
}
