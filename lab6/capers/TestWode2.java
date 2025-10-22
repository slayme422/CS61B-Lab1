package capers;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import static capers.Utils.readObject;
import static capers.Utils.writeObject;

public class TestWode2  {
    public static void main(String[] args) {
        Model m=new Model();
        File outFile=new File("capers/WechatIMG400.jpg");

        writeObject(outFile,m);


    }
}
