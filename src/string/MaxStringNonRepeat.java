package string;


import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 */
public class MaxStringNonRepeat {


    public static void main(String[] args) {

        String str1="abcabcbb";
        String str2="bbbbb";
        System.out.println("str1:"+lengthOfLongestSubstring(str1));
        System.out.println("str2:"+lengthOfLongestSubstring(str2));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        // 用来保存每一个字符上一次出现的位置
        int[] prevIdxes = new int[128];
        for (int i = 0; i < prevIdxes.length; i++) {
            prevIdxes[i] = -1;
        }
        prevIdxes[chars[0]] = 0;
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            int pi = prevIdxes[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIdxes[chars[i]] = i;
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
