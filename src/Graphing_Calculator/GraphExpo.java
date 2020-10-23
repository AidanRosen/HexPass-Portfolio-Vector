package Graphing_Calculator;
//prompt user for base and coefficient of exponent, use do while just like in poly but ask for operator between every term (multiply, divide -> add and subtract are done through the coefficients)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
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

    public GraphExpo() { //constructor for initializing labels and textboxes and add them to getcontentpane

    }
}
