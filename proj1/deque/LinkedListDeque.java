package deque;

public class LinkedListDeque<T> {
    private static class StuffNode<T> {
        StuffNode<T> next;
        StuffNode<T> prev;
        T item;

        public StuffNode(T x, StuffNode<T> n, StuffNode<T> p) {
            item = x;
            next = n;
            prev = p;
        }

        public T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }
    }
    private StuffNode <T>sentinel;
    int size;

    public LinkedListDeque(){
        sentinel = new StuffNode<>(null, null, null);
        sentinel.next = sentinel; // 空的时候自己指向自己
        sentinel.prev = sentinel;
        size=0;

    }

    public LinkedListDeque(T x) {
        sentinel=new StuffNode<>(null , null, null);
       sentinel.next =sentinel;
       sentinel.prev=sentinel;
       size=0;
      addFirst(x);
    }
    //addFirst永远在sentinel.next
    public void addFirst(T x){
        sentinel.next=new StuffNode<>(x,sentinel.next,sentinel);
        sentinel.next.next.prev=sentinel.next;
        size=size+1;
    }
    public void addLast(T x){
        StuffNode<T> newNode = new StuffNode<>(x, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
    public T removeFirst() {
        if (size == 0) return null;
        T temp=sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return temp;
    }

    public T removeLast() {
        if (size == 0) return null;
        T temp=sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return temp;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    };
    public T getFirst(){
        return sentinel.next.item;
    }
    public T getLast(){
        return sentinel.prev.item;
    }
    public T getRecursive(int index) {
        if (index >= size|| index<0) return null;
        return sentinel.next.getRecursive(index);
    }
    public void printDeque(){
        if (size == 0) return;
        StuffNode<T> curr = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListDeque <String>l=new LinkedListDeque<>();
        l.addFirst("Kensho");
        l.addLast("K");

        l.addFirst("Baby");
        System.out.println(l.getFirst());
        System.out.println(l.size);
        System.out.println(l.getRecursive(2));
        System.out.println(l.getLast());
        System.out.println("这里是"+2/3);


    }
}
