package greedy;

public class Fenzhi {

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
      System.out.println(maxSubarray(nums));
    }

    static int maxSubarray(int[] nums){

        if(nums==nums&&nums.length<=0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int begin=0;begin<nums.length;begin++){
             int sum=0;
            for(int end=begin;end<nums.length;end++){
              sum+=nums[end];
               max=Math.max(max,sum);
            }
        }
    return max;
    }


}
