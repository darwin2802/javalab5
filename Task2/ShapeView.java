package view;

import model.Shape;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeView
{
    public void displayShapes(Shape[] shapes)
    {
        for (Shape shape : shapes)
        {
            System.out.println(shape);
        }
    }

    public void printMessage(String message)
    {
        System.out.println(message);
    }

    public void displayShapesGroupedByColor(Shape[] shapes, String[] colorOrder)
    {
        for (String color : colorOrder) {
            List<Shape> shapesOfColor = Arrays.stream(shapes)
                    .filter(s -> s.getShapeColor().equals(color))
                    .collect(Collectors.toList());

            if (!shapesOfColor.isEmpty()) {
                printMessage(color + ":");
                for (Shape shape : shapesOfColor) {
                    System.out.println("   " + shape);
                }
            }
        }
    }
}