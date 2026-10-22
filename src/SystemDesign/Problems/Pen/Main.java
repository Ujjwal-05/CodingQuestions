package SystemDesign.Problems.Pen;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        Ink blueInk = new Ink("Blue", EnumSet.of(InkFeature.WATERPROOF, InkFeature.TRANSPARENT));
        Refill ballRefill = new Refill(blueInk, new Nib(0.5, "Fine"));
        BallPen ballPen = new BallPen("Classic Ball Pen", "ExampleBrand", 25.0, ClosingType.CLICK, ballRefill);

        Ink blackGelInk = new Ink("Black", EnumSet.of(InkFeature.SPARKLING, InkFeature.WATERPROOF));
        GelPen gelPen = new GelPen("Smooth Gel Pen", "ExampleBrand", 40.0, ClosingType.CAP,
                new Refill(blackGelInk, new Nib(0.7, "Medium")));

        FountainPen fountainPen = new FountainPen("Classic Fountain Pen", "ExampleBrand", 250.0,
                ClosingType.CAP, new Ink("Royal Blue", EnumSet.of(InkFeature.TRANSPARENT)),
                new Nib(0.8, "Medium"));

        ballPen.open();
        ballPen.write();
        ballPen.replaceRefill(new Refill(
                new Ink("Red", EnumSet.of(InkFeature.WATERPROOF)), new Nib(0.6, "Fine")));
        ballPen.write();
        ballPen.close();
        gelPen.write();
        fountainPen.write();

        System.out.println("Blue ink features: " + blueInk.getFeatures());
        System.out.println("Fountain pen nib: " + fountainPen.getNib());
    }
}
