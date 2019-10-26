package chapter1;

public class Dog {
    /**part 1*/
    /*public static void makenoise(){
        System.out.println("Bark");
    }*/

    /**part 2*/
    /*public int weightInPounds;
    public void makenoise(){
        if (weightInPounds < 10){
            System.out.println("yipyip");
        }
        else if(weightInPounds < 30){
            System.out.println("barkbark");
        }
        else{
            System.out.println("wolfwolf");
        }
    }*/

    /**part 3*/
    public int weightInPounds;
    public static String binomen = "Canis familiaris";

    public Dog(int w){
        weightInPounds = w;
    }

    public void makenoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyip");
        } else if (weightInPounds < 30) {
            System.out.println("barkbark");
        } else {
            System.out.println("wolfwolf");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2){
        if (d1.weightInPounds > d2.weightInPounds){
            return d1;
        } else{
            return d2;
        }
    }

    public Dog maxDog(Dog d2){
        if(this.weightInPounds > d2.weightInPounds){
            return this;
        } else {
            return d2;
        }
    }
}
