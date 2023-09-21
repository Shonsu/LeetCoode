package org.example.codewars;

public class LC4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int[] ints = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) {
                ints[i++] = nums1[j++];
            } else {
                ints[i++] = nums2[k++];
            }
        }
        while (j < nums1.length) {
            ints[i++] = nums1[j++];
        }
        while (k < nums2.length) {
            ints[i++] = nums2[k++];
        }

        int length = ints.length;
        if (length % 2 == 0) {
            return (double) (ints[(length / 2) - 1] + ints[(length / 2)]) / 2;
        }
        return (ints[length / 2]);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 6};
        int[] nums2 = new int[]{1, 3, 4, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
