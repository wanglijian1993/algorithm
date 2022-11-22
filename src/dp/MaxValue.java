package dp;

public class MaxValue {

    public static void main(String[] args) {

    }

    /**
     * 空间复杂度O(N)
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {

    int rows=grid.length;
    int cols=grid[0].length;
    int[][] dp=new int[rows][cols];

    for(int i=0;i<rows;i++){
        dp[i][0]=grid[i][0]+grid[i-1][0];
    }
    for(int i=0;i<cols;i++){
        dp[0][i]=grid[0][i]+grid[0][i-1];
    }

    for(int i=1;i<rows;i++){
        for(int j=1;j<cols;j++){
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+dp[i][j];
        }
    }

    return dp[rows-1][cols-1];
    }

    /**
     * 优化空间复杂度
     * @param grid
     * @return
     */
    public static int maxValue01(int[][] grid) {

        return 0;
    }



}
