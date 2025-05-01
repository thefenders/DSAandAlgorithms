/*
 * Dado un arreglo weights donde cada elemento representa el peso de un paquete, y un número days que representa en cuántos días debes entregar todos los paquetes en orden, encuentra la mínima capacidad del barco que permita entregar todos los paquetes en days días o menos.

🧩 Reglas:
Cada día puedes cargar varios paquetes, en orden, hasta que la suma de sus pesos llegue al límite de capacidad.

No puedes reordenar los paquetes.

Necesitas mínimos días <= D.

🧪 Ejemplo:
text
Copiar
Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5  
Output: 15

Explicación:
Una capacidad mínima de 15 te permite distribuir así:
- Día 1: 1 + 2 + 3 + 4 + 5 = 15  
- Día 2: 6 + 7 = 13  
- Día 3: 8  
- Día 4: 9  
- Día 5: 10
 */

package BinarySearch;

import java.util.Arrays;

public class CapacityShip {
    
    private static int capacityOfShip(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isFeasible(weights, days, mid)) {
                result = mid; //Save because it could be the minimum
                right = mid - 1; //looking for a minor capacity
            } else {
                left = mid + 1; //I need more capacity
            }
        }
        return result;
    }

    private static boolean isFeasible(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int requiredDays = 1;

        for(int weight : weights) {
            if(currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return requiredDays <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int minCapacity = capacityOfShip(weights, days);
        System.out.println("Minimum capacity: " + minCapacity); // Output esperado: 3
    }
}
