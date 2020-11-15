package vector_calc;

import javax.swing.*;
import java.awt.*;

public class HeadDraw extends JPanel{

    int magnitude;
    int trimag;
    int direction;

    public HeadDraw(double mag, double angle) {
        magnitude = (int) mag;
        trimag = this.magnitude + 50;
        //Set corner x coordinate
        direction = (int) angle;

    }

    public void drawTri(Graphics g){
        //typecast magnitude, a double, into the integer size so that no errors occur when using a double in an integer parameter
        Graphics2D g2d = (Graphics2D) g.create();
        trimag = this.magnitude + 50;
        //Set corner x coordinate
        g2d.rotate((this.direction * Math.PI) / 180);
        //Draw triangle
        int[] x = {this.trimag, this.trimag + 20, this.trimag};
        //Set y coordinate
        int[] y = {45, 58, 70};
        g2d.setColor(new Color(0, 0, 0));
        g2d.fillPolygon(x, y, 3);
    }
}
