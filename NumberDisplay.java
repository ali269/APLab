/**
 * NumberDisplay class is a class that
 * created to display seconds, minutes & hours
 *@author alireza sahragard
 * @version 1.0
 * @since 2020.03.16
 */


public class NumberDisplay {
    /**
     * value is an integer to show the clock's
     * stage
     */
    private int value;
    /**
     * limit is a value to show the recursive of value to 0
     */
    private int limit;

    /**
     *
     * @param value to show the stage
     * @param limit to show when it reset to 0
     */
     public NumberDisplay(int value, int limit){
         this.value = value;
         this.limit = limit;
     }

    /**
     * setValue resets the value to int value
     * @param value is a int that value should be reset to it
     */
    public void setValue(int value){
         this.value = value;
    }
    /**
     * getValue gets the number with two digits
     * @return "0" + value if value is less than 10 otherwise value
     */
     public String getValue(){
         if(value < 10)
             return "0" + value;
         else
             return "" + value;
     }

    /**
     * getLimit gets the resetting value
     * @return limit
     */
     public int getLimit(){
         return limit;
     }

    /**
     * increment increase the value stage
     * and resets it to 0 if value == limit
     */
    public void increment(){
         value = (value + 1) % limit;
     }

    /**
     * print prints the number in two-digit format
     */
    public void print(){
         System.out.println(this.getValue());
     }
}
