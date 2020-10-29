package Graphing_Calculator.Model_Files;
//ask user for sin, cos, tan, csc, sec, or cot
//then ask for coefficient of trig funtion, exponent value of trig function and the coefficient of the x within the function; then dowhile to ask if they want another value or if they want to switch to denominator (rational function; three options: enter another term, switch to denominator, finish and graph)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Graphing_Calculator.Control_Files.GraphTrigControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphTrig extends JFrame {

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

    }
}
