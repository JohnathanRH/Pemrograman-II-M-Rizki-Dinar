package soal1;

public class Rectangle extends Shape {
    private double length, width;

    public Rectangle(String n, double l, double w) {
        super(n);
        length = l;
        width = w;
    }

    public double area()
    {
        return length * width;
    }

    public String toString()
    {
        return shapeName + " of length " + length + " and width " + width;
    }
}
