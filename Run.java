public class Run {
    public static void main(String[] args) {
        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle(1.0, 4.0, 1.0, 4.0);
        Rectangle rect2 = new Rectangle(8.0, 5.0, 8.0, 8.0);
        Rectangle rect3 = new Rectangle(6.0, 6.0, 6.0, 6.0);


        Triangle tri1 = new Triangle(2.0, 2.0, 2.0);
        Triangle tri2 = new Triangle(4.0, 4.0, 6.0);

        Paint paint = new Paint();
        paint.addShape(circle1);
        paint.addShape(circle2);
        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(rect3);
        paint.addShape(tri1);
        paint.addShape(tri2);
        paint.drawAll();
        paint.paintAll();
    }
}
