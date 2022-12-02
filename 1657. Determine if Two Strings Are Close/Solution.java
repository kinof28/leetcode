import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] firstLettersFrequency = new int[26];
        int[] secondLettersFrequency = new int[26];

        for (char c : word1.toCharArray()) {
            firstLettersFrequency[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            secondLettersFrequency[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((firstLettersFrequency[i] != 0 && secondLettersFrequency[i] == 0)
                    || (firstLettersFrequency[i] == 0 && secondLettersFrequency[i] != 0))
                return false;
        }
        Arrays.sort(firstLettersFrequency);
        Arrays.sort(secondLettersFrequency);
        return Arrays.compare(firstLettersFrequency, secondLettersFrequency) == 0;

    }
}