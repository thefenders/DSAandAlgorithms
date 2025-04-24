/*
 * 303. Range Sum Query - Immutable

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */

public class RangeSumQueryInmutable {
    private int[] prefixSum;

    public RangeSumQueryInmutable(int nums[]) {
        int n = nums.length;
        prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1}; // ejemplo de LeetCode
        RangeSumQueryInmutable obj = new RangeSumQueryInmutable(nums);

        // Pruebas
        System.out.println("sumRange(0, 2): " + obj.sumRange(0, 2)); // Esperado: 1
        System.out.println("sumRange(2, 5): " + obj.sumRange(2, 5)); // Esperado: -1
        System.out.println("sumRange(0, 5): " + obj.sumRange(0, 5)); // Esperado: -3
    }
}