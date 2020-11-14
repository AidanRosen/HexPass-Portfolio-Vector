package src.ModelAJGC;

import java.util.ArrayList;


public class Seperator {
    public String stringNumber = "";
    public int totalAmountNumbers = 0;
    String itS;
    private int length;

    public ArrayList<FnStorer> functions = new ArrayList<FnStorer>();


    private ArrayList<Math.OPERATOR> holder = new ArrayList<Math.OPERATOR>();


    private ArrayList<Double> numbersList = new ArrayList<Double>();






    public Seperator(String input, double x) {


        //replaces x in the function with iteration
        //value from in the UI

        for (int length = 0; length < input.length(); length++) {

            char iterator = input.charAt(length);

            if (input.contains("x") && length < (input.length()-1)) {

                if (input.charAt(length + 1) == 'x') {
                    setNumber(itS);
                    numbersList.add(Double.valueOf(stringNumber));
                    holder.add(Math.OPERATOR.MULTIPLY);
                }
            }

            //iterates through input to find numbers and operators
            this.itS = String.valueOf(iterator); //sets the number to be a string
            if (itS.equals("x")) {itS = String.valueOf(x);}

            this.length = length;
            completeFunction();
        }






        if (totalAmountNumbers == 0) {
            numbersList.add(Double.valueOf(stringNumber));
            holder.add(Math.OPERATOR.NOOP);
        }

        numbersList.add(Double.valueOf(stringNumber));

        store();

        }







    public void completeFunction() {

        try {
            double currentNumber = Double.valueOf(itS);

            setNumber(itS);



        } catch (NumberFormatException numberFormatException) {
//checks for operator, and if so operator type then adds it to array

            numbersList.add(Double.valueOf(stringNumber));

            stringNumber = "";

            switch (itS) {


                case "+":
                    holder.add(Math.OPERATOR.PLUS);
                    totalAmountNumbers++;
                    break;
                case "-":
                    holder.add(Math.OPERATOR.MINUS);
                    totalAmountNumbers++;
                    break;
                case "*":
                    holder.add(Math.OPERATOR.MULTIPLY);
                    totalAmountNumbers++;
                    break;
                case "/":
                    holder.add(Math.OPERATOR.DIVIDE);
                    totalAmountNumbers++;
                    break;
                case "^":
                    holder.add(Math.OPERATOR.SQUARED);
                    totalAmountNumbers++;

                    break;
                //  case "sqrt":
                //holder.add(Math.OPERATOR.SQUAREROOT);
                //totalAmountNumbers++;
                //  break;

                default:
                    holder.add(Math.OPERATOR.NOOP);


            }


        }

    }





    public void setNumber(String nextNumber) {

//sets number through concat like procedure
        stringNumber = stringNumber + nextNumber;


    }


    public void store() {
        for (int length = 0; length < totalAmountNumbers; length++) {


            FnStorer nextFunction = new FnStorer(numbersList.get(length), holder.get(length), numbersList.get(length+1));

            functions.add(length, nextFunction);

        }

    }
}







//public void variableFormat(char prevIn) {
//try {
//      double currentNumber = Double.valueOf(itS);
//}

/*
 if (itS.equals("x")) {
                variableFormat(input.charAt(length-1));
                itS = String.valueOf(x);
            }
 */


