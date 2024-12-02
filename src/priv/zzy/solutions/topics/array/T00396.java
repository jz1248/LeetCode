package priv.zzy.solutions.topics.array;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00396 extends Solution {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int f = calculate(nums);
        int sum = Arrays.stream(nums).sum();
        int result = f;
        for (int i = 1; i < n; i++) {
            f += sum - n * nums[n - i];
            result = Math.max(result, f);
        }
        return result;
    }

    private int calculate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * i;
        }
        return sum;
    }

    @Override
    public void run() {
        int[] ints;
        ints = new int[]{4, 3, 2, 6};
        System.out.println(maxRotateFunction(ints));
        ints = new int[]{100};
        System.out.println(maxRotateFunction(ints));
        ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(maxRotateFunction(ints));
    }

    public static void main(String[] args) {
        T00396 solution = new T00396();
        solution.run();
    }
}
