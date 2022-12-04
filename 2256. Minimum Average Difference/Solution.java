class Solution {

    public int minimumAverageDifference(int[] nums) {
        int index = 0;
        long min = Integer.MAX_VALUE, val, firstAvg, secondAvg;
        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i < sums.length; i++) {
            firstAvg = sums[i] / i;
            secondAvg = i != sums.length - 1
                    ? (sums[sums.length - 1] - sums[i]) / (sums.length - i - 1)
                    : 0;
            val = Math.abs(firstAvg - secondAvg);
            if (val < min) {
                min = val;
                index = i - 1;
            }
        }
        return index;
    }
}