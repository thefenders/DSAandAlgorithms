/*
Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.

Example 1:

Input: arr = [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: arr = [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
*/

public class FindMaxSumSubArray {
    private static int findMaxSumSubArray(int[] nums, int k) {
        int maxSum = 0;
        int left = 0;
        int right = 0;
        int windowSum = 0;

        while(right < nums.length) {
            windowSum += nums[right];

            if(right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
       
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(new int[] { 2, 3, 4, 1, 5 }, 2));
    }
}
