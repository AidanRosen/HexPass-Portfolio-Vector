package Graphing_Calculator;

import javax.swing.*;
import java.awt.*;

public class GraphTrig extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphTrig frame = new GraphTrig();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
