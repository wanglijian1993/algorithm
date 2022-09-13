package dp;

public class LIS {

    public static void main(String[] args) {
        int []nums={1,2,3,4,5,1,6};
      System.out.println(lengthOfLIS(nums));
    }


    static int lengthOfLIS(int[] nums){

        if(nums==null||nums.length<=0){
            return 0;
        }
        int []dp=new int[nums.length];
        int max=1;
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],(dp[j]+1));
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;


    }

}
