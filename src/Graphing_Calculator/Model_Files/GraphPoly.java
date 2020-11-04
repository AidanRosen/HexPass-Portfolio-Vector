package Graphing_Calculator.Model_Files;
//ui: ask user for the coefficient and exponent value, then ask if they want another term after they finish entering
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

import Graphing_Calculator.Control_Files.GraphExpoControl;
import Graphing_Calculator.Control_Files.GraphPolyControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphPoly extends JFrame {

    public static ArrayList<String> inputsValsCoef = new ArrayList<String>();
    public static ArrayList<String> inputsValsExp = new ArrayList<String>();

    public static JButton go = new JButton("Graph");
    public static JButton next = new JButton("Enter next term");

    public JLabel label = new JLabel("x^");
    public static JLabel promptX = new JLabel("Please enter the x magnitude/zoom level (0.1-10):");
    public static JLabel promptY = new JLabel("Please enter the y magnitude/zoom level (0.1-10):");
    public static JLabel promptS = new JLabel("Please enter the smoothness level (0.01-1):");
    public static JLabel errorMessage = new JLabel("");
    public static JLabel XIntColon = new JLabel("Approximate x-intercept(s): ");
    public static JLabel YIntColon = new JLabel("Approximate y-intercept: ");

    public static JTextField inputBoxCoef = new JTextField("");
    public static JTextField inputBoxExp = new JTextField("");
    public static JTextField inputBoxX = new JTextField(10);
    public static JTextField inputBoxY = new JTextField(10);
    public static JTextField inputBoxS = new JTextField(10);

    public static ArrayList<Double> XInts = new ArrayList<Double>();
    public static ArrayList<JLabel> XIntDisplays = new ArrayList<JLabel>();
    public static double YInt = 0;
    public static JLabel YIntDisplay = new JLabel();

    public static String magX = null, magY = null, smoothness = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphPoly frame = new GraphPoly();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphPoly() { //constructor for initializing labels and textboxes and add them to getcontentpane
        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        label.setBounds(100, 100, 50, 50);
        go.setBounds(400, 350, 200, 100);
        next.setBounds(100, 350, 200, 100);
        promptX.setBounds(50, 200, 400, 40);
        promptY.setBounds(450, 200, 400, 40);
        promptS.setBounds(850, 200, 400, 40);
        errorMessage.setBounds(460, 500, 1000, 50);

        inputBoxCoef.setBounds(25, 100, 70, 50);
        inputBoxExp.setBounds(155, 100, 70, 50);
        inputBoxX.setBounds(50, 250, 400, 40);
        inputBoxY.setBounds(450, 250, 400, 40);
        inputBoxS.setBounds(850, 250, 400, 40);

        getContentPane().add(label);
        getContentPane().add(go);
        getContentPane().add(next);
        getContentPane().add(promptX);
        getContentPane().add(promptY);
        getContentPane().add(promptS);
        getContentPane().add(errorMessage);

        getContentPane().add(inputBoxCoef);
        getContentPane().add(inputBoxExp);
        getContentPane().add(inputBoxX);
        getContentPane().add(inputBoxY);
        getContentPane().add(inputBoxS);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputBoxCoef.getText().equals("")) { //if user left textbox blank
                    inputBoxCoef.setText("0");
                }

                if (inputBoxExp.getText().equals("")) {
                    inputBoxExp.setText("0");
                }

                inputsValsCoef.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                inputsValsExp.add(inputBoxExp.getText());
                magX = inputBoxX.getText();
                magY = inputBoxY.getText();
                smoothness = inputBoxS.getText();

                if (magX != null && magY != null && smoothness != null && inputsValsCoef.size() == inputsValsExp.size()) { //is user has inputted these values
                    Graph(inputsValsCoef, inputsValsExp, magX, magY, smoothness);
                }
            }
        });

        GraphPolyControl.main(null);
    }

    public void Graph(ArrayList<String> coefficients1, ArrayList<String> exponents1, String magX1, String magY1, String smoothness1) {
        getContentPane().remove(errorMessage);

        for (int i = 0; i < coefficients1.size(); i++) {
            try {
                double numTest = Double.parseDouble(coefficients1.get(i)); //tests the see if the value in the arraylist at index/location i is a number
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //closes current window
                main(null); //creates new window and reruns program
            }

            try {
                double numTest = Double.parseDouble(exponents1.get(i));
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                main(null);
            }
        }

        String[] inputs = {magX1, magY1, smoothness1}; //checks that all three of these are numbers

        for (int i = 0; i < 3; i++) {
            try {
                double numTest = Double.parseDouble(inputs[i]);
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                main(null);
            }
        }

        double magX = Double.parseDouble(magX1), magY = Double.parseDouble(magY1), smoothness = Double.parseDouble(smoothness1); //converts input into numbers

        if (magX < 0.1 || magX > 10 || magY < 0.1 || magY > 10) {
            errorMessage.setText("Magnitudes must be between 0.1 and 10");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            main(null);
        }

        if (smoothness < 0.01 || smoothness > 1) {
            errorMessage.setText("Smoothness must be between 0.01 and 10");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            main(null);
        }

        for (int i = 0; i < 101; i++) { //set up axes
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
        double y = 0;

        for (double x = domainLower; x < domainUpper; x += smoothness * magX) { //Graphs into a 2d array
            y = 0; //resets y for every new x-value
            for (int i = 0; i < coefficients1.size(); i++) {
                y += (Math.pow(x, Double.parseDouble(exponents1.get(i)))) * Double.parseDouble(coefficients1.get(i)); //math.pow returns x to the power of exponents[i] abd multiplies that by the coefficient of that same term; then adds the y value to the existing y value from the other terms
            }

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) { //puts x,y coordinates into 2d array
                GraphMain.Graph[50 - (int) Math.round((y / magY))][50 + (int) Math.round((x / magX))].setText("0"); //inputs the coordinate into the 2darray

                if ((int)y == 0) { //approx x-intercept
                    XInts.add(x); //stores current x-value as an x-int
                }

                if ((int)x == 0) { //approx y-int
                    YInt = y;
                }
            }
        }

        GraphingCalculatorUI.main(null); //prints out graph

        XIntColon.setBounds(25, 450, 200, 50);
        getContentPane().add(XIntColon);
        YIntColon.setBounds(1000, 50, 200, 50);
        getContentPane().add(YIntColon);

        for (int i = 0; i < XInts.size(); i++) {
            XIntDisplays.add(new JLabel(Double.toString(XInts.get(i)) + ", ")); //gets the value at xints arraylist[i], converts it into a string, and puts that string on a new jlabel
            int rowNumber = (int)Math.ceil(i / 16.0); //for wrapping around the edge of the jframe to a new row; can fit 16 x-ints on 1 row
            XIntDisplays.get(i).setBounds(225 + i * 100, 450 - rowNumber * 60, 100, 50);
            getContentPane().add(XIntDisplays.get(i)); //adds that new jlabel to the screen
        }

        YIntDisplay.setText(Double.toString(YInt)); //for y-int display
        YIntDisplay.setBounds(1200, 50, 200, 50);
        getContentPane().add(YIntDisplay);
    }
}
