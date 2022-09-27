package string;

/**
 * 反转字符串
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 */
public class ReversalString {


    public static void main(String[] args) {

        String str1="the sky is blue";
        String str2="  hello world  ";
        String str3="M6eAL   RxnYFfCA kibo     oEw    z36tp     kufsBMitF K  sMG A 1 H io";
       System.out.println( "str1:"+reverseWords(str1));
        System.out.println("str2:"+reverseWords(str2));
        System.out.println("str2:"+reverseWords(str3));
    }

    /**
     * 解决思路
     * 三步操作
     * 1.去除多余空格
     * 2.字符反转
     * 3.对字符串反转
     * @param s
     * @return
     */
    public static String reverseWords(String s) {


         char[] c= s.toCharArray();
         boolean space=true;
         int cur=0;
         int len;
         //1.去除字符串多余空格
         for(int i=0;i<c.length;i++) {

             if (c[i] != ' ') {
                 c[cur++] = c[i];
                 space = false;
             } else if (space == false) {
                 c[cur++] =' ';
                 space = true;
             }

         }
         //space==true 最后一个是空格
         len=space?(cur-1):cur;

         if(len<=0)
           return "";

          //2.字符串反转
          toReversal(c,0,len);

          //3.对单个字符串进行逆序
          //前一个空格的位置
          int preSpace=-1;
          for(int i=0;i<len;i++){
             if(c[i]!= ' ')
                 continue;
              if(c[i]==' '){
                  toReversal(c,preSpace+1,i);
                  preSpace=i;
              }
          }
          toReversal(c,preSpace+1,len);

        return new String(c,0,len);
    }

    //对字符串进行逆序
    private static void toReversal(char[] chars,int l,int r){
        r--;
        while (r>l){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
    }

}
