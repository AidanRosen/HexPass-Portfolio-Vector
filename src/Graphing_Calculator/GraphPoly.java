package Graphing_Calculator;
//ui: ask user for the coefficient and exponent value, then ask if they want another term after they finish entering
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
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

    public GraphPoly() { //constructor for initializing labels and textboxes and add them to getcontentpane

    }
}
