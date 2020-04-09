/**
 * this is a class that save a circle info
 */
public class Circle extends Shape{
    private final static double PI = Math.PI;
    private double radius;

    /**
     * create a circle with radius
     * @param radius int radius of a circle
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * get the radius of circle
     * @return int the radius of circle
     */
    public double getRadius() {
        return radius;
    }


    @Override
    public double calculatePerimeter() {
        return PI * 2 * radius;
    }

    @Override
    public double calculateArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("CIRCLE||");
        sb.append("PERIMETER: ");
        sb.append(calculatePerimeter());
        sb.append("||AREA: ");
        sb.append(calculateArea());
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * check if two object is similar or not
     * @param o the object to compare
     * @return true if they are similar and false otherwise
     */
    public boolean equals(Shape o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof Circle )){
            return false;
        }
        else {
            if (this.radius == ((Circle) o).getRadius())
                return true;
            else
                return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CIRCLE||");
        sb.append("RADIUS: ");
        sb.append(radius);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
