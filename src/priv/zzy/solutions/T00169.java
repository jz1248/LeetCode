package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00169 extends Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            votes = num == ans ? votes + 1 : votes - 1;
            if (votes == 0) {
                ans = nums[i + 1];
            }
        }
        return ans;
    }

    @Override
    public void run() {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
