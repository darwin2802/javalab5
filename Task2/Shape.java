package model;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable
{
    private static final long serialVersionUID = 1L;

    protected String shapeColor;

    public Shape(String shapeColor)
    {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String toString()
    {
        return "Shape [color=" + shapeColor + "]";
    }

    public String getShapeColor() {
        return shapeColor;
    }
}