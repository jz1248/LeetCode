package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00026 extends Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int pHead = 1;
        int pWrite = 0;
        while (pHead < length) {
            while (pHead < length && nums[pHead] == nums[pWrite]) {
                pHead += 1;
            }
            if (pHead >= length) break;
            nums[++pWrite] = nums[pHead++];
        }
        return pWrite + 1;
    }

    @Override
    public void run() {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
