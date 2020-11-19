package vector_calc;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorCanvas extends JPanel{

    //Works by creating a new frame/window and THEN drawing the vector

    private Vector<VectorDraw> legs = new Vector<>();
    private Vector<HeadDraw> heads = new Vector<>();
    private ResultantDraw solid;

    public VectorCanvas (double magnitude, double direction, double horizontal, double vertical){
        JFrame jF = new JFrame();

        jF.setTitle("Drawn Vector");
        int width = (int) horizontal;
        int height = (int) vertical;
        jF.setSize(200 + width,100 + height);
        jF.setVisible(true);

        //draws diagonal vector
        solid = new ResultantDraw(magnitude, direction, horizontal, vertical, 50);


        //draws flat bottom line
        legs.add(new VectorDraw(0, 0.0,  horizontal, vertical, 50 + height));

        //draws flat vertical line
        legs.add(new VectorDraw(0, 90.0, 0.0, vertical, 50));



        //draws arrow head
        heads.add(new HeadDraw(magnitude, direction, horizontal, vertical));


        //Graphics a = null; //Fixed the enormous clutter of the old graphics object initialization

        //addShape(rectangle);
        jF.add(this);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VectorDraw shape : legs) {
            shape.drawRect(g);
        }
        solid.drawResult(g);
        for (HeadDraw tri : heads) {
            tri.drawTri(g);
        }

    }




}
