package sort;

public abstract class Sort<T>  {

    static int [] nums={2,3,9,12,3,2,5,8,3};

    static void printNums(){
        for(int i=0;i<nums.length;i++){
            System.out.println("sort:"+nums[i]);
        }
    }
    public static void swap(int i1, int i2) {
        int tmp =nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

}
