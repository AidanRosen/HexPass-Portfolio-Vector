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
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class centralMenu extends JFrame { //created by Aidan <3 Rosen
    private JMenuBar menuBar = new JMenuBar();
    //necessary to define the menu bar here so that it can be modified in the constructor (kind of like calcArea)

    public static void main(String[] args) {
        centralMenu menu = new centralMenu();
        menu.setVisible(true);

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
        JMenu GraphingCalculatorAJ = new JMenu("Andrew Joseph's Graphing Calculator");
        GraphingCalculatorAJ.addMenuListener(new MenuListener() {
                                             @Override
                                             public void menuSelected(MenuEvent e) {
                                                 System.out.println("VectorCalculator to be opened");
                                                 view_control.GraphingCalculatorAJ frame = new GraphingCalculatorAJ();
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
        menuBar.add(GraphingCalculatorAJ); //you MUST still add the actual menu item!
        JMenu mainGraphCalculator = new JMenu("A&A's Graphing Calculator");
        mainGraphCalculator.addMenuListener(new MenuListener() {
                                                 @Override
                                                 public void menuSelected(MenuEvent e) {
                                                     System.out.println("Main Graphing Calculator to be opened");
                                                     GraphMain frame = new GraphMain();
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
        menuBar.add(mainGraphCalculator); //you MUST still add the actual menu item!

    }
}

