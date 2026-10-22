package SystemDesign.Problems.Pen;

import java.util.Objects;

public class FountainPen extends Pen {
    private final Ink ink;
    private final Nib nib;

    public FountainPen(String name, String brand, double price, ClosingType closingType, Ink ink, Nib nib) {
        super(name, brand, price, PenType.FOUNTAIN, closingType);
        this.ink = Objects.requireNonNull(ink, "ink must not be null");
        this.nib = Objects.requireNonNull(nib, "nib must not be null");
    }
    @Override
    public void write() {
        System.out.println("Writing with fountain pen using " + ink.getColor()
                + " ink and " + nib.getType() + " nib");
    }
    public Ink getInk() { return ink; }
    public Nib getNib() { return nib; }
}
