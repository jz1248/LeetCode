package priv.zzy.solutions;

import priv.zzy.Solution;

public class T01547 extends Solution {

    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[n + 1][cuts.length + 1];
    }

    @Override
    public void run() {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
    }
}
