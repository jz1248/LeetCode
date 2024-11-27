package priv.zzy.solutions.topics.array;

import priv.zzy.Solution;

public class T00665 extends Solution {

    public boolean checkPossibility(int[] nums) {
        boolean hasAltered = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (hasAltered) {
                    return false;
                } else {
                    if (i + 2 >= nums.length) {
                        return true;
                    }
                    if (i == 0) {
                        hasAltered = true;
                        continue;
                    }
                    if ((nums[i + 1] >= nums[i - 1]) || nums[i] <= nums[i + 2]) {
                        hasAltered = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println(checkPossibility(new int[]{1, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(!checkPossibility(new int[]{4, 2, 1}));
        System.out.println(!checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(!checkPossibility(new int[]{3, 4, 2, 1}));
    }

    public static void main(String[] args) {
        T00665 solution = new T00665();
        solution.run();
    }
}
