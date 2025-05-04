/*
 * 2461. Maximum Sum of Distinct Subarrays With Length K
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
 */

import java.util.HashSet;
import java.util.Set;

public class MaxSumOfDisSubarray {
    private static int maximumSumOfDistincSubArray(int[] nums, int k) {
       int left =  0;
       int right = 0;
       int maxSum = 0;
       int currentSum = 0;
       Set<Integer> window = new HashSet<>();

       while(right < nums.length) {
        while(window.contains(nums[right])) {
            //Mientras encontremos un numero repetido, reducimos la ventana desde left
            window.remove(nums[left]);
            currentSum -= nums[left];
            left++;
        }
        //Si ya no hay repetidos, agregamos el siguiente elemento a la derecha, actualizamos currectSum y aumentamos el puntero right
        window.add(nums[right]);
        currentSum += nums[right];
        right++;

        //Validar si estamos dentro de la condición de k
        if(right - left == k) {
            //Si es de tamaño k, comparamos las sumas
            maxSum = Math.max(maxSum, currentSum);
            //mover left para explorar las siguientes ventanas. 
            currentSum -= nums[left];
            window.remove(nums[left]);
            left++;
        }
       }
       return maxSum;
    }

     public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9}; 
        int k = 3; 
        System.out.println(maximumSumOfDistincSubArray(nums, k));
    }
}
