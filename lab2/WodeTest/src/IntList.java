public class IntList {
    public int first;
    public IntList rest;//第二个结构是IntList

    public IntList(int f, IntList r) {
        first = f;
        rest= r;

    }

    public static void main(String[] args) {
        IntList l=new IntList(15,null);
        l.rest=new IntList(10,null);
        System.out.println(l.first);//15
        System.out.println(l.rest.first);//10
    }
}

