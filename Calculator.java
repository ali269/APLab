public class Calculator {
    private static double first;
    private static double second;
    private static double result;
    private static String operand;


    public static void setFirst(double first1) {
        first = first1;
    }
    public static void setSecond(double second1) {
        second = second1;
    }
    public static void setOperand(String operand1) {
        operand = operand1;
    }

    public static String getResult() {
        calculate();
        return ((Double)result).toString();
    }

    private static void calculate() {
        switch (operand) {
            case Operand.ADD:
                result = first + second;
                first = 0;
                second = 0;
                break;
            case Operand.SUBTRACT:
                result = first - second;
                first = 0;
                second = 0;
                break;
            case Operand.PRODUCT:
                result = first * second;
                first = 0;
                second = 0;
                break;
            case Operand.DIVISION:
                if (second != 0) {
                    result = first / second;
                    first = 0;
                    second = 0;
                }
                break;
            case Operand.REMAINDER:
                result = ((Double)first).intValue() % ((Double)second).intValue();
                first = 0;
                second = 0;
                break;
            case Operand.SIN:
                result = Math.sin(first);
                first = 0;
                second = 0;
                break;
            case Operand.COS:
                result = Math.cos(first);
                first = 0;
                second = 0;
                break;
            case Operand.TAN:
                result = Math.tan(first);
                first = 0;
                second = 0;
                break;
            case Operand.COT:
                result = 1 / Math.tan(first);
                first = 0;
                second = 0;
                break;
            case Operand.EXP:
                result = Math.exp(first);
                first = 0;
                second = 0;
                break;
            case Operand.LOG:
                result = Math.log10(first);
                first = 0;
                second = 0;
                break;
            default:
                break;
        }
    }
}