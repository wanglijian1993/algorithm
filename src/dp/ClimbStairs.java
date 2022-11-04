package dp;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs01(5));

    }
    static HashMap<Integer,Integer> map = new HashMap();
    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
//
//        if(n==1||n==2){
//            return n;
//        }
//
//        return climbStairs(n-1)+climbStairs(n-2);

        if(n == 1) return 1;
        if(n == 2) return 2;

        if(map.containsKey(n))
            return map.get(n);

        int sum = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n,sum);

        return sum;


    }

    public static int climbStairs01(int n){

        int f = 0, s = 0, t = 1;
        for (int i = 1; i <= n; ++i) {
          f=s;
          s=t;
          t=f+s;
        }
        return t;

    }
}
