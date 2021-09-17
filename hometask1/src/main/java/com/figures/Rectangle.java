package com.figures;

public class Rectangle implements Figure {

    private final double width, height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException(
                    String.format("sides should be positive or zero, got (%f, %f)", width, height)
            );
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
