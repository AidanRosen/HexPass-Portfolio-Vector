package AJGraphingCalculator.Control;

import AJGraphingCalculator.Model.CordStore;
import AJGraphingCalculator.Model.FnStorer;

import AJGraphingCalculator.Model.Point;

import AJGraphingCalculator.Model.Seperator;

import AJGraphingCalculator.View.GraphingCalculatorUI;

import AJGraphingCalculator.View.TheGraph;

import javax.swing.*;
import java.util.ArrayList;



public class GCcontrol {


    ArrayList<AJGraphingCalculator.Model.Point> Cords = new ArrayList<AJGraphingCalculator.Model.Point>();

    GraphingCalculatorUI GCUI;
    AJGraphingCalculator.Model.Point model;
    CordStore CordStuffs;

    FnStorer functions;
    TheGraph Graph;



    public GCcontrol()
    {

        this.model = new AJGraphingCalculator.Model.Point();

        this.CordStuffs = new CordStore();


        this.GCUI = new GraphingCalculatorUI(this);

        GCUI.setVisible(true);




    }



    public GCcontrol(String input) throws InterruptedException {
        getPoints(input);
    }



    public void getPoints(String input) throws InterruptedException {
        int totalCords = -1;

        ArrayList<Integer> xCords = new ArrayList<>();
        ArrayList<Integer> yCords = new ArrayList<>();
        ArrayList<Integer> height = new ArrayList<>();

        for (double x = -250; x <= 251; x = x + 1) {

            Seperator mathData = new Seperator(input, x);


            AJGraphingCalculator.Model.Point nextPoint = new AJGraphingCalculator.Model.Point(x, mathData);

            Cords.add(nextPoint);

            totalCords++;

            if (x == 100) {
                AJGraphingCalculator.Model.Point testPoint = Cords.get(totalCords);
                //GCUI.JBar.setText(String.valueOf(testPoint.y));
            }


        }
        CordStuffs.setCords(Cords);
        CordStuffs.setTotalCords(totalCords);

        for (int n = 0; n < totalCords+1; n++)
        {
            CordStuffs.setCurrentCordinate(n);

            xCords.add(CordStuffs.calculateX());
            yCords.add(CordStuffs.calculateY());
            int width = 1;
            height.add(CordStuffs.calculateHeight(n));

            //GCUI.JBar.setText(String.valueOf(height));
        }

        Graph = new TheGraph(xCords, yCords, 1, height, totalCords);







        //  new TheGraph(Cords, totalCords);


    }
}



