import java.util.ArrayList;

/**
 * this is a class that saves a triangle info
 */
public class Triangle extends Polygon {

    /**
     * create a rectangle with given sides
     * @param side1 double first side
     * @param side2 double second side
     * @param side3 double third side
     */
    public Triangle(Double side1, Double side2, Double side3) {
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
    }


    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        double area = Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
        return area;
    }

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("TRIANGLE||");
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
        else if (!(o instanceof Rectangle )){
            return false;
        }
        else {
            ArrayList<Double> sides2 = ((Rectangle) o).getSides();
            boolean flag = false;
            for (Double side: sides) {
                for (Double side1: sides2) {
                    flag = false;
                    if (side.equals(side1)) {
                        flag = true;
                        sides2.remove(side1);
                        break;
                    }
                }
            }
            if (flag){
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * get a string includes triangle info
     * @return string info of triangle
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TRIANGLE||");
        for (int i = 0; i < sides.size(); i++) {
            sb.append("SIDE" + i + ": ");
            sb.append(sides.get(i).toString());
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * check if triangle id equilateral
     * @return true if yes false otherwise
     */
    public boolean isEquilateral() {
        double side1 = sides.get(0);
        boolean flag = true;
        for (Double side: sides) {
            if (!side.equals(side1))
                flag = false;
        }
        return flag;
    }
}
