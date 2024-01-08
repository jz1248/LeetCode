package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00189 extends Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        int t;
        for (int i = 0; i < (r - l + 1) / 2; i++) {
            t = nums[l + i];
            nums[l + i] = nums[r - i];
            nums[r - i] = t;
        }
    }

    @Override
    public void run() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
