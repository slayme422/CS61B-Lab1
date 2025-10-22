package DisjointSets;

public class QuickUnion  {
    private int[] parent;
    int []size;
    QuickUnion(int N){
        parent =new int[N];
        for (int i = 0; i < N; i++) {
            parent[i]=-1;
        }
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i]=1;
        }
    }
    //寻找这个root位置
    private int find(int p){
       if(parent[p]==-1){
           return p;
       }
       parent[p]=find(parent[p]);
       return parent[p];
    }
    //只要他们两个root都是一个东西就会返回True,否则:False
    private boolean IsConnected(int p,int q){
        return find(p)==find(q);
    }

    public int size(int p){
        return size[find(p)];
    }

    public void connect(int p,int q){
        int rootP=find(p);
        int rootQ =find(q);

        if(rootP == rootQ) return; // 已经连通

        if(size[rootP] >= size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] = size[rootQ]+size[rootP];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] = size[rootP]+size[rootQ];
        }
    }

    public static void main(String[] args) {
        QuickUnion qu=new QuickUnion(9);
        qu.connect(1,2);

        qu.connect(2,3);

        System.out.println("expected: 3==1"+qu.size(3) );
        System.out.println("expected: 1==3"+qu.size(1));

    }
}
