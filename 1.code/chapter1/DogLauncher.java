package chapter1;

public class DogLauncher {
    /**part 1*/
    /*public static void main(String[] args) {
        Dog.makenoise();
    }*/

    /**part 2*/
    /*public static void main(String[] args) {
        Dog d;
        d = new Dog();
        d.weightInPounds = 71;
        d.makenoise();
    }*/

    /**part 3*/
    public static void main(String[] args) {
       /* Dog d = new Dog(20);
        d.makenoise();
        System.out.println(Dog.binomen);*/
        Dog d1 = new Dog(20);
        Dog d2 = new Dog(45);
        Dog bigger = Dog.maxDog(d1, d2);
        bigger.makenoise();
        Dog bigger_1 = d1.maxDog(d2);
        bigger_1.makenoise();


    }
}
