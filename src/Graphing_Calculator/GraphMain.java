package Graphing_Calculator;
//Alex Hu
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GraphMain extends JFrame {
    JLabel prompt = new JLabel("Please enter an option: ");
    JLabel options = new JLabel("1: Cubic    2: Polynomial    3: Trig    4: Exponent/Roots    5: Log/Ln");
    JTextField userInput = new JTextField(5);
    String choice = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphMain frame = new GraphMain();
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

        graphMainUI();
    }

    public void graphMainUI() {

        userInput.setText("");

        userInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = userInput.getText();

                switch (choice) {
                    case "1":
                        GraphCubic.main(null);
                        break;
                    case "2":
                        GraphPoly.main(null);
                        break;
                    case "3":
                        GraphTrig.main(null);
                        break;
                    case "4":
                        GraphExpo.main(null);
                        break;
                    case "5":
                        GraphLog.main(null);
                        break;
                    default:
                        graphMainUI(); //recursion
                }
            }
        });
    }
}
