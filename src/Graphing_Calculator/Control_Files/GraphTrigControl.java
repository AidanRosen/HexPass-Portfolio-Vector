package Graphing_Calculator.Control_Files;

import Graphing_Calculator.Model_Files.GraphTrig;
//instructions for user input: ask for coefficient, trig function (use enum), exponent of trig function, and then the x value, and then the number on the other side of the equals sign.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphTrigControl extends GraphTrig {
    public static void main(String[] args) {
        next.addActionListener(new ActionListener() {
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
                inputBoxCoef.setText(""); //clears the inputbox for the next input
                funcLabel.setText("Func");
                inputBoxExp.setText("");
            }
        });
        
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("sin^");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("cos^");
            }
        });

        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("tan^");
            }
        });

        cscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("csc^");
            }
        });

        secButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("sec^");
            }
        });

        cotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcLabel.setText("cot^");
            }
        });

        inputBoxX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magX = inputBoxX.getText(); //saves text from user input of x mag into the string
            }
        });

        inputBoxY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magY = inputBoxY.getText();
            }
        });
    }
}
