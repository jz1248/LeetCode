package priv.zzy.solutions.topics.array;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00453 extends Solution {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        Arrays.sort(nums);

        int p = 1;
        int min = nums[0];
        while (p < nums.length && nums[p] == nums[p - 1]) p++;
        int sum = 0;
        for (int i = p; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }


    @Override
    public void run() {
        System.out.println(minMoves(new int[]{1, 2, 3}) == 3);
        System.out.println(minMoves(new int[]{1, 1, 1}) == 0);
        System.out.println(minMoves(new int[]{1, 1, 10}) == 9);
        System.out.println(minMoves(new int[]{1, 1, 2, 2, 10}) == 11);
    }

    public static void main(String[] args) {
        T00453 solution = new T00453();
        solution.run();
    }
}
