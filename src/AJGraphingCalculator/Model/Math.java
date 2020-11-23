package AJGraphingCalculator.Model;

public class Math {

    public static enum OPERATOR {NOOP, PLUS, MINUS, DIVIDE, MULTIPLY, SQUARED, SQUAREROOT, POWER}



    public static double calculateIt(double arg1, OPERATOR mathOp, double arg2) {

        double calcAnswer;
        switch (mathOp) {
            case PLUS:
                calcAnswer = arg1 + arg2;
                break;
            case MINUS:
                calcAnswer = arg1 - arg2;
                break;
            case DIVIDE:
                calcAnswer = arg1 / arg2;
                break;
            case MULTIPLY:
                calcAnswer = arg1 * arg2;
                break;
            case SQUARED:
                calcAnswer = arg1*arg1;
                break;
            case SQUAREROOT:
                calcAnswer = sqrt(arg1);
                break;
            case POWER:
                calcAnswer= arg1;
                for (int i = 0; i < arg2; i++) {
                    calcAnswer = calcAnswer*arg1;
                }
                break;
            case NOOP:
            default:
                calcAnswer = arg1;
        }
        return calcAnswer;
    }

    public static double sqrt(double arg1) {
        double squareroot = arg1/2;
        double temp = squareroot;
        do
        {
            temp = squareroot;
            squareroot = (temp + (arg1 / temp)) / 2;
        }
        while ((temp - squareroot) != 0);
        return squareroot;
    }
}
