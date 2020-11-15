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

    public VectorCanvas (double magnitude, double direction){
        JFrame jF = new JFrame();

        jF.setTitle("Drawn Vector");
        jF.setSize(500,500);
        jF.setVisible(true);


        legs.add(new VectorDraw(magnitude, direction));
        legs.add(new VectorDraw(200.0, 30.0));
        heads.add(new HeadDraw(magnitude, direction));


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
