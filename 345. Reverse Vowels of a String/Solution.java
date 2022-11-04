import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        vowels.add('i');
        vowels.add('A');
        vowels.add('E');
        vowels.add('O');
        vowels.add('U');
        vowels.add('I');
        String wordVowels = "";
        char[] result = new char[s.length()];
        char specialChar = '*';
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                wordVowels = s.charAt(i) + wordVowels;
                result[i] = specialChar;
            } else {
                result[i] = s.charAt(i);
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == specialChar) {
                result[i] = wordVowels.charAt(0);
                wordVowels = wordVowels.substring(1);
            }
        }
        return String.valueOf(result);
    }
}
