package AJGraphingCalculator.View;


import AJGraphingCalculator.Control.GCcontrol;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GraphingCalculatorUI extends JFrame {
    public JTextField TBar = new JTextField();
    public static JTextField JBar = new JTextField();
    public static String input = new String();



    /*char[] x;
    char[] y;
*/
    //char[][] point = new char[][] {double x, OPERATOR, double y};

    public static void main(String[] args) {
        AJGraphingCalculator.Control.GCcontrol control = new AJGraphingCalculator.Control.GCcontrol();
    }

    public GraphingCalculatorUI(GCcontrol control) {


        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 818, 315);
        getContentPane().setLayout(null);


        TBar.setText("");
        TBar.setForeground(Color.BLACK);
        TBar.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
        TBar.setHorizontalAlignment(SwingConstants.RIGHT);
        TBar.setBounds(18, 6, 377, 67);
        getContentPane().add(TBar);

        JBar.setText("");
        JBar.setForeground(Color.BLACK);
        JBar.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
        JBar.setHorizontalAlignment(SwingConstants.RIGHT);
        JBar.setBounds(18, 166, 377, 67);


        JButton normalCalc = new JButton("Normal Calculation");
        normalCalc.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        normalCalc.setOpaque(true);
        normalCalc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                normalCalc.setBackground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                getContentPane().remove(normalCalc);
                ;
            }
        });

        normalCalc.addActionListener(d -> {

            getContentPane().add(JBar);

        });

        normalCalc.setBounds(205, 86, 75, 40);
        getContentPane().add(normalCalc);


        JButton GCalculate = new JButton("Calculate");
        GCalculate.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        GCalculate.setOpaque(true);
        GCalculate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                GCalculate.setBackground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                GCalculate.setBackground(new Color(236, 120, 20));
                ;
            }
        });

        GCalculate.addActionListener(e -> {

            input = TBar.getText();

            //   Convert(input);
            try {
                control.getPoints(input);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        GCalculate.setBounds(35, 86, 75, 40);
        getContentPane().add(GCalculate);


    }



    /*public static void Convert(String in) {



    }
    */

}

