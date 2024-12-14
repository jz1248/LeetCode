package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00135 extends Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = 1;
            }
        }
        int t = 1;
        int result = Math.max(ans[n - 1], t);
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                t = t + 1;
            } else {
                t = 1;
            }
            result += Math.max(ans[i], t);
        }
        return result;
    }

    @Override
    public void run() {
        int[] ratings;
        ratings = new int[]{1, 0, 2};
        System.out.println(candy(ratings));
        ratings = new int[]{1, 2, 2};
        System.out.println(candy(ratings));
        ratings = new int[]{1, 3, 4, 5, 2};
        System.out.println(candy(ratings));
    }

    public static void main(String[] args) {
        T00135 solution = new T00135();
        solution.run();
    }
}
