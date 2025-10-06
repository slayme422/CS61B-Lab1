
public class TestSort {
    public static void testSort(){
        String[]input={"i","have","an","egg"};
        String[]expected={"i","egg","have","an"};

        Sort.sort(input);

        for (int i = 0; i < input.length; i++) {
            if(!input[i].equals(expected[i])){
                System.out.println("在索引"+i+" 上两个元素不相同: Input: '"+input[i]+"' Expected: '"+expected[i]);
            }
        }

    }

    public static void main(String[] args) {
        testSort();
    }
}
