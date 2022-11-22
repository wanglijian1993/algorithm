package dp;

/**
 *  最长重复字串
 */
public class LcsSubString {
    public static void main(String[] args) {

        String str1="ABDCBd";
        String str2="ABDCBe";
        System.out.println(lcs1(str1,str2));

    }

    /**
     * 优化空间复杂度
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs1(String str1,String str2){

        if(str1==null||str2==null){
            return 0;
        }
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();

        char [] rows=char1;
        char[] columns=char2;

        if(char1.length>char2.length){
            rows=char2;
            columns=char1;
        }

        int[] dp=new int[columns.length+1];

        int max=0;
        for(int i=1;i<=rows.length;i++){
            int cur=0;
            for(int j=1;j<=columns.length;j++){
                int leftTop=cur;
                cur=dp[j];
                if(rows[i-1]==columns[j-1]){
                    dp[j]=leftTop+1;
                    max=Math.max(dp[j],max);
                }else{
                    dp[j]=0;
                }

            }

        }
        return max;
    }

    public static int lcs(String str1,String str2){

        if(str1==null||str2==null){
            return 0;
        }
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();
        int [][]dp=new int[char1.length+1][char2.length+1];
        int max=0;
        for(int i=1;i<=char1.length;i++){

            for(int j=1;j<=char2.length;j++){
                if(char1[i-1]==char2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }

        }
        return max;
    }


}
