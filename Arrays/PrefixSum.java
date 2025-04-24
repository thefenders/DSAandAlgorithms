/*
 * Given an array arr[] of size n. Given q queries and in each query given i and j, Print the sum of array elements from index i to j.


Input : arr[] = {1, 2, 3, 4, 5}
        i = 1, j = 3
        i = 2, j = 4
Output :  9
         12         
Input : arr[] = {1, 2, 3, 4, 5}
        i = 0, j = 4 
        i = 1, j = 2 
Output : 15
          5
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PrefixSum {
    private static int prefixSum(int[] nums, int l, int r) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefix));
       
        if(l == 0) {
            System.out.println("prefix[r]: " + prefix[r]);
            return prefix[r];
        } else {
            System.out.println("prefix[r]: " + prefix[r] + " prefix[l-1]: " + prefix[l - 1]);
            return prefix[r] - prefix[l - 1];
        }
    }

     public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(prefixSum(nums, 1, 3)); // Esperado: 2+3+4 = 9
        System.out.println(prefixSum(nums, 2, 4)); // Esperado: 3+4+5 = 12
        System.out.println(prefixSum(nums, 0, 4)); // Esperado: 1+2+3+4+5 = 15
        System.out.println(prefixSum(nums, 1, 2)); // Esperado: 2+3 = 5
    }
}
