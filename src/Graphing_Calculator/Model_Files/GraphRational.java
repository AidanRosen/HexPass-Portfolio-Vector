package Graphing_Calculator.Model_Files;
//ui: ask user to enter numberator first: for the coefficient and exponent value, then ask if they want another term or if they want to enter the denominator after they finish entering; then prompt for denominator whenever: use same process as username
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Graphing_Calculator.Control_Files.GraphPolyControl;
import Graphing_Calculator.Control_Files.GraphRationalControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphRational extends JFrame {

    public enum FRAC_SIDE {N, D}
    public static ArrayList<String> inputsValsCoefN = new ArrayList<String>();
    public static ArrayList<String> inputsValsExpN = new ArrayList<String>();
    public static ArrayList<String> inputsValsCoefD = new ArrayList<String>();
    public static ArrayList<String> inputsValsExpD = new ArrayList<String>();

    public static JButton go = new JButton("Graph");
    public static JButton next = new JButton("Enter next term");
    public static JButton switchFrac = new JButton("Switch from numerator to denominator or vice versa");

    public JLabel label = new JLabel("x^");
    public static JLabel promptX = new JLabel("Please enter the x magnitude/zoom level (0.1-10):");
    public static JLabel promptY = new JLabel("Please enter the y magnitude/zoom level (0.1-10):");
    public static JLabel promptS = new JLabel("Please enter the smoothness level (0.01-1):");
    public static JLabel errorMessage = new JLabel("");
    public static JLabel XIntColon = new JLabel("Approximate x-intercept(s): ");
    public static JLabel YIntColon = new JLabel("Y-intercept: ");
    public static JLabel FracSideDisp = new JLabel("Numerator");

    public static JTextField inputBoxCoef = new JTextField("");
    public static JTextField inputBoxExp = new JTextField("");
    public static JTextField inputBoxX = new JTextField(10);
    public static JTextField inputBoxY = new JTextField(10);
    public static JTextField inputBoxS = new JTextField(10);

    public static ArrayList<Double> XInts = new ArrayList<Double>();
    public static ArrayList<JLabel> XIntDisplays = new ArrayList<JLabel>();
    public static double YInt = java.lang.Double.NaN;
    public static JLabel YIntDisplay = new JLabel();

    public static String magX = null, magY = null, smoothness = null;

    public static FRAC_SIDE side = FRAC_SIDE.N;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphRational frame = new GraphRational();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphRational() { //constructor for initializing labels and textboxes and add them to getcontentpane
        side = FRAC_SIDE.N;

        inputBoxCoef.setText(""); //clears the inputbox for the next input
        inputBoxExp.setText("");
        inputBoxX.setText("");
        inputBoxY.setText("");
        inputBoxS.setText("");
        inputsValsCoefN.removeAll(inputsValsCoefN);
        inputsValsCoefD.removeAll(inputsValsCoefD);
        inputsValsExpN.removeAll(inputsValsExpN);
        inputsValsExpD.removeAll(inputsValsExpD);

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        label.setBounds(100, 100, 50, 50);
        go.setBounds(1000, 350, 200, 100);
        next.setBounds(100, 350, 200, 100);
        switchFrac.setBounds(400, 350, 500, 100);
        promptX.setBounds(50, 200, 400, 40);
        promptY.setBounds(450, 200, 400, 40);
        promptS.setBounds(850, 200, 400, 40);
        errorMessage.setBounds(460, 500, 1000, 50);
        FracSideDisp.setBounds(95, 50, 200, 50);

        inputBoxCoef.setBounds(25, 100, 70, 50);
        inputBoxExp.setBounds(155, 100, 70, 50);
        inputBoxX.setBounds(50, 250, 400, 40);
        inputBoxY.setBounds(450, 250, 400, 40);
        inputBoxS.setBounds(850, 250, 400, 40);

        getContentPane().add(label);
        getContentPane().add(go);
        getContentPane().add(next);
        getContentPane().add(switchFrac);
        getContentPane().add(promptX);
        getContentPane().add(promptY);
        getContentPane().add(promptS);
        getContentPane().add(errorMessage);
        getContentPane().add(FracSideDisp);

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

                if (side == FRAC_SIDE.N) {
                    inputsValsCoefN.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                    inputsValsExpN.add(inputBoxExp.getText());
                } else {
                    inputsValsCoefD.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                    inputsValsExpD.add(inputBoxExp.getText());
                }

                magX = inputBoxX.getText();
                magY = inputBoxY.getText();
                smoothness = inputBoxS.getText();

                if (magX != null && magY != null && smoothness != null && inputsValsCoefN.size() == inputsValsExpN.size() && inputsValsCoefD.size() == inputsValsExpD.size()) { //is user has inputted these values
                    Graph(inputsValsCoefN, inputsValsExpN, inputsValsCoefD, inputsValsExpD, magX, magY, smoothness);
                    inputsValsCoefN.removeAll(inputsValsCoefN);
                    inputsValsCoefD.removeAll(inputsValsCoefD);
                    inputsValsExpN.removeAll(inputsValsExpN);
                    inputsValsExpD.removeAll(inputsValsExpD);
                }
            }
        });

        GraphRationalControl.main(null);
    }

    public void Graph(ArrayList<String> coefficients1, ArrayList<String> exponents1, ArrayList<String> coefficients2, ArrayList<String> exponents2, String magX1, String magY1, String smoothness1) {
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

        for (int i = 0; i < coefficients2.size(); i++) {
            try {
                double numTest = Double.parseDouble(coefficients2.get(i)); //tests the see if the value in the arraylist at index/location i is a number
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //closes current window
                main(null); //creates new window and reruns program
            }

            try {
                double numTest = Double.parseDouble(exponents2.get(i));
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

        double domainLower = -50.0 * magX;
        double domainUpper = 50.0 * magX;
        double rangeLower = -50.0 * magY;
        double rangeUpper = 50.0 * magY;
        double yN = 0, yD = 0, y = 0;

        GraphMain.GraphSetUp(magX, magY, domainUpper, rangeUpper);

        for (double x = domainLower; x < domainUpper; x += smoothness * magX) { //Graphs into a 2d array
            yN = 0; //resets y for every new x-value
            yD = 0;

            for (int i = 0; i < coefficients1.size(); i++) { //calculates value in numerator
                yN += (Math.pow(x, Double.parseDouble(exponents1.get(i)))) * Double.parseDouble(coefficients1.get(i));
                //math.pow returns x to the power of exponents[i] abd multiplies that by the coefficient of that same term; then adds the y value to the existing y value from the other terms
            }

            for (int i = 0; i < coefficients2.size(); i++) { //calculates value in denominator
                yD += (Math.pow(x, Double.parseDouble(exponents2.get(i)))) * Double.parseDouble(coefficients2.get(i));
            }

            y = yN / yD; //divides total numerator value by total denominator value; vertical asymptotes should not cause an error with doubles instead of integers

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) { //puts x,y coordinates into 2d array if they are within -50,50 or otherwise specified by the magnitude
                GraphMain.Graph[50 - (int) Math.round((y / magY))][50 + (int) Math.round((x / magX))].setText("⬤"); //inputs the coordinate into the 2darray

                if (y >= (0 - smoothness / 10) && y <= (smoothness / 10) ) { //approx x-intercept
                    XInts.add(x); //stores current x-value as an x-int
                }

                if (x == 0.0) { //y-int
                    YInt = y;
                }
            }
        }

        GraphingCalculatorUI.main(null); //prints out graph

        XIntColon.setBounds(25, 500, 200, 50);
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

            XIntDisplays.get(i).setBounds(225 + wrapText  * 100, 440 + rowNumber * 60, 100, 50);
            getContentPane().add(XIntDisplays.get(i)); //adds that new jlabel to the screen
        }

        YIntDisplay.setText(Double.toString(YInt)); //for y-int display

        if (YInt == java.lang.Double.NaN) {
            YIntDisplay.setText("None");
        }

        YIntDisplay.setBounds(1100, 50, 200, 50);
        getContentPane().add(YIntDisplay);
    }
}
