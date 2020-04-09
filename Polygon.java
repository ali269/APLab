import java.util.ArrayList;

/**
 * this class saves a polygon info
 *
 * @author alireza sahragard
 * @since 2020-4-9
 */
public abstract class Polygon extends Shape{

    protected ArrayList<Double> sides = new ArrayList<>();

    /**
     * get the size of polygon
     * @return
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    @Override
    public double calculatePerimeter() {
        double sum = 0;
        for (Double side: sides) {
            sum += side;
        }
        return sum;
    }

}
