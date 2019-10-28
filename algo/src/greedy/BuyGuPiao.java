package greedy;

/**
 * 买卖股票的最佳时机 II
 * 简单
 * 贪心
 */
public class BuyGuPiao {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int sum = new BuyGuPiao().maxProfit(prices);
        System.out.println(sum);
    }


    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }


}
