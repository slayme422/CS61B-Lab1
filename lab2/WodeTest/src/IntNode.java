public class IntNode {
        int item;
        IntNode next;
        public static String trainer = "Ash";

        public IntNode(int i, IntNode n) {

            item = i;
            next = n;


        }

    public static void main(String[] args) {
        IntNode IN=new IntNode(3, null);

        System.out.println(IN.item);
        System.out.println();

    }
}

