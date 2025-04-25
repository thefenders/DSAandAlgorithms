/*
 * Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

public class ContainerWithMostWater {
    private static int maxArea(int[] nums) {
        int maxArea = 0;
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int base = right - left;
            int height = Math.min(nums[left], nums[right]);
            int area = base * height;
            maxArea = Math.max(area, maxArea);

            if(nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //Este es el main
       int[] nums = {1,8,6,2,5,4,8,3,7};
       System.out.println("resultado: " + maxArea(nums));
    }
}
