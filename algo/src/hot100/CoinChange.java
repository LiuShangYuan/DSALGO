package hot100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {

//        int[] coins = {1, 2, 5};
        int[] coins = {2147483647};
        System.out.println(new CoinChange().coinChange(coins, 2));
    }


    public int coinChange(int[] coins, int amount) {
        // 全用1, 再加1, 不会超过这个数目
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // 够减
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
