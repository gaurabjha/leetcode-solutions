public class BuySellStock {
    public static void main(String[] args) {
        System.out.println(new Solution309().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new Solution309().maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }
}

class Solution309 {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[] s0 = new int[size];  // Either You can Buy or Rest
        int[] s1 = new int[size];  // Either You can Sell or Rest
        int[] s2 = new int[size];  // Either You can Only Rest
        s1[0] = -prices[0];
        s0[0] = 0;
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < size; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
            s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
        }
        return Math.max(s0[size - 1], s2[size - 1]);
    }

    public int maxProfit2(int[] prices) {
        int sold = 0;
        int bought = Integer.MIN_VALUE;
        int rest = 0;

        for (int i = 0; i < prices.length; i++) {
            //Profits If my current transaction is Buying
            bought = Math.max(bought, rest - prices[i]);
            //Profits If my current transaction is CoolDown or Rest
            rest = Math.max(rest, sold);  //sold is the last ( i-1 ) Sold Profits
            //Profits If my current transaction is Selling
            sold = bought + prices[i];
        }
        return Math.max(sold, rest);
    }
}