package SystemDesign.Problems.Pen;

import java.util.Objects;

public class GelPen extends Pen implements Refillable {
    private Refill refill;

    public GelPen(String name, String brand, double price, ClosingType closingType, Refill refill) {
        super(name, brand, price, PenType.GEL, closingType);
        this.refill = Objects.requireNonNull(refill, "refill must not be null");
    }
    @Override
    public void write() {
        System.out.println("Writing with gel pen using " + refill.getInk().getColor() + " ink");
    }
    @Override
    public void replaceRefill(Refill newRefill) {
        this.refill = Objects.requireNonNull(newRefill, "newRefill must not be null");
        System.out.println(getName() + ": refill replaced");
    }
    public Refill getRefill() { return refill; }
}
