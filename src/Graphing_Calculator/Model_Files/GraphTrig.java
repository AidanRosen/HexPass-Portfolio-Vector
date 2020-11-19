package Graphing_Calculator.Model_Files;
//ask user for sin, cos, tan, csc, sec, or cot
//then ask for coefficient of trig funtion, exponent value of trig function and the coefficient of the x within the function; then dowhile to ask if they want another value or if they want to switch to denominator (rational function; three options: enter another term, switch to denominator, finish and graph)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*; //for trig functions
import java.util.ArrayList;

import Graphing_Calculator.Control_Files.GraphPolyControl;
import Graphing_Calculator.Control_Files.GraphTrigControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphTrig extends JFrame {


    public static ArrayList<String> inputsValsCoef = new ArrayList<String>();
    public static ArrayList<String> inputsValsFunc = new ArrayList<String>();
    public static ArrayList<String> inputsValsExp = new ArrayList<String>();

    public static JButton go = new JButton("Graph");
    public static JButton next = new JButton("Enter next term");
    public static JButton sinButton = new JButton("sin");
    public static JButton cosButton = new JButton("cos");
    public static JButton tanButton = new JButton("tan");
    public static JButton cscButton = new JButton("csc");
    public static JButton secButton = new JButton("sec");
    public static JButton cotButton = new JButton("cot");

    public static  JLabel label = new JLabel("θ");
    public static JLabel funcLabel = new JLabel("Func");
    public static JLabel promptX = new JLabel("Please enter the x magnitude/zoom level (0.1-10):");
    public static JLabel promptY = new JLabel("Please enter the y magnitude/zoom level (0.1-10):");
    public static JLabel errorMessage = new JLabel("");
    public static JLabel XIntColon = new JLabel("Approximate x-int(s) in terms of pi: ");
    public static JLabel YIntColon = new JLabel("Y-intercept: ");

    public static JTextField inputBoxCoef = new JTextField("");
    public static JTextField inputBoxExp = new JTextField("");
    public static JTextField inputBoxX = new JTextField(10);
    public static JTextField inputBoxY = new JTextField(10);

    public static ArrayList<Double> XInts = new ArrayList<Double>();
    public static ArrayList<JLabel> XIntDisplays = new ArrayList<JLabel>();
    public static double YInt = 0;
    public static JLabel YIntDisplay = new JLabel();

    public static String magX = null, magY = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphTrig frame = new GraphTrig();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public GraphTrig() { //constructor for initializing labels and textboxes and add them to getcontentpane
        inputBoxCoef.setText(""); //clears the inputbox for the next input
        funcLabel.setText("Func");
        inputBoxExp.setText("");
        inputBoxX.setText("");
        inputBoxY.setText("");
        magX = null;
        magY = null;
        inputsValsCoef.removeAll(inputsValsCoef);
        inputsValsFunc.removeAll(inputsValsFunc);
        inputsValsExp.removeAll(inputsValsExp);
        XInts.removeAll(XInts);
        YInt = 0.0;

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        label.setBounds(225, 100, 40, 50);
        go.setBounds(400, 450, 200, 100);
        next.setBounds(100, 450, 200, 100);
        sinButton.setBounds(50, 350, 70, 50);
        cosButton.setBounds(125, 350, 70, 50);
        tanButton.setBounds(200, 350, 70, 50);
        cscButton.setBounds(275, 350, 70, 50);
        secButton.setBounds(350, 350, 70, 50);
        cotButton.setBounds(425, 350, 70, 50);

        funcLabel.setBounds(100, 100, 40, 50);
        promptX.setBounds(50, 200, 400, 40);
        promptY.setBounds(450, 200, 400, 40);
        errorMessage.setBounds(460, 500, 1000, 50);

        inputBoxCoef.setBounds(25, 100, 70, 50);
        inputBoxExp.setBounds(145,75, 70, 40);
        inputBoxX.setBounds(50, 250, 400, 40);
        inputBoxY.setBounds(450, 250, 400, 40);

        getContentPane().add(label);
        getContentPane().add(go);
        getContentPane().add(next);
        getContentPane().add(sinButton);
        getContentPane().add(cosButton);
        getContentPane().add(tanButton);
        getContentPane().add(cscButton);
        getContentPane().add(secButton);
        getContentPane().add(cotButton);

        getContentPane().add(funcLabel);
        getContentPane().add(promptX);
        getContentPane().add(promptY);
        getContentPane().add(errorMessage);

        getContentPane().add(inputBoxCoef);
        getContentPane().add(inputBoxExp);
        getContentPane().add(inputBoxX);
        getContentPane().add(inputBoxY);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputBoxCoef.getText().equals("")) { //if user left textbox blank
                    inputBoxCoef.setText("0");
                }

                if (inputBoxExp.getText().equals("")) {
                    inputBoxExp.setText("0");
                }

                if (funcLabel.getText().equals("Func")) {
                    funcLabel.setText("sin^");
                }

                inputsValsCoef.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                inputsValsFunc.add(funcLabel.getText());
                inputsValsExp.add(inputBoxExp.getText());

                magX = inputBoxX.getText();
                magY = inputBoxY.getText();

                if (magX != null && magY != null && inputsValsCoef.size() == inputsValsExp.size() && inputsValsExp.size() == inputsValsFunc.size()) { //is user has inputted these values
                    Graph(inputsValsCoef, inputsValsFunc, inputsValsExp, magX, magY);
                    inputsValsCoef.removeAll(inputsValsCoef);
                    inputsValsFunc.removeAll(inputsValsFunc);
                    inputsValsExp.removeAll(inputsValsExp);
                }
            }
        });

        GraphTrigControl.main(null);
    }

    public void Graph(ArrayList<String> coefficients1, ArrayList<String> functions1, ArrayList<String> exponents1, String magX1, String magY1) {
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

        String[] inputs = {magX1, magY1}; //checks that all three of these are numbers

        for (int i = 0; i < 2; i++) {
            try {
                double numTest = Double.parseDouble(inputs[i]);
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                main(null);
            }
        }

        double magX = Double.parseDouble(magX1), magY = Double.parseDouble(magY1); //converts input into numbers

        if (magX < 0.1 || magX > 10 || magY < 0.1 || magY > 10) {
            errorMessage.setText("Magnitudes must be between 0.1 and 10");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            main(null);
        }

        double domainLower = -8.0 * magX * Math.PI;
        double domainUpper = 8.0 * magX * Math.PI;
        double rangeLower = -16.0 * magY;
        double rangeUpper = 16.0 * magY;
        double y = 0;

        for (int i = 0; i < 97; i++) { //requires a different set up for axes labeled with grid value in radians
            for (int j = 0; j < 97; j++) {

                double value = ((j * magX) - (domainUpper * 6 / Math.PI))/ 6; //calculates the value in pi radians to display on the x axis

                if (i == 48) { //x-axis
                    if (j % 3 == 0) { //only label every 3 grid boxes, or every pi/2 radians

                        GraphMain.Graph[i][j] = new JLabel(Double.toString(value));
                        if (Math.floor(value) == value) { //if the value is something .0 (so the same as an integer), only display the int and not .0 to save space
                            GraphMain.Graph[i][j].setText(Integer.toString((int)(value))); //converts double to int, them to string, then to jlabel
                        }
                    } else {
                        GraphMain.Graph[i][j] = new JLabel("-");
                    }

                    if (j == 48) {
                        GraphMain.Graph[i][j] = new JLabel("0");
                    }
                } else if (j == 48) { //y-axis
                    if (i < 48) {
                        if (i % 3 == 0) { //only label every 3 grid boxes
                            GraphMain.Graph[i][j] = new JLabel(Double.toString((rangeUpper - i * magY / 3)));
                            if (Math.floor(rangeUpper - i * magY) == rangeUpper - i * magY) {
                                GraphMain.Graph[i][j].setText(Integer.toString((int)(rangeUpper - i * magY / 3)));
                            }
                        } else {
                            GraphMain.Graph[i][j] = new JLabel("|");
                        }
                    } else {
                        if (i % 3 == 0) {
                            GraphMain.Graph[i][j] = new JLabel("-" + Double.toString(i * magY / 3 - rangeUpper));
                            if (Math.floor(i * magY - rangeUpper) == i * magY - rangeUpper) {
                                GraphMain.Graph[i][j].setText("-" + Integer.toString((int)(i * magY / 3 - rangeUpper)));
                            }
                        } else {
                            GraphMain.Graph[i][j] = new JLabel("|");
                        }
                    }
                } else {
                    GraphMain.Graph[i][j] = new JLabel(" ");
                }
            }
        }

        for (double x = domainLower; x < domainUpper; x += magX * (Math.PI / 6)) { //Graphs into a 2d array, x axis advances by pi/6 radians at a time
            y = 0.0; //resets y for every new x-value
            for (int i = 0; i < coefficients1.size(); i++) {
                if (functions1.get(i).equals("sin^")) { //calculations
                    y += (Math.pow(Math.sin(x), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                } else if (functions1.get(i).equals("cos^")) {
                    y += (Math.pow(Math.cos(x), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                } else if (functions1.get(i).equals("tan^")) {
                    y += (Math.pow(Math.tan(x), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                } else if (functions1.get(i).equals("csc^")) {
                    y += (Math.pow((1 / Math.sin(x)), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                } else if (functions1.get(i).equals("sec^")) {
                    y += (Math.pow((1 / Math.cos(x)), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                } else if (functions1.get(i).equals("cot^")) {
                    y += (Math.pow((1 / Math.tan(x)), Double.parseDouble(exponents1.get(i))) * Double.parseDouble(coefficients1.get(i)));
                }
            }

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) { //puts x,y coordinates into 2d array if they are within -50,50 or otherwise specified by the magnitude
                GraphMain.Graph[48 - (int) Math.round(((y * 3) / magY))][48 + (int) Math.round(((x / (Math.PI / 6)) / magX))].setText("⬤"); //inputs the coordinate into the 2darray

                if (y > -0.1 && y < 0.1) { //approx x-intercept
                    XInts.add(x / Math.PI); //stores current x-value as an x-int
                }

                if (x == 0.0) { //y-int
                    YInt = y;
                }
            }
        }

        GraphingCalculatorUI.main(null); //prints out graph

        XIntColon.setBounds(25, 600, 200, 50);
        getContentPane().add(XIntColon);
        YIntColon.setBounds(1000, 50, 100, 50);
        getContentPane().add(YIntColon);
        int wrapText = 0;

        for (int i = 0; i < XInts.size(); i++) {
            XIntDisplays.add(new JLabel(Double.toString(XInts.get(i)) + ", ")); //gets the value at xints arraylist[i], converts it into a string, and puts that string on a new jlabel
            int rowNumber = (int)Math.ceil((i + 1) / 12.0); //for wrapping around the edge of the jframe to a new row; can fit ~12 x-ints on 1 row
            wrapText++;

            if (i % 12 == 0) { //if a new row is starting, shift the labels back to the left side of the screen
                wrapText = 0;
            }

            XIntDisplays.get(i).setBounds(225 + wrapText  * 100, 540 + rowNumber * 60, 100, 50);
            getContentPane().add(XIntDisplays.get(i)); //adds that new jlabel to the screen
        }

        YIntDisplay.setText(Double.toString(YInt)); //for y-int display
        YIntDisplay.setBounds(1100, 50, 200, 50);
        getContentPane().add(YIntDisplay);
    }
}
