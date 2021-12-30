public class lc0188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        k = Math.min(k, len / 2);
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}
