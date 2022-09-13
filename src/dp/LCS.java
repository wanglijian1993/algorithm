package dp;

/**
 * 最长公共子序列
 */
public class LCS {

    public static void main(String[] args) {

        int num1[]={1,3,5,9,10};
        int num2[]={1,4,9,10};
//        System.out.println(lcs(num1,num1.length,num2,num2.length));
        System.out.println(lcs3(num1,num2));

    }

    public static int lcs3(int num1[], int num2[]){

        if(num1==null||num2==null) return 0;

        int rows[]=num1;
        int columns[]=num2;
        if(num1.length>num2.length){
            rows=num2;
            columns=num1;
        }
        int dp[]=new int[columns.length+1];
        for(int i=1;i<=rows.length;i++){
             int cur=0;
            for(int j=1;j<=columns.length;j++){
                int leftTop=cur;
                cur=dp[j];
                if(rows[i-1]==columns[j-1]){
                    dp[j]=leftTop+1;
                }else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }

            }

        }

     return dp[columns.length];
    }


    public static int lcs2(int []num1,int []num2){

        if(num1==null||num2==null){
            return 0;
        }
        int[] dp=new int[num2.length+1];

        for(int i=1;i<=num1.length;i++){
            int cur=0;
            for(int j=1;j<=num2.length;j++){
                int leftTop=cur;
                 cur =dp[j];
                if(num1[i-1]==num2[j-1]){
                    dp[j]=leftTop+1;
                }else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
            }
        }
        return dp[num2.length];

    }

    public static int lcs1(int []num1,int []num2){

        if(num1==null||num2==null){
            return 0;
        }
        int[][] dp=new int[2][num2.length+1];

        for(int i=1;i<=num1.length;i++){
           int row=i&1;
           int prev=(i-1)&1;

            for(int j=1;j<=num2.length;j++){

                if(num1[i-1]==num2[j-1]){
                    dp[row][j]=dp[prev][j-1]+1;
                }else{
                    dp[row][j]=Math.max(dp[prev][j],dp[row][j-1]);
                }
            }
        }
        return dp[num1.length&1][num2.length];

    }


    public static int lcs(int []num1,int i,int []num2,int j){
        if(i==0||j==0){
            return 0;
        }

        if(num1[i-1]==num2[j-1]){
            return lcs(num1,i-1,num2,j-1)+1;
        }

        return Math.max(lcs(num1,i-1,num2,j), lcs(num1,i,num2,j-1));



    }

}
