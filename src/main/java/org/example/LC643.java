package org.example;

public class LC643 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int tmpSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            tmpSum = tmpSum - nums[i - k] + nums[i];

            if (maxSum < tmpSum) {
                maxSum = tmpSum;
            }
        }
        return (1.0 * maxSum) / k;
    }
}
