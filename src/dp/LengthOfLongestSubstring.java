package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长   不重复字符串
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {

        String  s = "au";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] c= s.toCharArray();
        if(c.length<=0){
            return 0;
        }
        Map<Character,Integer>  charMaps=new HashMap<>();
        //i-1 的上一次位置
        int li=0;
        int max=1;
        charMaps.put(c[0],0);
        for(int i=1;i<c.length;i++){
            Integer pi = charMaps.get(c[i]);
            if(pi!=null&&pi>=li){
                li=pi+1;
            }
            charMaps.put(c[i],i);
            max=Math.max(max,i-li+1);
        }
        return max;
    }
}
