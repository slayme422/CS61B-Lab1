public class Dog {
    String name;
    int age;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Dog", 20);
        Dog [] dogList= new Dog[3];
        dogList[0] = dog;
        dogList[2]=new Dog("Dog", 20);
        for (int i = 0; i < dogList.length; i++) {
            System.out.println(dogList[i]);
        }

    }
}
