public class Solution {

    public int guessNumber(int n) {
        long min = 0, max = n;
        long guessedNumber = (min + max) / 2 + (min + max) % 2;
        int result = guess((int) guessedNumber);
        while (result != 0) {
            if (result == 1) {
                min = guessedNumber;
            } else {
                max = guessedNumber;
            }
            guessedNumber = (min + max) / 2 + (min + max) % 2;
            result = guess((int) guessedNumber);
        }
        return (int) guessedNumber;
    }

    public int guess(int num) {
        int param = 1702766719;
        if (num < param)
            return 1;
        else if (num > param)
            return -1;
        else
            return 0;
    }
}
