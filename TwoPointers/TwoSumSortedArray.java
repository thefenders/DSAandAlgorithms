/*
 * 167. Two Sum II - Input Array Is Sorted
 
 Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 
 Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 
 The tests are generated such that there is exactly one solution. You may not use the same element twice.
 
 Your solution must use only constant extra space.
 
  
 
 Example 1:
 
 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
   

import java.util.Arrays;

public class TwoSumSortedArray {

    private static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[] {left + 1, right + 1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0};
    }
    public static void main(String[] args) {
        //Este es el main
       int[] nums = {2,7,11,15};
       int target = 9;
       System.out.println("resultado: " + Arrays.toString(twoSum(nums, target)));
    }
}
