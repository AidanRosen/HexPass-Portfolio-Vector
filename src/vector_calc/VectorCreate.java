package vector_calc;

import java.util.*;
// Created by Aidan <3 Rosen

//When I push I need to put it into a folder called vector_calc
//write package
public class VectorCreate { //created by Aidan Rosen EXCEPT for the sqrt method, which was made by Andrew Joseph

    //The below enum is for the trig functions for computing vector quantities
    public enum TRIG {iHat, jHat, resultant, angle}
    //named resultantV so that if we need to calculate the resultant VECTOR and to avoid namespace errors with the parameter
    //Need functions for sin, cos, tan, and tanInv

    private double magnitude = 0;
    private double directionality = 0;

    //cite them using vector_calc.VectorCreate.magnitude

    public static double sqrt(double arg1) {//Created by Andrew Joseph
        double squareroot = arg1/2;
        double temp = squareroot;
        do
        {
            temp = squareroot;
            squareroot = (temp + (arg1 / temp)) / 2;
        }
        while ((temp - squareroot) != 0);
        return squareroot;
    }//Added here so that it can be used for calculating resultant vector magnitude

    public VectorCreate (double verticalComponent, double horizComponent){
        this.directionality = Math.atan2(verticalComponent, horizComponent);
        System.out.println("\n\nThis is the value of the vertical component: " + String.valueOf(verticalComponent));
        System.out.println("\n\nThis is the value of the horizontal component: " + String.valueOf(horizComponent));
        double radical = (verticalComponent * verticalComponent) + (horizComponent * horizComponent);
        this.magnitude = sqrt(radical);



    }

    public double resultantMag(String property) {

        double value = 0.0;
        switch (property) {
            case "magnitude":
                value = 0 + this.magnitude;
                System.out.println("This is the value of magnitude: " + String.valueOf(magnitude));

            case "directionality":
                value = this.directionality;

        }

        System.out.println("Before return: This is the value of value: " + String.valueOf(value));
        return this.magnitude;
    }

    public double resultantDirec() {
        return this.directionality;
    }






    public static double vectorResolve (double  magnitude, double angle, TRIG component){
        //This method RESOLVES vectors. It isn't for returning calculated vectors (resultants)
        double resultLeg = 0;
        switch(component)
                //Use the TRIG component parameter to determine which component should be calculated (i hat or j hat)
                //We will need to input each case in order to get the numbers we want to get
                //I.e call this vectorResolve method multiple times to calculate a final vector
        {
            case iHat:
                //uses cos of the angle to get "horizontal" part
                resultLeg = Math.cos(angle) * magnitude;
                break;
            case jHat:
                resultLeg = Math.sin(angle) * magnitude;
                //uses sin of the angle to get "vertical" part
                break;

                /*
            case resultant:
                break;
            case angle:
                //Need tangent inverse
                break;
                */
            default:
                break;



        }

        //Use return resultLeg because
        return resultLeg;

    }
}
