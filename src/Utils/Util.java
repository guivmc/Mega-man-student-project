package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Util 
{
    //Read the txt file and pass it to a string
    public static String loadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();
        
        try
        {
            //txt file to be read
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            //Read all the lines till it finds a null line
            while((line = br.readLine()) != null)
            {
                builder.append(line + System.lineSeparator());
            }
            //if it found a null line, close it
            br.close();
        }
        catch(IOException e)
        {
          e.printStackTrace();
        }
        //Return the txt file in a string
        return builder.toString();
    }
    
    // Read the number in a string
    public static int parseInt(String number)
    {
       try 
       {
           //return the numbers
           return Integer.parseInt(number);
       }
       //if there is something that is not a number, close the operation 
       catch (NumberFormatException e)
       {
           e.printStackTrace();
           return 0;
       }
    }
}
