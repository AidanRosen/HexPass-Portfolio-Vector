package Graphing_Calculator.Control_Files;

import Graphing_Calculator.Model_Files.GraphPoly;
//instructions for user input: ask user for coefficient and exponent; then ask user if they want to add another term. If they choose yes, repeat this process. If no, graph the function
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphPolyControl extends GraphPoly {
    public static void main(String args[]) {
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputBoxCoef.getText().equals("")) { //if user left textbox blank
                    inputBoxCoef.setText("0");
                }

                if (inputBoxExp.getText().equals("")) {
                    inputBoxExp.setText("0");
                }

                inputsValsCoef.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to enter next term
                inputsValsExp.add(inputBoxExp.getText());
                inputBoxCoef.setText(""); //clears the inputbox for the next input
                inputBoxExp.setText("");
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

        inputBoxS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smoothness = inputBoxS.getText();
            }
        });
    }
}
