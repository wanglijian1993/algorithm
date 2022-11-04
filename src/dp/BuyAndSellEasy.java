package dp;


/**01
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 例子
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *  02
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 */
public class BuyAndSellEasy {


    public static void main(String[] args) {
        //简单买卖股票
        int[]  prices={7,1,5,3,6,4};
       System.out.println(maxProfit01(prices));
        System.out.println(maxProfit02(prices));
        System.out.println(maxProfit02_01(prices));

    }

    /**
     * 简单买卖股票
     * @param prices
     * @return
     */
    public static int maxProfit01(int[] prices) {

        if(prices.length<=0)
            return 0;
        int minPrices=prices[0];
        int maxPreices=0;
        for(int i=1;i<prices.length;i++){

            if(prices[i]<minPrices){
                minPrices=prices[i];
            }else{
                maxPreices=Math.max(maxPreices,prices[i]-minPrices);
            }
        }
        return maxPreices;
    }


    /**
     * 中等苦难
     * @param prices
     * @return
     */
    public static int maxProfit02(int[] prices){

        if(prices.length<1)
            return 0;
        int len=prices.length;
        int [][] dp=new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];

    }


    /**
     * 中等苦难
     * 优化空间
     * @param prices
     * @return
     */
    public static int maxProfit02_01(int[] prices){

        if(prices.length<1)
            return 0;
        int len=prices.length;

        int cash=0;
        int hold=-prices[0];
        int preCash=cash;
        int preHold=hold;
        for(int i=0;i<len;i++){
            cash=Math.max(preCash,preHold+prices[i]);
            hold=Math.max(preHold,preCash-prices[i]);
            preCash=cash;
            preHold=hold;
        }
        return cash;


    }


}
