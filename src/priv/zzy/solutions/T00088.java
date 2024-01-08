package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.Arrays;

public class T00088 extends Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int p = total - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            int value;
            if (nums1[p1] <= nums2[p2]) {
                value = nums2[p2--];
            } else {
                value = nums1[p1--];
            }
            nums1[p--] = value;
        }
        if (p1 < 0) {
            for (int i = p2; i >= 0; i--) {
                nums1[p--] = nums2[i];
            }
        } else {
            for (int i = p1; i >= 0; i--) {
                nums1[p--] = nums1[i];
            }
        }
    }

    @Override
    public void run() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1};
        merge(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
