package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00055 extends Solution {
    public boolean canJump(int[] nums) {
//        return v1(nums);
        return v2(nums);
    }

    public boolean v2(int[] nums) {
        int length = nums.length;
        if (nums[0] >= length - 1 || length == 1) {
            return true;
        }
        int maxDist = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxDist) return false;
            int dist = nums[i] + i;
            if (dist >= length - 1) {
                return true;
            } else if (dist > maxDist) {
                maxDist = dist;
            }
        }
        return false;
    }

    public boolean v1(int[] nums) {
        int length = nums.length;
        if (nums[0] >= length) {
            return true;
        }
        boolean[] flag = new boolean[length];
        flag[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = i + num; j > i; j--) {
                if (j >= length) continue;
                if (flag[j]) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[0];
    }

    @Override
    public void run() {
//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
//        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{1, 1, 1, 0}));
    }
}
