//to launch this menu option: create an instance of a graph object in the menu file
package Graphing_Calculator.Model_Files;
//Alex Hu-imported from the calculator project
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods
import Graphing_Calculator.Control_Files.GraphCubicControl; //allows for extending of GraphCubicControl, which is not in the same package

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class GraphCubic extends GraphCubicControl { //I think this also extends JFrame automatically as GraphingCalculatorUI extends JFrame
    //inheritance: inherits all the methods and public variables from GraphingCalculatorUI, but you can also write your own additional methods or override them by declaring a method that has the same name as a method in GraphingCalculatorUI but make it do different things

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphCubic frame = new GraphCubic();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphCubic () { //constructor for initializing labels and textboxes and add them to getcontentpane
        inputBox.setBounds(50, 140, 300, 40);
        inputBox2.setBounds(50, 140, 300, 40);
        inputBox3.setBounds(50, 140, 300, 40);
        inputBox4.setBounds(50, 140, 300, 40);
        inputBox5.setBounds(50, 140, 300, 40);
        inputBox6.setBounds(50, 140, 300, 40);
        inputBox7.setBounds(50, 140, 300, 40);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = inputBox.getText(); //gets text from user input in textbox
                promptB(); //prompts for second input
                Graph(a, b, c, d, magX, magY, smoothness); //no need to redeclare these variables as GraphCubic inherits all these variables from GraphCubicControl
                //Calls Graph when promptB() returns
                //After promptB is called, each of the other prompts are called by the previous prompt method until the last one (promptSmoothness) when every one of the methods return and promptB returns
            }
        });

        prompt.setBounds(50, 86, 500, 40);

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        getContentPane().add(prompt);
        getContentPane().add(inputBox);
    }

    public void resetScreen() {
        getContentPane().removeAll();
        repaint();
    }

    public void Graph(String a1, String b1, String c1, String d1, String magx1, String magy1, String smoothness1) {

        try {
            double numTest = (double)Integer.parseInt(a1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic(); //need to change
            System.out.println("failed"); //change to rerun program
        }

        try {
            double numTest = (double)Integer.parseInt(b1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        try {
            double numTest = (double)Integer.parseInt(c1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        try {
            double numTest = (double)Integer.parseInt(d1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        try {
            double numTest = (double)Integer.parseInt(magx1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        try {
            double numTest = (double)Integer.parseInt(magy1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        try {
            double numTest = (double)Integer.parseInt(smoothness1);
        } catch (NumberFormatException nfe) {
            resetScreen();
            prompt.setText("Please enter only numbers");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        double sola, solb, vertexX;
        double a = Double.parseDouble(a1), b = Double.parseDouble(b1), c = Double.parseDouble(c1), d = Double.parseDouble(d1), magX = Double.parseDouble(magx1), magY = Double.parseDouble(magy1), smoothness = Double.parseDouble(smoothness1);

        if (magX < 0.1 || magX > 10 || magY < 0.1 || magY > 10) {
            resetScreen();
            GraphCubic.prompt.setText("Magnitudes must be between 0.1 and 10");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        if (smoothness < 0.01 || smoothness > 1) {
            resetScreen();
            prompt.setText("Smoothness must be between 0.01 and 10");
            GraphCubic newGraphCubic1 = new GraphCubic();
            System.out.println("failed");
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (i == 50) {
                    GraphMain.Graph[i][j] = new JLabel("-");
                } else if (j == 50) {
                    GraphMain.Graph[i][j] = new JLabel("|");
                } else {
                    GraphMain.Graph[i][j] = new JLabel(" ");
                }
            }
        }

        double domainLower = -50.0 * magX;
        double domainUpper = 50.0 * magX;
        double rangeLower = -50.0 * magY;
        double rangeUpper = 50.0 * magY;

        for (double x = domainLower; x < domainUpper; x += smoothness * magX) { //GraphCubics into a 2d array
            double y = (a * x * x * x + b * x * x + c * x + d); //plugs in x

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) {
                GraphMain.Graph[50 - (int) Math.round((y / magY))][50 + (int) Math.round((x / magX))].setText("0"); //inputs into array scaled based on magnitude (eg if mag is 0.1 then each space in the graph/array is equal to 0.1 instead of 1/zooms in by 10x into the graph
                //50 is the axes
                //eg if y is -20, the program puts a 0 in the 2d array at row 50 - (-20) = row 70 from the top
                //if x is 10, the program puts a 0 in column 50 + 10 = column 60 of the 2d array
                //so "0" is inserted at (60, 70) or (10, -20) in graphical terms
            }
        }
        
        GraphingCalculatorUI display = new GraphingCalculatorUI(); //calls constructor of view/ui file

        if ((int) a == 0 && (int) b != 0) { //if quadratic
            if (((int) c * (int) c - 4 * (int) b * (int) d) > 0) { //check if quadratic has 0, 1, or 2 solutions
                JLabel Sol1 = new JLabel();
                Sol1.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b)); //quadratic formula
                solb = ((c - c - c - Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol1.setText("Roots (quadratic): " + sola + ", " + solb);
                getContentPane().add(Sol1);

                JLabel Vert1 = new JLabel();
                Vert1.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b)); //x-val of vertex
                Vert1.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")"); //y-val of vertex
                getContentPane().add(Vert1);
            } else if (((int) c * (int) c - 4 * (int) b * (int) d) == 0) {
                JLabel Sol2 = new JLabel();
                Sol2.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol2.setBounds(1100, 50, 500, 40);
                Sol2.setText("Root (quadratic): " + sola);
                getContentPane().add(Sol2);

                JLabel Vert2 = new JLabel();
                Vert2.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert2.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert2);
            } else {
                JLabel Sol3 = new JLabel();
                Sol3.setBounds(1100, 50, 500, 40);

                Sol3.setBounds(1100, 50, 500, 40);
                Sol3.setText("No real solutions");
                getContentPane().add(Sol3);

                JLabel Vert3 = new JLabel();
                Vert3.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert3.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert3);
            }
        } else if ((int) a == 0 && (int) b == 0 && (int) c != 0) { //if linear
            JLabel Sol4 = new JLabel();
            Sol4.setBounds(1100, 50, 500, 40);

            Sol4.setText("Solution (linear): " + (d - d - d) / c); //formula for solution of linear
            getContentPane().add(Sol4);
        }

        JLabel Yint = new JLabel();
        Yint.setBounds(1100, 50, 500, 40);

        Yint.setBounds(1100, 150, 500, 40);
        Yint.setText("Y-intercept: " + d);
        getContentPane().add(Yint);
    }
}