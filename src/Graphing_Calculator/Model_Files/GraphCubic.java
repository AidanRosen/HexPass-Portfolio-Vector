//to launch this menu option: create an instance of a graph object in the menu file
package Graphing_Calculator.Model_Files;
//Alex Hu
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods
import Graphing_Calculator.Control_Files.GraphCubicControl; //allows for calling functions from GraphCubicControl, which is not in the same package

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphCubic extends JFrame { //I think this also extends JFrame automatically as GraphingCalculatorUI extends JFrame

    public static JLabel prompt = new JLabel("x^3 + ");
    public static JLabel prompt2 = new JLabel("x^2 + ");
    public static JLabel prompt3 = new JLabel("x + ");
    public static JLabel prompt4 = new JLabel(" = 0");
    public static JLabel prompt5 = new JLabel("Please enter the x magnitude/zoom level (0.1-10):");
    public static JLabel prompt6 = new JLabel("Please enter the y magnitude/zoom level (0.1-10):");
    public static JLabel prompt7 = new JLabel("Please enter the smoothness level (0.01-1):");
    public static JLabel errorMessage = new JLabel("");

    public static JTextField inputBox = new JTextField(10);
    public static JTextField inputBox2 = new JTextField(10);
    public static JTextField inputBox3 = new JTextField(10);
    public static JTextField inputBox4 = new JTextField(10);
    public static JTextField inputBox5 = new JTextField(10);
    public static JTextField inputBox6 = new JTextField(10);
    public static JTextField inputBox7 = new JTextField(10);

    public static JLabel Sol1 = new JLabel();
    public static JLabel Sol2 = new JLabel();
    public static JLabel Sol3 = new JLabel("No real solutions.");
    public static JLabel Sol4 = new JLabel();
    public static JLabel Vert1 = new JLabel();
    public static JLabel Vert2 = new JLabel();
    public static JLabel Vert3 = new JLabel();

    public static JButton Go = new JButton("Graph");

    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String magX = null, magY = null, smoothness = null;

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

    public void resetScreen() {
        getContentPane().removeAll(); //removes everything on the screen
        repaint(); //reapplies background color
    }

    public GraphCubic () { //constructor for initializing labels and textboxes and add them to getcontentpane
        resetScreen();
        inputBox.setBounds(50, 140, 70, 40);
        inputBox2.setBounds(170, 140, 70, 40);
        inputBox3.setBounds(290, 140, 70, 40);
        inputBox4.setBounds(410, 140, 70, 40);
        inputBox5.setBounds(50, 260, 300, 40);
        inputBox6.setBounds(600, 260, 300, 40);
        inputBox7.setBounds(1150, 260, 300, 40);

        prompt.setBounds(125, 140, 40, 40);
        prompt2.setBounds(245, 140, 40, 40);
        prompt3.setBounds(365, 140, 40, 40);
        prompt4.setBounds(485, 140, 40, 40);
        prompt5.setBounds(50, 200, 500, 40);
        prompt6.setBounds(600, 200, 500, 40);
        prompt7.setBounds(1150, 200, 500, 40);
        errorMessage.setBounds(460, 500, 1000, 50);

        Go.setBounds(700, 320, 100, 40);

        getContentPane().add(inputBox); //do it here instead of in the control file as the control file does not directly extend jframe and therefore getcontentpane doesn't work there
        getContentPane().add(inputBox2);
        getContentPane().add(inputBox3);
        getContentPane().add(inputBox4);
        getContentPane().add(inputBox5);
        getContentPane().add(inputBox6);
        getContentPane().add(inputBox7);

        getContentPane().add(prompt);
        getContentPane().add(prompt2);
        getContentPane().add(prompt3);
        getContentPane().add(prompt4);
        getContentPane().add(prompt5);
        getContentPane().add(prompt6);
        getContentPane().add(prompt7);
        getContentPane().add(errorMessage); //displays error message if there was one from last round, else displays blank

        getContentPane().add(Go);

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        GraphCubicControl.promptA(); //sets up the actionlisteners from control file which saves the user input
        GraphCubicControl.promptB();
        GraphCubicControl.promptC();
        GraphCubicControl.promptD();
        GraphCubicControl.promptXMagnitude();
        GraphCubicControl.promptYMagnitude();
        GraphCubicControl.promptSmoothness();
        Go.addActionListener(new ActionListener() {  //this has to be in here as Graph is not static and therefore cannot be accessed from the control file; if graph is made static, then non-static getcontentpane wouldn't work, and getcontentpane cannot be made static
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a != null && b != null && c != null && d != null && magX != null && magY != null && smoothness != null) {
                    Graph(a, b, c, d, magX, magY, smoothness);
                }
            }
        });
    }

    public void Graph(String a1, String b1, String c1, String d1, String magx1, String magy1, String smoothness1) {

        getContentPane().remove(errorMessage); //removes error message from last round
        String[] inputs = {a1, b1, c1, d1, magx1, magy1, smoothness1};

        for (int i = 0; i < 6; i++) { //todo: magx as 0.1 causes nfe, graph display not showing
            try {
                double numTest = Double.parseDouble(inputs[i]);
            } catch (NumberFormatException nfe) {
                resetScreen();
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //closes current window
                main(null); //creates new window and reruns program
            }
        }

        double sola, solb, vertexX;
        double a = Double.parseDouble(a1), b = Double.parseDouble(b1), c = Double.parseDouble(c1), d = Double.parseDouble(d1), magX = Double.parseDouble(magx1), magY = Double.parseDouble(magy1), smoothness = Double.parseDouble(smoothness1);

        if (magX < 0.1 || magX > 10 || magY < 0.1 || magY > 10) {
            resetScreen();
            errorMessage.setText("Magnitudes must be between 0.1 and 10");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            main(null);
        }

        if (smoothness < 0.01 || smoothness > 1) {
            resetScreen();
            errorMessage.setText("Smoothness must be between 0.01 and 10");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            main(null);
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

        GraphingCalculatorUI.main(null);

        if ((int) a == 0 && (int) b != 0) { //if quadratic
            if (((int) c * (int) c - 4 * (int) b * (int) d) > 0) { //check if quadratic has 0, 1, or 2 solutions
                Sol1.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b)); //quadratic formula
                solb = ((c - c - c - Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol1.setText("Roots (quadratic): " + sola + ", " + solb);
                getContentPane().add(Sol1);

                Vert1.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b)); //x-val of vertex
                Vert1.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")"); //y-val of vertex
                getContentPane().add(Vert1);
            } else if (((int) c * (int) c - 4 * (int) b * (int) d) == 0) {
                Sol2.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol2.setBounds(1100, 50, 500, 40);
                Sol2.setText("Root (quadratic): " + sola);
                getContentPane().add(Sol2);

                Vert2.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert2.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert2);
            } else {
                Sol3.setBounds(1100, 50, 500, 40);

                Sol3.setBounds(1100, 50, 500, 40);
                Sol3.setText("No real solutions");
                getContentPane().add(Sol3);

                Vert3.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert3.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert3);
            }
        } else if ((int) a == 0 && (int) b == 0 && (int) c != 0) { //if linear
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