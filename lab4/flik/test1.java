package flik;

public class test1  {
    public static void main(String[] args) {
        //添加a和b
        int[]nums={1,2,3,4,5};

        // combine(f, int[]nums)
        //15
        Add addMethod=new Add();
        System.out.println(combine(addMethod, nums));
    }
    public static int combine(Predicate f, int [] nums){
        if(nums.length==0){return 0;}
        if(nums.length==1){return nums[0];}

        int t=f.apply(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            t=f.apply(t , nums[i]);
        }
        return t;
    }
    }