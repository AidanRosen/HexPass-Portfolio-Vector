package Graphing_Calculator;

import javax.swing.*;
import java.awt.*;

//view class for displaying graph from 2d array
public class GraphingCalculatorUI extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphingCalculatorUI frame = new GraphingCalculatorUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphingCalculatorUI() { //constructor
        //print out the 2d array as a new window
        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                GraphMain.Graph[i][j].setBounds(0 + 10 * j, 0 + 10 * i, 10, 10);
                getContentPane().add(GraphMain.Graph[i][j]); //prints out graph
            }
        }
    }
}
