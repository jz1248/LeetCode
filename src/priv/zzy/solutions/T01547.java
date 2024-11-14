package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.Arrays;

public class T01547 extends Solution {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] cutsNew = new int[m + 2];
        System.arraycopy(cuts, 0, cutsNew, 1, m);
        cutsNew[0] = 0;
        cutsNew[m + 1] = n;

        int[][] dp = new int[m + 2][m + 2];

        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + (cutsNew[j + 1] - cutsNew[i - 1]));
                }
            }
        }

        return dp[1][m];
    }

    @Override
    public void run() {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
    }
}
