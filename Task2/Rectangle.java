package model;

public class Rectangle extends Shape
{
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height)
    {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    public double calcArea()
    {
        return width * height;
    }

    public void draw()
    {
        System.out.println("Drawing a Rectangle...");
    }

    public String toString()
    {
        return "Rectangle [color=" + shapeColor + ", width=" + String.format("%.2f", width) + ", " +
                "height=" + String.format("%.2f", height) + ", area=" + String.format("%.2f", calcArea()) + "]";
    }
}