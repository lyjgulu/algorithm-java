public class lc0121 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] par = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(par));
    }

    public int maxProfitFun(int[] prices) {
        int n1 = 0, n2 = Integer.MIN_VALUE;
        for (int price : prices) {
            n1 = Math.max(n1, n2 + price);
            n2 = Math.max(n2, -price);
        }
        return n1;
    }
}
