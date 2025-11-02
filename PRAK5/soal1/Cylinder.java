package soal1;

public class Cylinder extends Shape {
    double radius, height;

    public Cylinder(String n, double r, double h) {
        super(n);
        radius = r;
        height = h;
    }

    public double area()
    {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public String toString()
    {
        return shapeName + " of radius " + radius + " and height " + height;
    }
}
