package randomizedtest;

import edu.princeton.cs.introcs.StdRandom;

public class testThreeAddThreeRemove {
    public static void main(String[] args) {

        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyList=new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyList.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                System.out.println("addLast(" + randVal + ")"+" from buggy");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggyListSize= buggyList.size();
                System.out.println("size: " + size);
                System.out.println("size: " + buggyListSize+" from buggy");
            } else if (operationNumber==2) {
                int size= L.size();
                if(size==0){
                    continue;
                }

                int num1=L.removeLast();
                int num2=buggyList.removeLast();
                System.out.println("size: "+size+"被删除的数字是: "+num1);
                System.out.println("size: "+size+"被删除的数字是: "+num2+" from buggy");
            }else if (operationNumber==3) {
                int size= L.size();
                int size2=buggyList.size();
                if(size==0 && size2==0){
                    continue;
                }
                int num2=L.getLast();
                int num3=buggyList.getLast();
                System.out.println("最后一个数字是 "+num2);
                System.out.println("最后一个数字是 "+num3+" from buggy");

            }
        }


    }

}