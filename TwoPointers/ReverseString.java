import java.util.Arrays;

public class ReverseString {
    private static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s); // Llamamos la función
        System.out.println("resultado: " + Arrays.toString(s)); // Imprimimos bien
    }
}
