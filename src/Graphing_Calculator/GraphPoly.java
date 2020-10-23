package Graphing_Calculator;
//ui: ask user for the coefficient and exponent value, then ask if they want another term after they finish entering

import javax.swing.*;
import java.awt.*;

public class GraphPoly extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphPoly frame = new GraphPoly();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
