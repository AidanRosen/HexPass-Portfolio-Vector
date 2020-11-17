package Graphing_Calculator.Control_Files;

import Graphing_Calculator.Model_Files.GraphRational;
//instructions for user input: say that they are doing the numerator first. Do the same process as for the polynomials, but instead of asking them to end input for the numerator, ask if they want to switch to denominator. Then the denominator process will be the same as the polynomial graphing and graph it when the user chooses to stop inputting.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphRationalControl extends GraphRational {
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

                if (side == FRAC_SIDE.N) {
                    inputsValsCoefN.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                    inputsValsExpN.add(inputBoxExp.getText());
                } else {
                    inputsValsCoefD.add(inputBoxCoef.getText()); //saves the text from the input box into an arraylist when user chooses to graph
                    inputsValsExpD.add(inputBoxExp.getText());
                }

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

        switchFrac.addActionListener(new ActionListener() {
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

                if (side == FRAC_SIDE.N) { //switches sides
                    side = FRAC_SIDE.D;
                    FracSideDisp.setText("Denominator");
                } else {
                    side = FRAC_SIDE.N;
                    FracSideDisp.setText("Numerator");
                }

                inputBoxCoef.setText("");
                inputBoxExp.setText("");
            }
        });
    }
}
