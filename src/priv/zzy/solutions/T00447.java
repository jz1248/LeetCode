package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00447 extends Solution {
    public int numberOfBoomerangs(int[][] points) {
        long[][] d;
        int n = points.length;
        d = new long[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;
                    if (d[i][j] == 0) {
                        d[i][j] = dist(points[i], points[j]);
                        d[j][i] = d[i][j];
                    }
                    if (d[k][j] == 0) {
                        d[k][j] = dist(points[k], points[j]);
                        d[j][k] = d[k][j];
                    }
                    long d1 = d[i][j];
                    long d2 = d[k][j];
                    if (d1 == d2) ans += 1;
                }
            }
        }
        return ans;
    }

    public long dist(int[] p1, int[] p2) {
        return (long) (p1[0] - p2[0]) * (p1[0] - p2[0]) + (long) (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    @Override
    public void run() {
        int[][] ints = {
                {0, 0},
                {1, 0},
                {2, 0}
        };
        System.out.println(numberOfBoomerangs(ints));
        ints = new int[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        };
        System.out.println(numberOfBoomerangs(ints));
        ints = new int[][]{
                {1, 1}
        };
        System.out.println(numberOfBoomerangs(ints));
    }
}
