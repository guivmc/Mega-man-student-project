
package Graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageLoader 
{
    public static BufferedImage loadImage(String filename)
    {
        try 
        {
            // read and return the image file
            return ImageIO.read(Graphic.ImageLoader.class.getResource(filename));
        } 
        catch (IOException ex) 
        {
            //close operation if it can't find or read the file
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
