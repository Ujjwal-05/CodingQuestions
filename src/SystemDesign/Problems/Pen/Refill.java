package SystemDesign.Problems.Pen;

import java.util.Objects;

public class Refill {
    private final Ink ink;
    private final Nib nib;

    public Refill(Ink ink, Nib nib) {
        this.ink = Objects.requireNonNull(ink, "ink must not be null");
        this.nib = Objects.requireNonNull(nib, "nib must not be null");
    }
    public Ink getInk() { return ink; }
    public Nib getNib() { return nib; }

    @Override
    public String toString() { return "Refill{ink=" + ink + ", nib=" + nib + '}'; }
}
