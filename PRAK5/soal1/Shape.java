package soal1;

public abstract class Shape {
    protected String shapeName;

    public Shape(String n)
    {
        shapeName = n;
    }

    protected abstract double area();
    @Override
    public abstract String toString();
}
