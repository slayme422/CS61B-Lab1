package flik;

public class Launcher {
    public static void main(String[] args) {
        // 如果 Demo 是包名，Planet 是类名
        Demo demo=new Demo();
        Demo.Planet p = demo.new Planet();

    }
}