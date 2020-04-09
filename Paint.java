import java.util.ArrayList;

/**
 * this is a class to paint shapes
 *
 * @author alireza sahragard
 * @since 2020-4-9
 */
public class Paint {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    /**
     * add a shape to shapes of a list
     * @param shape shape to add to the list
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * print what is a shape
     */
    public void drawAll() {
        for(Shape shape: shapes) {
            System.out.println(shape.draw());;
        }
    }

    /**
     * print all shapes properties
     */
    public void paintAll() {
        for (Shape shape: shapes) {
            System.out.println(shape.toString());;
        }
    }
}
