package SystemDesign.Problems.Pen;

public abstract class Pen {

    private final String name;
    private final String brand;
    private final double price;
    private final PenType penType;
    private final ClosingType closingType;

    protected Pen(String name, String brand, double price, PenType penType, ClosingType closingType) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Pen name must not be blank");
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("Brand must not be blank");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.penType = penType;
        this.closingType = closingType;
    }
    public abstract void write();

    public void open() { System.out.println(name + " opened using " + closingType); }
    public void close() { System.out.println(name + " closed using " + closingType); }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public PenType getPenType() { return penType; }
    public ClosingType getClosingType() { return closingType; }
}
