package Graphing_Calculator.Control_Files;

import Graphing_Calculator.Model_Files.GraphCubic; //allows for calling functions from GraphCubic (even though inherited), which is not in the same package

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphCubicControl extends GraphCubic {
    //inheritance: inherits all the methods and public variables from GraphingCalculatorUI, but you can also write your own additional methods or override them by declaring a method that has the same name as a method in GraphingCalculatorUI but make it do different things

    public static void promptA() {
        inputBox.addActionListener(new ActionListener() { //do not need to state graphCubic.inputBox as it is inherited
            @Override
            public void actionPerformed(ActionEvent e) {
                a = inputBox.getText(); //gets text from user input in textbox
            }
        });
    }

    public static void promptB() {
        inputBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = inputBox2.getText();
            }
        });
    }

    public static void promptC() {
        inputBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = inputBox3.getText();
            }
        });
    }

    public static void promptD() {
        inputBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d = inputBox4.getText();
            }
        });
    }

    public static void promptXMagnitude() {
        inputBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magX = inputBox5.getText();
            }
        });
    }

    public static void promptYMagnitude() {
        inputBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magY = inputBox6.getText();
            }
        });
    }

    public static void promptSmoothness() {
        inputBox7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smoothness = inputBox7.getText();
            }
        });
    }
}
