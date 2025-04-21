import java.util.HashMap;
import java.util.Map;

class CountingFrecuencies {

    private static void cuntingFrecuencies(int[] arr) {
        HashMap<Integer, Integer> frecuencyMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(frecuencyMap.containsKey(arr[i])) {
                //If exits in the map, increment the counter
                frecuencyMap.put(arr[i], frecuencyMap.get(arr[i]) + 1);
            } else {
                //if not, add to the frecuencyMap
                frecuencyMap.put(arr[i], 1);
            }
        }

        //Travers the frecuencyMap
        for(Map.Entry<Integer,Integer> entry: frecuencyMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String args[]) 
    {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        cuntingFrecuencies(arr);
    }
}