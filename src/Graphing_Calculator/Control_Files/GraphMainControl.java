package Graphing_Calculator.Control_Files;

import Graphing_Calculator.GraphMain;
import Graphing_Calculator.Model_Files.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphMainControl extends GraphMain {
    public static void MainUI() {

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
                    case "6":
                        GraphRational.main(null);
                        break;
                    default:
                        MainUI(); //recursion
                }
            }
        });
    }
}
