/**
 * ClockDisplay is a clockSimulator
 * that show a Clock
 *
 * @author alireza sahragerd
 * @version 1.0
 * @since 2020.03.16
 *
 */
import java.util.Calendar;
public class ClockDisplay {
    /**
     * second is the second part of Clock
     */
    private NumberDisplay second;
    /**
     * minute is the minute part of Clock
     */
    private NumberDisplay minute;
    /**
     * hour is the hour part of a Clock
     */
    private NumberDisplay hour;

    /**
     * ClockDisplay sets the Clock to system Clock
     * @param calendar get us system time
     */
    public ClockDisplay(Calendar calendar){
        second = new NumberDisplay(calendar.get(Calendar.SECOND), 60);
        minute = new NumberDisplay(calendar.get(Calendar.MINUTE), 60);
        hour = new NumberDisplay(calendar.get(Calendar.HOUR_OF_DAY), 24);
    }
    /**
     * set the second part of clock to second
     * @param second is the value that second should be reset to it
     */
    public void setSecond(int second){
        this.second.setValue(second);
    }

    /**
     * set the minute part of clock to minute
     * @param minute is the value that minute should be reset to it
     */
    public void setMinute(int minute){
        this.second.setValue(minute);
    }
    /**
     * set the hour part of clock to hour
     * @param hour is the value that hour should be reset to it
     */
    public void setHour(int hour){
        this.second.setValue(hour);
    }

    /**
     * show prints the time in standard output
     */
    public void Show(){
        System.out.println( hour.getValue() + ":" + minute.getValue() + ":" + second.getValue());
    }

    /**
     * timer increasing time second to second
     */
    public void timer(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        if(second.getValue().equals("59") && minute.getValue().equals("59")){
            second.increment();
            minute.increment();
            hour.increment();
        }
        else if( second.getValue().equals("59")){
            second.increment();
            minute.increment();
        }
        else{
            second.increment();
        }
    }
}
