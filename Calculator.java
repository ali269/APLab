public class Calculator {
    private static Double first;
    private static Double second;
    private static Double result;
    private static String operand;


    public static void setFirst(Double first1) {
        first = first1;
    }
    public static void setSecond(Double second1) {
        second = second1;
    }
    public static void setOperand(String operand1) {
        operand = operand1;
    }


    public static String getResult() {
        if (first != null) {
            if (first.intValue() != first || second.intValue() != second && operand.equals(Operand.REMAINDER))
                return "error: input mismatch";
        }
        calculate();
        if (operand.equals(Operand.REMAINDER))
            return ((Integer)result.intValue()).toString();
        return ((Double)result).toString();
    }

    private static void calculate() {
        switch (operand) {
            case Operand.ADD:
                result = first + second;
                first = (double)0;
                second = (double)0;
                break;
            case Operand.SUBTRACT:
                result = first - second;
                first = (double)0;
                second = (double)0;
                break;
            case Operand.PRODUCT:
                result = first * second;
                first = (double)0;
                second = (double)0;
                break;
            case Operand.DIVISION:
                if (second != 0) {
                    result = first / second;
                    first = (double)0;
                    second = (double)0;
                }
                break;
            case Operand.REMAINDER:
                result = (double) ((Double)first).intValue() % ((Double)second).intValue();
                first = (double)0;
                second = (double)0;
                break;
            case Operand.SIN:
                result = Math.sin(second);
                first = (double)0;
                second = (double)0;
                break;
            case Operand.COS:
                result = Math.cos(second);
                first = (double)0;
                second = (double)0;
                break;
            case Operand.TAN:
                result = Math.tan(second);
                first = (double)0;
                second = (double)0;
                break;
            case Operand.COT:
                result = 1 / Math.tan(second);
                first = (double)0;
                second = (double)0;
                break;
            case Operand.EXP:
                result = Math.exp(second);
                first = (double)0;
                second = (double)0;
                break;
            case Operand.LOG:
                result = Math.log10(second);
                first = (double)0;
                second = (double)0;
                break;
            default:
                break;
        }
    }
}