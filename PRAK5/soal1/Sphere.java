package soal1;

public class Sphere extends Shape{
    private double radius;

    public Sphere(String n, double r)
    {
        super(n);
        radius = r;
    }

    public double area()
    {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public String toString()
    {
        return shapeName + " of radius " + radius;
    }
}
