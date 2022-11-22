package dp;

/**
 * 最长回文子串
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 */
public class 最长回文字串 {

    public static void main(String[] args) {

        String str="babad";
        System.out.println(longestPalindrome(str));

    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindromeDp(String s) {
        if(s==null){
            return null;
        }
        char[] args=s.toCharArray();
        if(args.length==0){
            return s;
        }
        int len=args.length;
        Boolean[][] dp=new Boolean[len][len];
        int maxlen=1;
        int start=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                int longest=j-i+1;
                dp[i][j]=(args[i]==args[j])&&(longest<=2||dp[i+1][j-1]);
                if(dp[i][j]&&maxlen<longest){
                    maxlen=longest;
                    start=i;
                }
            }

        }
        return new String(args,start,maxlen);
    }


    public static String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        char[] args=s.toCharArray();
        if(args.length==0){
            return s;
        }
        int maxlen=0;
        String maxStr="";
        for(int i=1;i<args.length;i++){
           String maxPalindorme1= isLongsetPalindorme(args,i,i);
           String maxPalindorme2= isLongsetPalindorme(args,i-1,i);
           if(maxPalindorme1.length()>maxPalindorme2.length()) {
               if(maxlen<maxPalindorme1.length()){
                   maxStr=maxPalindorme1;
                   maxlen=maxPalindorme1.length();
               }
           }else{
               if(maxlen<maxPalindorme2.length()){
                   maxStr=maxPalindorme2;
                   maxlen=maxPalindorme2.length();
               }
           }

        }
     return maxStr;
    }
    /*
      判断字符串是否是回文子串
     */
    private static String isLongsetPalindorme(char[] c,int l,int r){
        int tempL=l;
        int tempR=r;
        while (tempL>0&&tempR<c.length){

            if(c[l]==c[r]){
                l++;
                r--;
            }else{
                return new String(c,tempL,tempR);
            }

        }

        return new String(c,tempL,tempR);

    }


}
