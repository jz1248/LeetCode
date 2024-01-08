package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00080 extends Solution {
    public int removeDuplicates(int[] nums) {
        final int dupLimit = 2;
        int length = nums.length;
        int pHead = 1;
        int pWrite = 0;
        while (pHead < length) {
            int dupCount = 1;
            // 找到下一个不相同的值
            while (pHead < length && nums[pHead] == nums[pWrite]) {
                pHead += 1;
                dupCount += 1;
            }
            if (pHead >= length) {
                // 快指针到头了，处理最后一个值
                int num = nums[pWrite];
                for (int i = 1; i < Math.min(dupCount, dupLimit); i++) {
                    nums[++pWrite] = num;
                }
                break;
            } else {
                int num = nums[pWrite];
                for (int i = 1; i < Math.min(dupCount, dupLimit); i++) {
                    nums[++pWrite] = num;
                }
                nums[++pWrite] = nums[pHead++];
            }
        }
        return pWrite + 1;
    }

    @Override
    public void run() {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
