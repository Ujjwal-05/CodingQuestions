package SystemDesign.Problems.Pen;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Ink {
    private final String color;
    private final Set<InkFeature> features;

    public Ink(String color, Set<InkFeature> features) {
        this.color = Objects.requireNonNull(color, "color must not be null");
        Objects.requireNonNull(features, "features must not be null");
        this.features = features.isEmpty()
                ? EnumSet.noneOf(InkFeature.class)
                : EnumSet.copyOf(features);
    }
    public String getColor() { return color; }
    public Set<InkFeature> getFeatures() { return Set.copyOf(features); }

    @Override
    public String toString() {
        return "Ink{color='" + color + "', features=" + features + '}';
    }
}
