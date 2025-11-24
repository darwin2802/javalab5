package model;

public class Circle extends Shape
{
    private double radius;

    public Circle(String shapeColor, double radius)
    {
        super(shapeColor);
        this.radius = radius;
    }

    public double calcArea()
    {
        return Math.PI * radius * radius;
    }

    public void draw()
    {
        System.out.println("Drawing a Circle...");
    }

    public String toString()
    {
        return "Circle [color=" + shapeColor + ", radius=" + String.format("%.2f", radius) + ", " +
                "area=" + String.format("%.2f", calcArea()) + "]";
    }
}