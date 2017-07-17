
package mega_man;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Display 
{
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    public Display(String t, int w, int h)
    {
        this.title = t;
        this.width = w;
        this.height = h;
        
        createDisplay();
    }

    private void createDisplay() 
    {
        //create and set JFrame
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create and set canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        //add canvas to the JFrame
        frame.add(canvas);
        frame.pack();
    }
    
    
    //gets
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
}
