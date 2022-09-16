package sort;

public class InsertSort extends Sort{


    /**
     * 插入排序
     */
   static int[] insertSort(int[] nums){
       if(nums.length<=1)
           return nums;
        for(int i=1;i<nums.length;i++){
           //记录要插入的值
           int tempNum=nums[i];

           //记录下要移动的位置
           int j=i;
           while (j>0&&tempNum<nums[j-1]){
               nums[j]=nums[j-1];
               j--;
           }
           if(j!=i){
               nums[j]=tempNum;
           }

        }
        return nums;

    }

    public static void main(String[] args) {
        insertSort(nums);
        printNums();
    }
}
