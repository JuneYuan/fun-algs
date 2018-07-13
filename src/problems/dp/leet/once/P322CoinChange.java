package problems.dp.leet.once;

import java.util.Arrays;

import org.junit.Test;

public class P322CoinChange {

    public int coinChange_DP_AC(int[] coins, int amount) {
        // dp[i]定义为：找开面总额为i的钱，需要的最小硬币数
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange_greedy_WA(int[] coins, int amount) {
        int mxIdx = coins.length - 1;
        int cnt = 0;
        Arrays.sort(coins);
        while (amount > 0) {
            // find the biggest possible coin
            while (mxIdx > 0 && coins[mxIdx] > amount) {
                mxIdx--;
            }
            
            amount -= coins[mxIdx];
            cnt++;
            if (amount != 0 && amount < coins[0])  return -1;
        }
        
        return cnt;
    }

    @Test
    public void test() {
    	int[] coins = {186,419,83,408};
    	int amount = 6249;
    	System.out.println(coinChange_DP_AC(coins, amount));
    }
}
