/*
 * Dificultad: Medium
Plataforma: LeetCode 1870
Enunciado:

You are given a floating-point number hour, representing the total time you have to travel.
You are also given an array dist of integers where dist[i] is the distance of the i-th train ride.
Each train must be taken in order and each except the last must depart at an integer hour (you may need to wait if you arrive early).
Return the minimum integer speed needed such that you can reach your destination within hour time. If it is impossible, return -1.

📌 Ejemplo:

text
Copiar
Input: dist = [1, 3, 2], hour = 6
Output: 1

Input: dist = [1, 3, 2], hour = 2.7
Output: 3
 */

package BinarySearch;


public class MinimumSpeed {

    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReach(dist, hour, mid)) {
                result = mid;
                right = mid - 1; // buscamos una velocidad más pequeña
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private static boolean canReach(int[] dist, double hour, int speed) {
        double time = 0.0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[n - 1] / speed;
        return time <= hour;
    }

    public static void main(String[] args) {
        int[] n = {1, 3, 2};
        double hour = 2.7;
        System.out.println(minSpeedOnTime(n, hour));
    }
}
