package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00027 extends Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int pHead = 0;
        int pWrite = 0;
        while (pHead < length) {
            while (pHead < length && nums[pHead] == val) {
                pHead += 1;
            }
            if (pHead >= length) break;
            nums[pWrite++] = nums[pHead++];
        }
        return pWrite;
    }

    @Override
    public void run() {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
