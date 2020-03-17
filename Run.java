import java.util.Calendar;

public class Run {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        ClockDisplay myClock = new ClockDisplay(calendar);
        while(true){
            myClock.Show();
            myClock.timer();
        }
    }
}
