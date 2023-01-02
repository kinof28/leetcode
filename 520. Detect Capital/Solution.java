class Solution {
    public boolean detectCapitalUse(String word) {
        // return word.matches("(^[A-Z]+$)|(^[a-z]+$)|(^[A-Z]([a-z]+)$)");
        if (word.length() < 2)
            return true;
        boolean upperFlag = false;
        boolean lowerFlag = false;
        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z')
            lowerFlag = true;
        for (int i = 1; i < word.length(); i++) {
            if ((lowerFlag && (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
                    || (upperFlag && (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')))
                return false;
            else {
                if ((word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
                    upperFlag = true;
                else
                    lowerFlag = true;
            }
        }
        return true;
    }
}