class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int sum = 0, maxValue = Integer.MIN_VALUE, maxIndex = temperatures.length - 1;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (temperatures[i] >= maxValue) {
                maxValue = temperatures[i];
                maxIndex = i;
            }
            sum = 0;
            for (int j = i + 1; j <= maxIndex; j++) {
                sum++;
                if (temperatures[j] > temperatures[i]) {
                    result[i] = sum;
                    break;
                } else if (temperatures[j] == temperatures[i]) {
                    result[i] = sum != 0 ? result[j] + sum : 0;
                    break;
                }
            }
        }
        return result;
    }
}