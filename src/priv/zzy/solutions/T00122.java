package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00122 extends Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int i = 1;
        int ans = 0;
        do {
            while (i < prices.length && prices[i] < prices[i - 1]) {
                i++;
            }
            int buyPrice = prices[i - 1];
            while (i < prices.length && prices[i] >= prices[i - 1]) {
                i++;
            }
            ans += prices[i - 1] - buyPrice;
        } while (i < prices.length);
        return ans;
    }

    @Override
    public void run() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
