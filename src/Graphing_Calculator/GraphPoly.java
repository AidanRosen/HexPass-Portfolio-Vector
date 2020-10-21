package Graphing_Calculator;

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
