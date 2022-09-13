package dp;

/**
 * 背包问题
 */
public class Knapsack {


    public static void main(String[] args) {
      int [] weights={5,2,10,5,2};
      int [] values={3,5,10,2,5};
      //背包最大承重量
      int maxW=15;
      System.out.println(maxValueExactly(weights,values,maxW));


    }

    /**
     * 刚好装满
     * @param weights
     * @param values
     * @param capacity
     * @return
     */
    public static int  maxValueExactly(int weights[],int values[],int capacity){
        if(values==null||values.length<=0){
            return 0;
        }
        if(weights==null||weights.length<=0){
            return 0;
        }
        int dp[]=new int[capacity+1];

        for(int j=1;j<=capacity;j++){
            dp[j]=Integer.MIN_VALUE;
        }

        for(int i=1;i<=values.length;i++){

            for(int j=capacity;j>=weights[i-1];j--){
                dp[j]=Math.max(dp[j],values[i-1]+dp[j-weights[i-1]]);
            }

        }
        return dp[capacity]<=0 ? -1 :dp[capacity];

    }

    public static int  maxValue1(int weights[],int values[],int capacity){
        if(values==null||values.length<=0){
            return 0;
        }
        if(weights==null||weights.length<=0){
            return 0;
        }
        int dp[]=new int[capacity+1];

        for(int i=1;i<=values.length;i++){

            for(int j=capacity;j>=weights[i-1] ;j--){
                    dp[j]=Math.max(dp[j],values[i-1]+dp[j-weights[i-1]]);
            }

        }
        return dp[capacity];

    }


    public static int  maxValue(int weights[],int values[],int capacity){
        if(values==null||values.length<=0){
            return 0;
        }
        if(weights==null||weights.length<=0){
            return 0;
        }
        int dp[][]=new int[values.length+1][capacity+1];

        for(int i=1;i<=values.length;i++){

            for(int j=1;j<=capacity;j++){

               if(j<weights[i-1]){
                  dp[i][j]=dp[i-1][j];
               }else{
                  dp[i][j]=Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weights[i-1]]);
               }

            }

        }
        return dp[values.length][capacity];

    }




}
