package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00238 extends Solution {

    public int[] productExceptSelf(int[] nums) {
        return method2(nums);
    }

    private static int[] method1(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];

        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        post[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * post[i];
        }
        return ans;
    }

    /**
     * 除ans外，空间复杂度为O(1)
     * <p>
     * 思路：利用ans数组作为pre，post数组的值动态计算
     *
     * @param nums
     * @return
     */
    private static int[] method2(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int post = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * post;
            post *= nums[i];
        }
        return ans;
    }

    @Override
    public void run() {
        int[] nums;
        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static void main(String[] args) {
        T00238 solution = new T00238();
        solution.run();
    }
}
