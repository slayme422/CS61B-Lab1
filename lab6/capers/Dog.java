package capers;

import java.io.File;
import java.io.Serializable;
import static capers.Utils.*;

/** Represents a dog that can be serialized.
 * @author TODO
*/
public class Dog implements Serializable{ // TODO

    /** Folder that dogs live in. */
    static final File DOG_FOLDER = Utils.join(CapersRepository.CAPERS_FOLDER,"dogs"); // TODO (hint: look at the `join`
                                         //      function in Utils)

    /** Age of dog. */
    private int age;
    /** Breed of dog. */
    private String breed;
    /** Name of dog. */
    private String name;

    /**
     * Creates a dog object with the specified parameters.
     * @param name Name of dog
     * @param breed Breed of dog
     * @param age Age of dog
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *
     * @param name Name of dog to load
     * @return Dog read from file
     */
    public static Dog fromFile(String name) {
        // TODO (hint: look at the Utils file)
        File inFile=Utils.join(DOG_FOLDER,name);
        Dog thisDog = Utils.readObject(inFile, Dog.class);
        return  thisDog;
    }

    /**
     * Increases a dog's age and celebrates!
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
        saveDog();
    }

    /**
     * Saves a dog to a file for future use.
     */
    /*
    先去创建一个文件去保存
     */
    public void saveDog() {
        // TODO (hint: don't forget dog names are unique)
        // 每只狗存放在 DOG_FOLDER 里，以狗的名字命名文件

        File file = Utils.join(DOG_FOLDER, this.name);

        // 使用 Utils 的 writeObject 方法序列化保存 Dog 对象
        Utils.writeObject(file, (Serializable) this);
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            name, breed, age);
    }

}
