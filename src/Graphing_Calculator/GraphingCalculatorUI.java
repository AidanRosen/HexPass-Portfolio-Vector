package Graphing_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//view class for displaying graph from 2d array
public class GraphingCalculatorUI extends JFrame {

    public static void main(String[] args) {
        //empty
    }

    public GraphingCalculatorUI() { //constructor
        //print out the 2d array as a new window
        getContentPane().removeAll();
        repaint();

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                GraphMain.Graph[i][j].setBounds(0 + 10 * j, 0 + 10 * i, 10, 10);
                getContentPane().add(GraphMain.Graph[i][j]); //prints out graph
            }
        }
    }
}
