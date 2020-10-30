package vector_calc;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;

public class VectorDraw extends JFrame {

    //Works by creating a new frame/window and THEN drawing the vector

    public VectorDraw (){
        setTitle("Drawn Vector");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    //(int x, int y, double mag, double angle) <-- parameters for later.
    //Changed from paintComponent
    public void paintComponent (Graphics g){
        //paintComponent is inbuilt !!! MUST use it here
        g.fillRect(0, 0, 5, 5);
        //parameters above are for coordinate spot, length (magnitude) and direction pointing (angle)

        //int size = (int)mag; <-- for "mag" parameter later
        //typecast magnitude, a double, into the integer size so that no errors occur when using a double in an integer parameter


        //size is in the "width" parameter
        //Need a way to make it point a certain direction
        //g.fillRect(x, y, size, 15);
    }
}
