class ValidaAnagram {
    private static boolean isValidAnagram(String s1, String s2) {
       if(s1.length() != s2.length()) return false;

       int[] letterCount = new int[26];

       for(int i = 0; i < s1.length(); i++) {
        letterCount[s1.charAt(i) - 'a']++;
        letterCount[s2.charAt(i) - 'a']--;
       }

       for(int count : letterCount) {
        if(count != 0) {
            return false;
        }
       }
       return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        boolean result = isValidAnagram(s1, s2);
        System.out.println(result);
    }
}
