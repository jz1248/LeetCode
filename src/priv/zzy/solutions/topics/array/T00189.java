package priv.zzy.solutions.topics.array;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00189 extends Solution {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        rotate1(nums, k);
    }

    public void rotate1(int[] nums, int k) {
        // 新建数组，for循环依次赋值
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = (i + k) % nums.length;
            result[idx] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public void rotate2(int[] nums, int k) {
        // 交换法
        int t;
        int n = nums.length;
        for (int i = 0; i < gcd(n, k); i++) {
            int idx = i;
            t = nums[idx];
            do {
                idx = (idx + k) % nums.length;
                int s = t;
                t = nums[idx];
                nums[idx] = s;
            } while (idx != i);
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void rotate3(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            int t = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end - i] = t;
        }
    }

    @Override
    public void run() {
        int[] ints;
        ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{-1, -100, 3, 99};
        rotate(ints, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        T00189 solution = new T00189();
        solution.run();
    }
}
