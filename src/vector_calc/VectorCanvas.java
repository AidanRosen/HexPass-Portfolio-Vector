package vector_calc;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class VectorCanvas extends JPanel{

    //Works by creating a new frame/window and THEN drawing the vector

    private List<VectorDraw> legs = new ArrayList<>();
    private List<HeadDraw> heads = new ArrayList<>();

    public VectorCanvas (double magnitude, double direction, double horizontal, double vertical){
        JFrame jF = new JFrame();

        jF.setTitle("Drawn Vector");
        jF.setSize(500,500);
        jF.setVisible(true);

        legs.add(new VectorDraw(magnitude, direction,  horizontal, vertical));

        legs.add(new VectorDraw(0, 0.0,  horizontal, 0.0));
        //draws flat bottom line
        legs.add(new VectorDraw(0, 90.0, 0.0, vertical));
        //draws flat vertical line

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
        for (HeadDraw tri : heads) {
            tri.drawTri(g);
        }
    }




}
