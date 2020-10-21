package Graphing_Calculator;

import javax.swing.*;
import java.awt.*;

public class GraphExpo extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphExpo frame = new GraphExpo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
