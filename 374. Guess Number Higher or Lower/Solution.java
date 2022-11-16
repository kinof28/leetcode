public class Solution {

    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        int guessedNumber = (n / 2) + n % 2;
        int result = guess(guessedNumber);
        while (result != 0) {
            if (result == 1) {
                if (((n - guessedNumber) / 2) == 0)
                    guessedNumber++;
                else
                    guessedNumber = guessedNumber + ((n - guessedNumber) / 2);
            } else {
                if (((n - guessedNumber) / 2) == 0)
                    guessedNumber--;
                else
                    guessedNumber = guessedNumber - ((n - guessedNumber) / 2);
            }
            result = guess(guessedNumber);
        }
        return guessedNumber;
    }

    /**
     * Forward declaration of guess API.
     * 
     * @param num your guess
     * @return -1 if num is higher than the picked number
     *         1 if num is lower than the picked number
     *         otherwise return 0
     *         int guess(int num);
     */
    public int guess(int num) {
        return 0;
    }
}
