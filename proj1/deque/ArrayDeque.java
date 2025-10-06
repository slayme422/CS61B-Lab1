package deque;

import org.checkerframework.checker.units.qual.Length;

import java.util.Random;

public class ArrayDeque {

    /* Invariants
    1:addLast添加的位置永远在position: size
    2.最后的位置永远都在position:size-1
    3.addLast之后nextLast永远都是(nextLast+1)%array.length (mod array.length)
    4.addFirst之后nextFirst永远都是(nextFirst-1+array.length)%array.length(mod array.length)
    5.getLast的位置永远都是(nextLast-1+array.length)%array.length
    6.getFirst的位置永远都在(nextFirst+1)%array.length
    7.nextLast的初始位置永远都在nextLast上
    */
    public int[]array;
    public int size;
    public int nextFirst;
    public int nextLast;
    public ArrayDeque(){
        array=new int[8];
        nextFirst=array.length/2;
        nextLast=(nextFirst+1) % array.length;
    }

    public void resize(int capacity) {
        int[] newArray = new int[capacity];

        for (int i = 0; i < size; i++) {
            int index=(nextFirst+i+1)%array.length;
            newArray[i]=array[index];
        }
        nextFirst=capacity-1;
        nextLast=size;
        array=newArray;
    }
    /** Returns the item from the back of the list. */
    public int getLast() {
        if(size==0){
            return -1;
        }
        int index=(nextLast-1+array.length)%array.length;

        return array[index];
    }
    public void addFirst(int x) {
        if(size== array.length){
            resize(size*2);
        }
        array[nextFirst]=x;
        nextFirst=(nextFirst-1+array.length)% array.length;
        size++;
    }
    public int getFirst(){
        if(size==0){
            return -1;
        }
        int index=(nextFirst+1)%array.length;
        return array[index];
    }

    public void addLast(int x){
        if(size==array.length){
            resize(size*2);
        }
        array[nextLast]=x;
        nextLast=(nextLast+1)%array.length;
        size++;
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i < 0 || i >= size) {
            return -1; // 索引越界
        }
        // 修正：考虑循环数组的索引计算
        int index = (nextFirst + 1 + i) % array.length;
        return array[index];
    }


    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        if (size == 0) {
            return -1;
        }

        // 先获取要删除的元素
        int currentLast = (nextLast - 1 + array.length) % array.length;
        int rmNum = array[currentLast];

        // 删除元素
        array[currentLast] = 0;
        nextLast = currentLast;
        size--;

        // 调整大小（在删除后检查）
        if (size > 0 && size <= array.length / 4 && array.length >= 16) {
            resize(array.length / 2);
        }

        return rmNum;
    }

    /** Deletes item from front of the list and returns deleted item. */
    public int removeFirst() {
        if (size == 0) {
            return -1;
        }

        int currentFirst = (nextFirst + 1) % array.length;
        int rmNum = array[currentFirst];

        // 删除元素
        array[currentFirst] = 0;
        nextFirst = currentFirst;
        size--;

        // 调整大小（在删除后检查）
        if (size > 0 && size <= array.length / 4 && array.length >= 16) {
            resize(array.length / 2);
        }

        return rmNum;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void printDeque() {
        System.out.print("Deque内容: ");
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        Random rand = new Random();
        ArrayDeque ad=new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            int randomChoice= rand.nextInt(4);

            if(randomChoice==0){
                int randomNumber=rand.nextInt(100);
                ad.addFirst(randomNumber);
                System.out.println("添加了"+randomNumber);
                System.out.println("addFirst: "+ad.getFirst());
            }
            else if(randomChoice==1){
                int randomNumber=rand.nextInt(100);
                ad.addLast(randomNumber);
                System.out.println("添加了"+randomNumber);
                System.out.println("getLast: "+ad.getLast());
            }
            else if(randomChoice==2){
                if(ad.size==0){
                    continue;
                }
                ad.removeLast();
                System.out.println("size是"+ad.size());;
            }
        }
    }
}
