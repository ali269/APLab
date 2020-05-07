public class Operand {
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String PRODUCT = "*";
    public static final String DIVISION = "/";
    public static final String REMAINDER = "%";
    public static final String EQUALS = "=";


    public static final String[] commons = {
            ADD, SUBTRACT, PRODUCT,
            DIVISION, REMAINDER
    };

    public static final String SIN = "SIN";
    public static final String COS = "COS";
    public static final String TAN = "TAN";
    public static final String COT = "COT";
    public static final String EXP = "EXP";
    public static final String LOG = "LOG";

    public static final String[][] eng = {
            {SIN, TAN, EXP},
            {COS, COT, LOG}
    };

    private String operand;

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

}
