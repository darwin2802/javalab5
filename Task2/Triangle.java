package model;

public class Triangle extends Shape
{
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height)
    {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    public double calcArea()
    {
        return 0.5 * base * height;
    }

    public void draw()
    {
        System.out.println("Drawing a Triangle...");
    }

    public String toString()
    {
        return "Triangle [color=" + shapeColor + ", base=" + String.format("%.2f", base) + ", " +
                "height=" + String.format("%.2f", height) + ", area=" + String.format("%.2f", calcArea()) + "]";
    }
}