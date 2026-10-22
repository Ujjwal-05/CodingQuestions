package SystemDesign.Problems.Pen;

public class Nib {
    private final double radius;
    private final String type;

    public Nib(double radius, String type) {
        if (radius <= 0) throw new IllegalArgumentException("Nib radius must be greater than zero");
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Nib type must not be blank");
        this.radius = radius;
        this.type = type;
    }
    public double getRadius() { return radius; }
    public String getType() { return type; }

    @Override
    public String toString() { return "Nib{radius=" + radius + ", type='" + type + "'}"; }
}
