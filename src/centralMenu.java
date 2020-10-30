import Graphing_Calculator.GraphMain;
import vector_calc.VectorCalculatorUI;
import view_control.GraphingCalculatorAJ;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.border.MatteBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class centralMenu extends JFrame { //created by Aidan <3 Rosen
    private JMenuBar menuBar = new JMenuBar();
    //necessary to define the menu bar here so that it can be modified in the constructor (kind of like calcArea)

    public static void main(String[] args) {
        centralMenu menu = new centralMenu();
        menu.setVisible(true);

    }

    //action listener for A.Joseph's calculator code in the submenu of graphing calculator
    class AjCalcAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GraphingCalculatorAJ frame = new GraphingCalculatorAJ();
            frame.setVisible(true);

        }
    }

    class AaCalcAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GraphMain frame = new GraphMain();
            frame.setVisible(true);

        }
    }

    centralMenu() {
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        getContentPane().setLayout(null);

        //Now programming the menu bar
        setJMenuBar(menuBar); // Add the menu bar to the window
        JMenu vectorCalculator = new JMenu("vectorCalculator");
        vectorCalculator.addMenuListener(new MenuListener() {
                                             @Override
                                             public void menuSelected(MenuEvent e) {
                                                 System.out.println("VectorCalculator to be opened");
                                                 VectorCalculatorUI frame = new VectorCalculatorUI();
                                                 frame.setVisible(true);
                                             }
                                    //I need to fix it to function on mouse release of the button
                                             @Override
                                             public void menuDeselected(MenuEvent e) {
                                                 //May need to get rid of main method in VectorCalculator now

                                             }

                                             @Override
                                             public void menuCanceled(MenuEvent e) {

                                             }
                                         }

        );
        menuBar.add(vectorCalculator); //you MUST still add the actual menu item!

        //Add Andrew Josephs menu to the menu bar. This is what contains a submenu
        JMenu graphingCalculator = new JMenu("Graphing Calculator Projects");
        menuBar.add(graphingCalculator); //you MUST still add the actual menu item!

        //first JMenu item under the
        JMenuItem josephCalculator = new JMenuItem("AJ's Calculator");
        josephCalculator.addActionListener(new AjCalcAction());
        graphingCalculator.add(josephCalculator);


        JMenuItem aaCalc = new JMenuItem("A&A's Graphing Calculator");
        aaCalc.addActionListener(new AaCalcAction());
        graphingCalculator.add(aaCalc); //you MUST still add the actual menu item!

    }
}

