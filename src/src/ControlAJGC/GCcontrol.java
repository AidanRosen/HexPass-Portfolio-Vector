package src.ControlAJGC;

import src.ModelAJGC.Seperator;
import src.ViewAJGC.AJGraphingCalculatorUI;

import java.util.ArrayList;


public class GCcontrol {
  AJGraphingCalculatorUI GCUI;
    ArrayList<src.ModelAJGC.Point> Cords = new ArrayList<src.ModelAJGC.Point>();

    public GCcontrol() {
this.GCUI = new AJGraphingCalculatorUI();
GCUI.setVisible(true);
    }


    public GCcontrol(String input) {
        getPoints(input);
    }

    public void getPoints(String input) {
        int totalCords = 0;
        for (double x = -10; x < 10; x = x + 0.01) {
            double y = 0;

            Seperator mathData = new Seperator(input, x);

            src.ModelAJGC.Point nextPoint = new src.ModelAJGC.Point(x, mathData);

            Cords.add(nextPoint);
            totalCords++;

        }

      //  new TheGraph(Cords, totalCords);


    }
}

