package Graphing_Calculator.Model_Files;
//prompt user for base and coefficient of exponent, use do while just like in poly but ask for operator between every term (multiply, divide -> add and subtract are done through the coefficients)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
//Atharva
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.*;

import Graphing_Calculator.Control_Files.GraphExpoControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods
import Graphing_Calculator.Control_Files.GraphCubicControl;

public class GraphExpo extends JFrame {
    //here: initialize all the jlabels and textboxes and whatever that you may need
    //will need 3 arraylists of coefficients and bases and exponents (eg 2*5^1.5x requires all 3 values), see graphpoly for declaration syntax
    public static String magX = null;
    public static String magY = null;
    public static String sm00thness = null;
    public static JLabel label = new JLabel("^");
    public static JLabel label2 = new JLabel("x");
    public static JLabel xmag = new JLabel("Please enter the x magnitude here.");
    public static JLabel ymag = new JLabel("Please enter the y magnitude here.");
    public static JLabel smoothness = new JLabel("Please enter the smoothness here");
    public static JTextField xmaginput = new JTextField("");
    public static JTextField ymaginput = new JTextField("");
    public static JTextField smoothnessinput = new JTextField("");
    public static JTextField Coefficient = new JTextField("");
    public static JTextField Base = new JTextField("");
    public static JTextField Exponent = new JTextField("");
    public static JButton EnterNext = new JButton("Enter Next Term");
    public static JButton Graph = new JButton("Graph");
    public static ArrayList<String> Coefficients = new ArrayList<String>();
    public static ArrayList<String> BaseS = new ArrayList<String>();
    public static ArrayList<String> ExponentS = new ArrayList<String>();
    public static JLabel errorMessage = new JLabel("");
    public static ArrayList<Double> XInts = new ArrayList<Double>();
    public static double YInt = 0.0;
    public static JLabel XIntColon = new JLabel("Approximate x-intercept(s): ");
    public static JLabel YIntColon = new JLabel("Y-intercept: ");
    public static ArrayList<JLabel> XIntDisplays = new ArrayList<JLabel>();
    public static JLabel YIntDisplay = new JLabel();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphExpo frame = new GraphExpo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphExpo() {//constructor for initializing labels and textboxes and add them to getcontentpane
        Coefficient.setText(""); //clears the inputbox for the next input
        Base.setText("");
        Exponent.setText("");
        xmaginput.setText("");
        ymaginput.setText("");
        smoothnessinput.setText("");
        Coefficients.removeAll(Coefficients);
        BaseS.removeAll(BaseS);
        ExponentS.removeAll(ExponentS);
        XInts.removeAll(XInts);
        YInt = 0.0;

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);
        label.setBounds(175, 100, 15, 50);
        label2.setBounds(265, 80, 15, 50);
        xmag.setBounds(300, 200, 200, 50);
        ymag.setBounds(600, 200, 200, 50);
        smoothness.setBounds(900, 200, 200, 50);
        xmaginput.setBounds(300, 300, 200, 50);
        ymaginput.setBounds(600, 300, 200, 50);
        smoothnessinput.setBounds(900, 300, 200, 50);
        Coefficient.setBounds(25, 100, 75, 50);
        Base.setBounds(100, 100, 75, 50);
        Exponent.setBounds(190, 80, 75, 50);
        EnterNext.setBounds(300, 400, 200, 50);
        Graph.setBounds(600, 400, 200, 50);
        errorMessage.setBounds(460, 500, 1000, 50);
        getContentPane().add(label);
        getContentPane().add(label2);
        getContentPane().add(xmag);
        getContentPane().add(ymag);
        getContentPane().add(smoothness);
        getContentPane().add(xmaginput);
        getContentPane().add(ymaginput);
        getContentPane().add(smoothnessinput);
        getContentPane().add(Coefficient);
        getContentPane().add(Base);
        getContentPane().add(Exponent);
        getContentPane().add(EnterNext);
        getContentPane().add(Graph);
        getContentPane().add(errorMessage);
        GraphExpoControl.main(null);
        Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coefficients.add(Coefficient.getText());
                BaseS.add(Base.getText());
                ExponentS.add(Exponent.getText());
                magX = xmaginput.getText();
                magY = ymaginput.getText();
                sm00thness = smoothnessinput.getText();
                if (magX != null && magY != null && sm00thness != null) {
                    Graph(Coefficients, BaseS, ExponentS, magX, magY, sm00thness);
                }
            }
        });
    }

    ;

    public void Graph(ArrayList<String> coefficients1, ArrayList<String> bases1, ArrayList<String> exponents1, String magX1, String magY1, String smoothness1) {
        getContentPane().remove(errorMessage);

        for (int i = 0; i < coefficients1.size(); i++) { //checks if they are numbers
            try {
                double numTest = Double.parseDouble(coefficients1.get(i)); //tests the see if the value in the arraylist at index/location i is a number
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //closes current window
                main(null); //creates new window and reruns program
            }

            try {
                double numTest = Double.parseDouble(bases1.get(i));
            } catch (NumberFormatException nfe) {
                errorMessage.setText("Inputs must be numbers");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                main(null);
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

        double domainLower = -50.0 * magX;
        double domainUpper = 50.0 * magX;
        double rangeLower = -50.0 * magY;
        double rangeUpper = 50.0 * magY;
        double y = 0.0;

        GraphMain.GraphSetUp(magX, magY, domainUpper, rangeUpper);

        for (double x = domainLower; x < domainUpper; x += smoothness * magX) { //Graphs into a 2d array
            y = 0.0; //resets y for every new x-value
            for (int i = 0; i < coefficients1.size(); i++) {
                y += Math.pow(Double.parseDouble(bases1.get(i)), Double.parseDouble(exponents1.get(i)) * x) * Double.parseDouble(coefficients1.get(i));
            }

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) { //puts x,y coordinates into 2d array if they are within -50,50 or otherwise specified by the magnitude
                GraphMain.Graph[50 - (int) Math.round((y / magY))][50 + (int) Math.round((x / magX))].setText("⬤"); //inputs the coordinate into the 2darray
                //50 is the axes
                // eg if y is -20, the program puts a ⬤ (which makes up the line/curve) in the 2d array at row 50 - (-20) = row 70 from the top
                // if x is 10, the program puts a ⬤ in column 50 + 10 = column 60 of the 2d array
                // so "⬤" is inserted at (60, 70) or (10, -20) in graphical terms

                if (y >= (0 - smoothness / 10) && y <= (smoothness / 10)) { //approx x-intercept
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
        YIntDisplay.setBounds(1100, 50, 200, 50);
        getContentPane().add(YIntDisplay);
    }
}
