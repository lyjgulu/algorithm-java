public class lc0123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int dp_i_1_0 = 0, dp_i_1_1 = -prices[0], dp_i_2_0 = 0, dp_i_2_1 = -prices[0];
        for (int i = 1; i < len; i++) {
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
            dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
        }
        return dp_i_2_0;
    }
}
