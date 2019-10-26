package chapter1;

public class DogLoop {
    public static void main(String[] args) {
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(25);
        Dog hugeDog = new Dog(150);

        Dog[] manyDog = new Dog[4];
        manyDog[0] = smallDog;
        manyDog[1] = hugeDog;
        manyDog[2] = new Dog(130);

        int i = 0;
        while(i < manyDog.length){
            Dog.maxDog(manyDog[i], mediumDog).makenoise();
            i = i + 1;
        }
        //barkbark;wolfwolf;wolfwolf;barkbark
    }
}
