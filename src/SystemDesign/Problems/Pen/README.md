# Pen System UML — Java implementation

Java 11+; no external dependencies.

Compile and run from `src/main/java`:
```bash
javac com/example/pens/*.java
java com.example.pens.Main
```

Design:
- `Pen` is the abstract base class with shared data and behaviours.
- `BallPen` and `GelPen` implement `Refillable`; `replaceRefill` replaces only the refill.
- `Refill` groups `Ink` and `Nib`.
- `FountainPen` directly owns `Ink` and `Nib` in this model and does not implement `Refillable`.
- `InkFeature` lets an ink have multiple features simultaneously.
- `PenType` and `ClosingType` are enums.

The fountain pen's ink and nib are modeled as integral components per the requested requirements. Real fountain pens may support ink replenishment or nib replacement.
