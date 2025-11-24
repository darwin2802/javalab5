package controller;

import model.Shape;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeController {
    private Shape[] shapes;

    public ShapeController(Shape[] shapes)
    {
        this.shapes = shapes;
    }

    public Shape[] getShapes()
    {
        return shapes;
    }

    public void setShapes(Shape[] shapes)
    {
        this.shapes = shapes;
    }

    public double totalArea()
    {
        return Arrays.stream(shapes)
                .mapToDouble(Shape::calcArea)
                .sum();
    }

    public double totalAreaByType(Class<?> type)
    {
        return Arrays.stream(shapes)
                .filter(shape -> shape.getClass().equals(type))
                .mapToDouble(Shape::calcArea)
                .sum();
    }

    public void sortByArea()
    {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
    }
}