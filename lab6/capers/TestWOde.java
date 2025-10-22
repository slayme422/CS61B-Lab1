package capers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestWOde {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        File f=new File("capers/trademark USA baby keem.MP3");
        File outFile=new File("musicDic");
        try {
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(f);
            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}
