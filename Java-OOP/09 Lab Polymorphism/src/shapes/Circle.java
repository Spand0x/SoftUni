package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    public void  setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return this.radius * Math.PI * 2;
    }

    @Override
    public double calculateArea() {
        return this.radius * this.radius * Math.PI ;
    }
}
