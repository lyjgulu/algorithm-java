public class lc0309 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        int dp_pre_0 = 0;
        for (int i = 1; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] pram = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(pram));
    }
}
