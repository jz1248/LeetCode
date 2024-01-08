package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00121 extends Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }

    @Override
    public void run() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
