package com.figures;

public class Circle extends Figure {

    private final double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException(
                    String.format("radius should be positive or zero, got %f", radius)
            );
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
