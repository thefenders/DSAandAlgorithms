/*
 * Find first and last positions of an element in a sorted array
Given a sorted array arr[] with possibly some duplicates, the task is to find the first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array then return both the indices as -1.

Examples: 

Input : arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
Output : 2 5
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5


Input : arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125 ], x = 7
Output : 6 6
Explanation: First and last occurrence of 7 is at index 6


Input: arr[] = [1, 2, 3], x = 4
Output: -1 -1
Explanation: No occurrence of 4 in the array, so, output is [-1, -1]
 */

package BinarySearch;

import java.util.Arrays;

public class FindFirstLast {
    
    private static int findFirst(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int first = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == x) {
                first = mid;
                right = mid - 1;
            }
            else if(x < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    private static int findLast(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int last = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == x) {
                last = mid;
                left = mid + 1;
            } else if(nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return last;
    }

    private static int[] findFirstLast(int[] nums, int x) {
        int[] result = new int[2];

        int first = findFirst(nums, x);
        int last = findLast(nums, x);

        result[0] = first;
        result[1] = last;

        return result;
    }

    public static void main(String[] args) {
        int[] n = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        System.out.println(Arrays.toString(findFirstLast(n, x)));
    }
}