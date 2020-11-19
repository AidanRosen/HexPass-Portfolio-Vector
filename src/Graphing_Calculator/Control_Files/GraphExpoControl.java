package Graphing_Calculator.Control_Files;

import Graphing_Calculator.Model_Files.GraphExpo;
//instructions for user inputs: ask user for coefficient and exponent of x
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphExpoControl extends GraphExpo {

    public static void main(String[] args) {
        EnterNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coefficients.add(Coefficient.getText());
                BaseS.add(Base.getText());
                ExponentS.add(Exponent.getText());
                Coefficient.setText("");
                Base.setText("");
                Exponent.setText("");

            }
        });
        //initialize actionlisteners for buttons which adds the user input in the textfields (textfield.getText) into the respective arraylist (coefficients, exponents or bases)
    }
}
