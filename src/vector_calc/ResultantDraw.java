package vector_calc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class ResultantDraw extends JPanel {

    int magnitude;
    int direction;
    int xChange;
    int yChange;
    int yFinal;

    public ResultantDraw (double mag, double angle, double xDis, double yDis, int finalY) {

        magnitude = (int) mag;
        direction = (int) angle;
        xChange = (int) xDis;
        yChange = (int) yDis;
        yFinal = finalY;

    }

    public void drawResult (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke2 = new BasicStroke(6f);
        g2.setStroke(stroke2);
        Line2D lin = new Line2D.Float(50, 50 + yChange, 50 + xChange, yFinal);
        Random rand = new Random();
        float r = rand.nextFloat();
        float z = rand.nextFloat();
        float b = rand.nextFloat();
        g2.setColor(new Color(r, z, b)); //Creates random color every time you open the program
        g2.draw(lin);
    }
}