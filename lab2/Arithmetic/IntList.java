public class IntList {
    public int first;
    public IntList rest;//第二个结构是IntList


public IntList(int f, IntList r){
    first = f;
    rest = r;
}
//返回这个IntList的大小 有recursion的版本
public int size(){
    //base case
    if (this.rest==null){
        return 1;
    }

    return 1+this.rest.size();
}
//靠while循环来找size
public int IterateSize(){
    int totalSize=0;
    IntList p=this;
    while(p!=null){
        totalSize+=1;
        p=p.rest;
    }
    return totalSize;
}
public int get(int n){
    IntList p =this;
    int currentIndex=0;
    while(p!=null){
        if(currentIndex==n){
            return p.first;
        }
        currentIndex+=1;
        p=p.rest;
    }
    return -1;
}
public int getRecursive(int n){
    if(n==0){
        return first;
    }
    return this.rest.getRecursive(n-1);
}
/*
incrList(L,2)
>>>IntList L=new IntList(3,null);
>>>incrList(L, 1)
(3)->(43)
 */



public static IntList incrList(IntList L, int x){
    IntList nextL=new IntList((L.first+x)*10+L.first,null);
    L.rest=nextL;
    return L;
}
    public static void main(String[] args) {
            IntList l=new IntList(5,null);
            l=new IntList(10,l);
            l=new IntList(15,l);
        System.out.println(l.size());
        System.out.println(l.IterateSize());
        System.out.println(l.get(2));
        System.out.println(l.getRecursive(1));
        IntList L=new IntList(5,null);
        System.out.println(incrList(L, -1).first);
    }
}

