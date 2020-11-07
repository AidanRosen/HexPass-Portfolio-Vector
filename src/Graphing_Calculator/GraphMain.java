package Graphing_Calculator;
//Alex Hu
import Graphing_Calculator.Model_Files.*;
//Anytime you need to access a variable or method from a class outside your package, you must import package_name.class_name
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GraphMain extends JFrame {
    public static JLabel prompt = new JLabel("Please enter an option: ");
    public static JLabel options = new JLabel("1: Cubic    2: Polynomial    3: Trig    4: Exponent/Roots    5: Log/Ln");
    public static JTextField userInput = new JTextField(5);
    public static String choice = null;
    public static JLabel[][] Graph = new JLabel[101][101]; //for the graph

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphMain frame = new GraphMain(); //this creates a new jframe window becuase this class extends JFrame and is therefore a subclass of JFrame; this calls the constructor of this class and whenever a class' constructor is called, all its parent class' contructors are also called. The constructor for the parent class JFrame is to just create a new JFrame window. Interestingly this doesn't seem to create a new JFrame if an object of this class is created from a different class;=
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphMain() {
        getContentPane().setBackground(new Color(175, 238, 238)); //set window size and color
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 960, 540); //sets size of the window
        getContentPane().setLayout(null);
        prompt.setBounds(50, 80, 500, 40); //sets location of text
        options.setBounds(50, 120, 500, 40);
        userInput.setBounds(50, 160, 500, 40);

        getContentPane().add(prompt); //displays the text
        getContentPane().add(options);
        getContentPane().add(userInput);

        GraphMainUI.MainUI();
    }

    public static void GraphSetUp(double magX, double magY, double domainUpper, double rangeUpper) { //used by all other model files to set up axes
        for (int i = 0; i < 101; i++) { //set up axes labelded with grid value
            for (int j = 0; j < 101; j++) {
                if (i == 50) {
                    if (j > 50) { //for sorting out negatives and positives
                        Graph[i][j] = new JLabel(Double.toString(j * magX - domainUpper));
                        if (Math.floor(j * magX - domainUpper) == j * magX - domainUpper) { //if the value is something .0 (so the same as an integer), only display the int and not .0 to save space
                            Graph[i][j].setText(Integer.toString((int)(j * magX - domainUpper))); //converts double to int, them to string, then to jlabel
                        }
                    } else if (j < 50) { //if negative
                        Graph[i][j] = new JLabel("-" + Double.toString((domainUpper - j * magX)));
                        if (Math.floor(domainUpper - j * magX) == domainUpper - j * magX) {
                            Graph[i][j].setText("-" + Integer.toString((int)(domainUpper - j * magX)));
                        }
                    } else if (j == 50) {
                        Graph[i][j] = new JLabel("0");
                    }
                } else if (j == 50) {
                    if (i < 50) {
                        Graph[i][j] = new JLabel(Double.toString((rangeUpper - i * magY)));
                        if (Math.floor(rangeUpper - i * magY) == rangeUpper - i * magY) {
                            Graph[i][j].setText(Integer.toString((int)(rangeUpper - i * magY)));
                        }
                    } else {
                        Graph[i][j] = new JLabel("-" + Double.toString(i * magY - rangeUpper));
                        if (Math.floor(i * magY - rangeUpper) == i * magY - rangeUpper) {
                            Graph[i][j].setText("-" + Integer.toString((int)(i * magY - rangeUpper)));
                        }
                    }
                } else {
                    Graph[i][j] = new JLabel(" ");
                }
            }
        }
    }
}
