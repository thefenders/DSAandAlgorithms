import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            } 
            map.put(current, i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5}; 
        int target = 6; 
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}