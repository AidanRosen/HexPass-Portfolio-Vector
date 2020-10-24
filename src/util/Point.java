//Andrew Joseph

package util;
import java.util.ArrayList;

import view_control.GraphingCalculatorAJ;
import java.util.ArrayList;
public class Point {


    double number[];
    int totalNumbers = 0;


    double x;
    double y;


    public Point(double x, double y) {
        //number[totalNumbers] = 0;
        this.x = x;
        this.y = calculate(x);
        //sets the x and y cordinates, calculates for y

    }

    public double calculate(double x) {
        int numbers = 0;

        number = new Seperator(x).numbersList; //gets an array of all the numbers in typed function
        totalNumbers = new Seperator(x).totalAmountNumbers; //gets a count of the total numbers

        ArrayList<Math.OPERATOR> operator = new Seperator(x).holder; //gets an array of all operators

        while (numbers < totalNumbers) { //iterates through all numbers
            number[numbers + 1] = Math.calculateIt(number[numbers], operator.get(numbers), number[numbers + 1]);
            numbers++; //combines numbers left to right, order of operations will be implemented in the future
        }
        return number[numbers]; //returns the value to y

    }
}




