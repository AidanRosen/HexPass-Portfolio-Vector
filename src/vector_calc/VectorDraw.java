package vector_calc;


import javax.swing.*;
import java.awt.*;

public class VectorDraw extends JPanel{

    int magnitude;
    int direction;
    int trimag;


    public VectorDraw (double mag, double angle){

        magnitude = (int) mag;
        direction = (int) angle;
        trimag = this.magnitude + 50;

    }

    public void drawRect(Graphics g){

        super.paintComponent(g);
        //paintComponent is inbuilt !!! MUST use it here
        System.out.println(this.magnitude);
        System.out.println("The above is the value for size");
        g.fillRect(250, 250, this.magnitude, 5);



        //In a 500x500 frame, (250,250) is the central coordinate
        //Need a way to modify the parameters of FILLRECTANGLE and not the PAINT parameters
        //parameters above are for coordinate spot, length (magnitude) and direction pointing (angle)

        //typecast magnitude, a double, into the integer size so that no errors occur when using a double in an integer parameter

        //size is in the "width" parameter
        //Need a way to make it point a certain direction
        //g.fillRect(x, y, size, 15);
    }
}
