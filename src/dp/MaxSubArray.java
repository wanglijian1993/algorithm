package dp;

public class MaxSubArray {

    public static void main(String[] args) {
       int []nums={-2,1,-3,4,-1,2,-1,-5,4};
       System.out.println(maxArray1(nums));
    }

    /**
     * O(1) O(N)
     * @param nums
     * @return
     */
    public static int maxArray1(int[] nums){

        if(nums==null||nums.length<=0){
            return -1;
        }
        int dp=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){
            int prev=dp;
            if(prev>0){
                dp=nums[i]+prev;
            }else{
                dp=nums[i];
            }
            max=Math.max(dp,max);

        }
        return max;
    }

    /**
     * O(n) O(n)
     * @param nums
     * @return
     */
    public static int maxArray(int[] nums){

        if(nums==null||nums.length<=0){
            return -1;
        }
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        System.out.println("dp["+0+"]:"+dp[0]);

        for(int i=1;i<nums.length;i++){

            if(dp[i-1]>0){
                dp[i]=nums[i]+dp[i-1];
            }else{
                dp[i]=nums[i];
            }
            max=Math.max(dp[i],max);
            System.out.println("dp["+i+"]:"+dp[i]);

        }
        return max;
    }

}
