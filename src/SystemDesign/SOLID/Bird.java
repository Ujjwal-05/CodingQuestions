package SystemDesign.SOLID;

 abstract class Bird {

    String name;
    String colour;
    int weight;

     public Bird(String name, String colour, int weight) {
         this.name = name;
         this.colour = colour;
         this.weight = weight;
     }

     public void eat(){
         System.out.println( name + " can eat!");
     }
 }

