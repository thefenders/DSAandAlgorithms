package BinarySearch;

public class FloorSqrt {
    private static int floorSqrt(int n) {
        int low = 1;
        int high = n;
        int res = 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid * mid <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(floorSqrt(n));
    }
}
