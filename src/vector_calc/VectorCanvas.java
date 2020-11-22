package vector_calc;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JFrame;
import java.util.Vector;

public class VectorCanvas extends JPanel{

    //Works by creating a new frame/window and THEN drawing the vector

    private Vector<VectorDraw> legs = new Vector<>();
    private Vector<HeadDraw> heads = new Vector<>(); //Vector is an extension of stack and acts similarly to an ArrayList
    private ResultantDraw solid; //Need to use a separate object that is an instanced variable so that it can render in the for loop below 

    public VectorCanvas (double magnitude, double direction, double horizontal, double vertical){
        JFrame jF = new JFrame();

        jF.setTitle("Drawn Vector");
        int width = (int) horizontal;
        int height = (int) vertical;
        jF.setSize(200 + width,100 + height); //Doing 200 + width and 100 + height, where width and height are integers, allows for dynamic window building because width and height come from the data numbers
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
        //MUST render everything at once and we MUST do that with a for loop so that we avoid repaint painting over and erasing previous components
        for (VectorDraw shape : legs) {
            shape.drawRect(g);
        }
        //Here render the Resultant defined at the very top (private ResultantDraw solid) outside a for loop because there is only one 
        solid.drawResult(g);
        for (HeadDraw tri : heads) {
            tri.drawTri(g);
        }

    }




}
