class Solution {
    long[] results;

    public int numTilings(int n) {
        results = new long[n + 1];
        return (int) numTilingsRec(n);
    }

    public long numTilingsRec(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (n <= 2)
            return n;
        if (n == 3)
            return 5;
        if (results[n] != 0)
            return (int) (results[n] % (Math.pow(10, 9) + 7));
        else {
            results[n] = (2 * numTilingsRec(n - 1)) + numTilingsRec(n - 3);
            return (int) (results[n] % (Math.pow(10, 9) + 7));
        }
    }
}