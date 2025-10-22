package capers;

import java.io.File;

import static capers.Dog.DOG_FOLDER;
import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD,"capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        CAPERS_FOLDER.mkdirs();
        DOG_FOLDER.mkdirs();
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    /**
     * 目的是为了添加text到一个固定文件里，记录他的存在
     * @param text
     */
    public static void writeStory(String text) {
        // 1. 获取故事文件
        File storyFile = Utils.join(CAPERS_FOLDER, "story");

        // 2. 如果存在，读取已有故事
        String existing = "";
        if (storyFile.exists()) {
            existing = Utils.readContentsAsString(storyFile);
        }

        // 3. 拼接新的文本（加换行）
        String updated = existing + text + "\n";

        // 4. 打印当前完整故事
        System.out.println(updated);

        // 5. 写回文件
        Utils.writeContents(storyFile, updated);
    }
    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // 先检查是否已经存在
        File dogFile = Utils.join(DOG_FOLDER, name);
        if (dogFile.exists()) { // 文件存在，说明狗已经存在
            System.out.println("Dog " + name + " already exists!");
            return;
        }

        // 创建新狗
        Dog d = new Dog(name, breed, age);
        d.saveDog();         // 保存到文件夹
        System.out.println(d);
    }

        // 创建新的狗对象


        // 打印狗信息

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        Dog d=Dog.fromFile(name);

        //提升这个对应狗的年龄
        d.haveBirthday();
    }
}
