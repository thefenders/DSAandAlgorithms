/*
 * 15. 3Sum
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //Paso 1: Ordenar el array
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            //Evitar duplicados
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if(total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
               
                left++;
                right--;

                //Saltar duplicados
                while(right < left && nums[left] == nums[left - 1]) left++;
                while(right < left && nums[right] == nums[right + 1]) right--;
                } else if(total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = threeSum(nums);
        for (List<Integer> triplet : output) {
            System.out.println(triplet);
        }
    }
}
