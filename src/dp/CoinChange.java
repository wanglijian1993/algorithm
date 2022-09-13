package dp;

public class CoinChange {

    public static void main(String[] args) {

        // 25,20,5,1
        System.out.println(coin2(41));

    }


    static int coin2(int n){
        if(n<=0){
            return 0;
        }
        int[]dp=new int[n+1];
        for(int i=1;i<n;i++){

            int mid=Integer.MAX_VALUE;
           if(i>1) dp[i]=Math.min(mid,dp[i-1]);
            if(i>5) dp[i]=Math.min(mid,dp[i-5]);
            if(i>20) dp[i]=Math.min(mid,dp[i-20]);
            if(i  >25) dp[i]=Math.min(mid,dp[i-25]);
            dp[i]=mid+1;
        }
        return dp[n];

    }



    /**
     * 记忆化搜索法（自顶向下）
     * @param n
     * @return
     */
    static int coin1(int n){
        if(n<=0){
            return 0;
        }
        int[]dp=new int[n+1];
        int[] nums=new int[]{25,20,5,1};
        for(int i=0;i<nums.length;i++){
            if(n<nums[i]){
                dp[nums[i]]=1;
            }
        }
        dp[5]=1;dp[20]=1;dp[1]=1;dp[25]=1;
       return coin1(n,dp);
    }

    static int coin1(int n ,int[]dp){
        if(n<=0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]==0) {
            int min1 = Math.min(coin1((n - 25), dp), coin1((n - 20), dp));
            int min2 = Math.min(coin1((n - 5), dp), coin1(n - 1, dp));
            return Math.min(min1, min2)+1;
        }
        return dp[n];
    }

    /**
     * 暴力递归
     * 自顶向下
     * 重叠子问题
     * @param n
     * @return
     */
    static int coin(int n){
        if(n<=0){
            return Integer.MAX_VALUE;
        }
        if(n==25||n==20||n==5||n==1){
            return 1;
        }
        int min1=Math.min(coin(n-25),coin(n-20));
        int min2=Math.min(coin(n-5),coin(n-1));
       return Math.min(min1,min2)+1;

    }




}
