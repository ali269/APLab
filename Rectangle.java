import java.util.ArrayList;

/**
 * this class saves a rectangle info
 */
public class Rectangle extends Polygon {
    /**
     * create a rectangle with given sides
     * @param side1 double first side
     * @param side2 double second side
     * @param side3 double third side
     * @param side4 double forth side
     */
    public Rectangle(Double side1, Double side2, Double side3, Double side4) {
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
    }

    @Override
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("RECTANGLE||");
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RECTANGLE||");
        for (int i = 0; i < sides.size(); i++) {
            sb.append("SIDE" + i + ": ");
            sb.append(sides.get(i).toString());
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * check if this is a square
     * @return true if square false otherwise
     */
    public boolean isSquare() {
        Double side1 = sides.get(0);
        boolean flag = true;
        for (Double side: sides) {
            if (!side.equals(side1))
                flag = false;
        }
        return flag;
    }

}
