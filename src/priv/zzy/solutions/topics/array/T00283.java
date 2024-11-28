package priv.zzy.solutions.topics.array;

import priv.zzy.Solution;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/description/
 */
public class T00283 extends Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int pFast = 0;
        int pSlow = 0;
        while (pFast < nums.length) {
            if (nums[pFast] != 0) {
                int t = nums[pSlow];
                nums[pSlow] = nums[pFast];
                nums[pFast] = t;
                ++pSlow;
            }
            ++pFast;
        }
    }

    @Override
    public void run() {
        int[] t;
        t = new int[]{0, 1, 0, 3, 12};
        moveZeroes(t);
        System.out.println(Arrays.toString(t));

        t = new int[]{0};
        moveZeroes(t);
        System.out.println(Arrays.toString(t));

        t = new int[]{1, 0, 3, 0, 0, 0, 1, 2, 3, 4, 3, 0, 0};
        moveZeroes(t);
        System.out.println(Arrays.toString(t));

        t = new int[]{2, 0, 4, 0, 0, 1, 2, 3, 4, 3};
        moveZeroes(t);
        System.out.println(Arrays.toString(t));
    }

    public static void main(String[] args) {
        T00283 solution = new T00283();
        solution.run();
    }
}
