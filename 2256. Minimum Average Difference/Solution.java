class Solution {

    public static void main(String[] args) {

        System.out.println("index: " + (new Solution()).minimumAverageDifference(new int[] { 2, 5, 3, 9, 5, 3 }));
    }

    public int minimumAverageDifference(int[] nums) {
        int min = Integer.MAX_VALUE, index = 1, val, firstAvg, secondAvg;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i < sums.length; i++) {
            firstAvg = sums[i] / i;
            secondAvg = i != sums.length - 1 ? (sums[sums.length - 1] - sums[i]) / (sums.length - i - 1) : 0;
            val = Math.abs(firstAvg - secondAvg);
            System.out.println("index: " + i + " firstAvg: " + firstAvg + " secondAvg: " + secondAvg + " val: " + val);
            if (val < min) {
                min = val;
                index = i;
            }
        }
        System.out.println("min: " + min);
        return index - 1;
    }
}