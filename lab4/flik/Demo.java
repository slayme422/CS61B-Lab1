package flik;

public class Demo {
    public interface Sphere {
        default void getRadius() { System.out.println(0); }
    }

    class Planet implements Sphere {
        private int radius = 5;

        @Override
        public void getRadius() { System.out.println(this.radius); }

        public void orbit(Planet p) { System.out.println("orbit planet"); }
    }

    class Exoplanet extends Planet {
         int distance = 10;

        public void getDistance() { System.out.println(distance); }

        @Override
        public void orbit(Planet p) { System.out.println("orbit exoplanet"); }
    }

}
