package 算法高频题;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 */
public class 移动零 {

    public static void main(String[] args) {
        int[] nums= new int[]{1,0,1};

        moveZeroes(nums);
      for(int i=0;i<nums.length;i++){
          System.out.println("i:"+nums[i]);
      }
    }



    public static void moveZeroes(int[] nums) {
        //记录0所在的最开始的位置
        int j=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=0&&nums[j]==0){
                swithValue(nums,i,j);
                j++;
            }else if(nums[i]!=0){
               j++;
           }

        }

    }

    private static void swithValue(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
