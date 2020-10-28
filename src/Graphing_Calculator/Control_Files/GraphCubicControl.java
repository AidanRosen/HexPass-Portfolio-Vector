package Graphing_Calculator.Control_Files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//control files are for user input
public class GraphCubicControl extends JFrame {
    public static JLabel prompt = new JLabel("Please enter the a value:");
    public JTextField inputBox = new JTextField(10);
    public JTextField inputBox2 = new JTextField(10);
    public JTextField inputBox3 = new JTextField(10);
    public JTextField inputBox4 = new JTextField(10);
    public JTextField inputBox5 = new JTextField(10);
    public JTextField inputBox6 = new JTextField(10);
    public JTextField inputBox7 = new JTextField(10);
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String magX = null, magY = null, smoothness = null;

    public void promptB() {
        getContentPane().removeAll(); //removes previous prompt
        repaint(); //leaves background color intact
        inputBox2.setText(""); //resets the text box
        prompt.setText("Please enter the b value:"); //changes the prompt
        getContentPane().add(prompt);
        getContentPane().add(inputBox2);
        inputBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = inputBox2.getText();
                promptC(); //prompts for third input
            }
        });
    }

    public void promptC() {
        getContentPane().removeAll();
        repaint();
        inputBox3.setText("");
        prompt.setText("Please enter the c value:");
        getContentPane().add(prompt);
        getContentPane().add(inputBox3);
        inputBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = inputBox3.getText();
                c = inputBox3.getText();
                promptD(); //prompts for third input
            }
        });
    }

    public void promptD() {
        getContentPane().removeAll();
        repaint();
        inputBox4.setText("");
        prompt.setText("Please enter the d value:");
        getContentPane().add(prompt);
        getContentPane().add(inputBox4);
        inputBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d = inputBox4.getText();
                promptXMagnitude();
            }
        });
    }

    public void promptXMagnitude() {
        getContentPane().removeAll();
        repaint();
        inputBox5.setText("");
        prompt.setText("Please enter the x magnitude/zoom level (0.1-10):");
        getContentPane().add(prompt);
        getContentPane().add(inputBox5);
        inputBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magX = inputBox5.getText();
                promptYMagnitude();
            }
        });
    }

    public void promptYMagnitude() {
        getContentPane().removeAll();
        repaint();
        inputBox6.setText("");
        prompt.setText("Please enter the y magnitude/zoom level (0.1-10):");
        getContentPane().add(prompt);
        getContentPane().add(inputBox6);
        inputBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magY = inputBox6.getText();
                promptSmoothness();
            }
        });
    }

    public void promptSmoothness() {
        getContentPane().removeAll();
        repaint();
        inputBox7.setText("");
        prompt.setText("Please enter the smoothness of the line (0.01-1):");
        getContentPane().add(prompt);
        getContentPane().add(inputBox7);
        inputBox7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smoothness = inputBox7.getText();
            }
        });
    }
}
