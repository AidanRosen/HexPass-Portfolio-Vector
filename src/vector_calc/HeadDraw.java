package vector_calc;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HeadDraw extends JPanel{

    int magnitude;
    int trimag;
    int direction;
    int xChange;
    int yChange;

    public HeadDraw(double mag, double angle, double xDis, double yDis) {
        magnitude = (int) mag;
        trimag = this.magnitude + 50;
        //Set corner x coordinate
        direction = (int) angle;
        xChange = (int) xDis;
        yChange = (int) yDis;

    }

    public void drawTri(Graphics g){
        //typecast magnitude, a double, into the integer size so that no errors occur when using a double in an integer parameter
        Graphics2D g2d = (Graphics2D) g.create();
        trimag = this.magnitude + 50; //a buffer for the first point
        //Set corner x coordinate
        //Draw triangle
        g2d.rotate((this.direction * Math.PI) / 180, 50 + xChange, 50); //This is what rotates the triangle, using radians
        //Set the x: and y: parameter to the final coordinate at the tip of the vector!
        int[] x  = {25 + xChange, 50 + xChange, 75 + xChange};
        int [] y = {75, 25, 75};
        //Where these y values are around the coordinate (x, 150)
        //int[] x = {this.trimag, this.trimag + 20, this.trimag};
        //Set y coordinate
        //int[] y = {45, 58, 70}; //45 is the trimag, middle is is the "central" or top point,
        Random rand = new Random();
        float r = rand.nextFloat();
        float z = rand.nextFloat();
        float b = rand.nextFloat();
        g2d.setColor(new Color(r, z, b)); //Creates random color every time you open the program
        g2d.fillPolygon(x, y, 3);

    }
}
