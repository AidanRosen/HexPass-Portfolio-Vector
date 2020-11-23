package AJGraphingCalculator.View;

import AJGraphingCalculator.Model.Point;
import AJGraphingCalculator.View.GraphingCalculatorUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TheGraph extends JFrame
{
    static ArrayList<Integer> xCords;
    static ArrayList<Integer> yCords;
    static int width;
    static ArrayList<Integer> height;
    static int totalCords;

    int iterator = 0;

    static int testvalue = 40;

    ArrayList<Point> Cords;

    public JTextField SleepBar = new JTextField();

    public void setCords(ArrayList<Point> Cords) {
        this.Cords = Cords;
    }




    public TheGraph()
    {
        int domain1, domain2, range1, range2;
        domain1 = -250;
        domain2 = 250;
        range1 = -250;
        range2 = 250;

        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(domain2-domain1, range2-range1);
        //Graph.setResizable(false);
        getContentPane().setLayout(null);
        // setBounds(100, 100, domain2-domain1, range2-range1);
        Rectangle rect = new Rectangle(250, 0, 5, 500);

        //add(this);
    }



    @Override
    public void paint(Graphics g)
    {
        //super.paint(g);





        Graphics2D gui = (Graphics2D) g;

        Rectangle rect = new Rectangle(this.xCords.get(iterator), this.yCords.get(iterator), this.width, this.height.get(iterator));

        if (iterator == 0) {
            rect = new Rectangle(250, 0, 5, 500);
            gui.fill(rect);
            rect = new Rectangle(0, 250, 500, 5);
            gui.fill(rect);
        }


        gui.fill(rect);

        g.setColor(Color.black);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        iterator++;
        if (iterator < totalCords)
        {
            repaint();
        }




    }




    public TheGraph(ArrayList<Integer> xCordinates,  ArrayList<Integer> yCordinates, int widths, ArrayList<Integer> heights, int totalCordnumbers) throws InterruptedException {
        this.xCords = xCordinates;
        this.yCords = yCordinates;
        this.width = widths;
        this.height = heights;
        this.totalCords = totalCordnumbers;

        grapher();


    }

    public static void grapher() throws InterruptedException {

        TheGraph Graph = new TheGraph();
        Graph.setVisible(true);


        testvalue = testvalue + 40;
        Graph.repaint();
        // SleepBar.setText(String.valueOf(i));



    }






}


