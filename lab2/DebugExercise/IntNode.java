

public class IntNode<AnyType> {
    AnyType item;
    IntNode next;


    public IntNode(AnyType i, IntNode n) {
        item = i;
        next = n;
    }
}
     class SLList<AnyType> {
        public IntNode<AnyType> sentinel;
        public int size;
         public static String trainer = "Ash";

       //The first item (if it exists) is at sentinel.next.
        public SLList(){
            sentinel= new IntNode(63,null);
            size=0;

        }
        public SLList(AnyType x) {
            sentinel = new IntNode(63,null);
            sentinel.next=new IntNode(x,null);
            size=size+1;

        }
        //目标，我们想要在SLList头部添加一个新的链表
        public void addFirst(AnyType  x){
            sentinel.next = new IntNode<>(x, sentinel.next);
            size=size+1;
        }
        //目标, 我们想要在list的结尾处加一个新的IntNode对象，传入一个参数x
        public void addLast(AnyType x){

            size=size+1;
            IntNode current=sentinel;
            while(current.next != null){
                current=current.next;
            }
            current.next = new IntNode(x, null);
        }
        //目标:我们是想要获取一个链表的所有元素
        public void getAll(){

            System.out.print("(");
            IntNode p =sentinel.next;//只要不为空就打印
            while (p!=null) {
                System.out.print(p.item);
                if (p.next == null) {
                    break;
                } else {
                    System.out.print( "->");
                    p = p.next;
                }

            }
            System.out.print(")");
        }

    public static void main(String[] args) {
            SLList<String> L=new SLList<String>("Kensho");


        L.getAll();

        System.out.println();
        System.out.println(L.size);
        DebugExercise.SLList.trainer="Ash";
        System.out.println(DebugExercise.SLList.trainer);
        System.out.println(DebugExercise.SLList.trainer);
    }

}


