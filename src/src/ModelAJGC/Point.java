package src.ModelAJGC;

import java.util.ArrayList;

public class Point {


    private ArrayList<Double> number;
    int totalNumbers = 0;


    public double x;
    public double y;


    public Point(double x, Seperator mathData) {
        //number[totalNumbers] = 0;
        getX(x);
        this.y = calculate(mathData);

        //Convert(GraphingCalculatorUI.input);

    }

    public double calculate(Seperator mathData) {

        ArrayList<FnStorer> listOfFns = mathData.functions;

        FnStorer currentFunction = new FnStorer(0, Math.OPERATOR.NOOP, 0);

        // number = mathData.numbersList;



        totalNumbers = mathData.totalAmountNumbers;

        //  GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(totalNumbers)));

        // ArrayList<Math.OPERATOR> operator = mathData.holder;
        //   GraphingCalculatorUI.JBar.setText(String.valueOf(totalNumbers));

        for (int orderer = 0; orderer < 4; orderer++) {
            for (int numbers = 0; numbers < totalNumbers; numbers++) {


                currentFunction = listOfFns.get(numbers);


                if (currentFunction.order == orderer) {

                    //want loop that moves through number boxes, tests orders, if finds no match moves to next order and restarts number loop.
                    currentFunction.setcalculatedAnswer(Math.calculateIt(currentFunction.getNumber1(), currentFunction.getOperator(), currentFunction.getNumber2()));


                    listOfFns = remakeFn(numbers, listOfFns, currentFunction.getAnswer());


                    totalNumbers--;



                    listOfFns.remove(numbers);


                    numbers = -1;


                }

            }

            //  number.set(numbers + 1, Math.calculateIt(number.get(numbers), operator.get(numbers), number.get(numbers + 1)));

        }
        //  GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(numbers)));
        //return number.get(numbers);


        return currentFunction.getAnswer();

    }


    void getX(double x) {
        this.x = x;
    }


    public ArrayList<FnStorer> remakeFn(int index, ArrayList<FnStorer> functions, double replacer) {

        FnStorer firstTerm;
        FnStorer thirdTerm;

        if (index > 0) {
            firstTerm = functions.get(index - 1);
            firstTerm.setNumber2(replacer);
            functions.set(index-1, firstTerm);
        }

        try {

            thirdTerm = functions.get(index+1);
            thirdTerm.setNumber1(replacer);

            functions.set(index + 1, thirdTerm);

        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {}

        return  functions;




    }
}



