import java.sql.SQLOutput;
import java.util.Arrays;

public class DogLoop {
    public static void main(String[] args) {
        Dog d1 = new Dog(10);
        Dog d2 = new Dog(15);
        Dog d3 = new Dog(20);
        Dog d4 = new Dog(15);
        Dog d5 = new Dog(10);
        Dog d6 = new Dog(5);
        Dog d7 = new Dog(10);
        Dog d8 = new Dog(15);
        Dog d9 = new Dog(22);
        Dog d10= new Dog(20);

        Dog[] manyDogs = new Dog[]{d1,d2,d3,d4,d5,d6,d7,d8,d9,d10};
        /*
        Input: Dogs with size[10,20,30,25,20,40,10]
        Returns:Dogs with size[30,40]
        */
        System.out.println(Arrays.toString(
                dogProblem.largerThanFourNeighbours(manyDogs)));

    }

    }

    class Dog {
        public int size;

        /*这是个构造器 */
        public Dog(int s) {
            size = s;
        }
        public String toString() { return String.valueOf(size); }

        public void makeNoise() {
            if (size < 10) {
                System.out.println("hideous yapping");
            } else if (size < 30) {
                System.out.println("bark");
            } else {
                System.out.println("woof");
            }
        }


        public static Dog maxDog(Dog d1, Dog d2) {
            if (d1.size > d2.size) {
                return d1;
            }
            return d2;
        }
    }

        /*返回一个实例方法largerThanFourNeighbors
        只要比左边两个和右边两个大，他就算满足条件

         */


