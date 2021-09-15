public class Circle extends Figure {

    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException(
                    String.format("radius should be positive or zero, got %f", radius)
            );
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
