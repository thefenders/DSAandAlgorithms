package BinarySearch;

public class MinimumNumberOfDays {
    
    private static int minimumNumberOfDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = (int) 1e9;
        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (isFeasible(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isFeasible(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for(int bloom : bloomDay) {
            if(bloom <= day) {
                flowers++; //Flor disponible

                if(flowers == k) {
                    bouquets++; //Hicimos un ramo
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int minDay = minimumNumberOfDays(bloomDay, m, k);
        System.out.println("Minimum days: " + minDay); // Output esperado: 3
    }
}
