package Graphing_Calculator;

import javax.swing.*;
import java.awt.*;

public class GraphLog extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphLog frame = new GraphLog();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
