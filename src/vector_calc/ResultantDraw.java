package vector_calc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class ResultantDraw extends JPanel {

    int magnitude;
    int direction;
    int xChange;
    int yChange;


    public ResultantDraw (double mag, double angle, double xDis, double yDis) {

        magnitude = (int) mag;
        direction = (int) angle;
        xChange = (int) xDis;
        yChange = (int) yDis;

    }

    public void drawResult (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke2 = new BasicStroke(6f);
        g2.setStroke(stroke2);
        Line2D lin = new Line2D.Float(50, 400, 50 + xChange, 400 - yChange);
        g2.draw(lin);
    }
}