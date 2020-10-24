
//Andrew Joseph

package util;
import java.util.ArrayList;


//import view_control.CalculatorUI;
import view_control.GraphingCalculatorAJ;


public class Seperator {


    public ArrayList<Math.OPERATOR> holder = new ArrayList<Math.OPERATOR>();

    String stringNumber = "";

    public double [] numbersList = new double[1000];
    public int totalAmountNumbers;


    public Seperator(double x) {
        stringNumber = "0.0";
        String xIn = String.valueOf(x);
       String input = GraphingCalculatorAJ.input.replace("x", xIn); //replaces x in the function with iteration
        //value from in the UI

        for (int length = 0; length < GraphingCalculatorAJ.input.length(); length++) {
            char iterator = GraphingCalculatorAJ.input.charAt(length);
            //iterates through input to find numbers and operators
            String itS = String.valueOf(iterator); //sets the number to be a string
            if (!operatorTest(itS)) { //checks if number is actually operator
                setNumber(itS);//sets number

            }
            else {


                operatorTest(itS); //gets and copies operator type to "holder" array

                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber); //finalizes number being made
                stringNumber = "0.0"; //resets temp variable
                totalAmountNumbers++; //adds 1 to total numbers because number is complete
            }
            if (totalOperators(input) == 0) { //checks if there are no operators, and adjusts for it
                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                holder.add(Math.OPERATOR.NOOP);
            }

        }

    }

    public Seperator(String input) { //the same as above but for basic calculator functions
        numbersList = new double[totalOperators(input)+2];
        totalAmountNumbers = 0;
        for (int length = 0; length < input.length(); length++) {
            char iterator = input.charAt(length);
            String itS = String.valueOf(iterator);



            if (!operatorTest(itS)) {
                setNumber(itS);

            }
            else {


                operatorTest(itS);

                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                stringNumber = "0.0";
                totalAmountNumbers++;
            }
            if (totalOperators(input) == 0) {
                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                holder.add(Math.OPERATOR.NOOP);
            }


        }

    }


    public int totalOperators(String input) { //finds total operators

        for (int length = 0; length < input.length(); length++) {
            char iterator = input.charAt(length);
            String itS = String.valueOf(iterator);

            if (operatorTest(itS)) {
                totalAmountNumbers++;
            }


        }
        return totalAmountNumbers;
    }

    public void setNumber(String nextNumber) {

//sets number through concat like procedure
        stringNumber = stringNumber + nextNumber;

    }


    public boolean operatorTest(String itS) {
//checks for operator, and if so operator type then adds it to array
        switch (itS) {


            case "+":
                holder.add(Math.OPERATOR.PLUS);
                return true;

            case "-":
                holder.add(Math.OPERATOR.MINUS);
                return true;

            case "*":
                holder.add(Math.OPERATOR.MULTIPLY);
                return true;

            case "/":
                holder.add(Math.OPERATOR.DIVIDE);
                return true;

            case "^2":
                holder.add(Math.OPERATOR.SQUARED);
                return true;


            case "sqrt":
                holder.add(Math.OPERATOR.SQUAREROOT);
                return true;
            default:
                holder.add(Math.OPERATOR.NOOP);
                return false;

        }




    }
}

