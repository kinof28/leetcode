class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, reversedSum = 0, length = nums.length;
        int[] sums = new int[length], reversedSums = new int[length];
        for (int i = 0; i < length; i++) {
            sums[i] = sum;
            reversedSums[i] = reversedSum;
            sum += nums[i];
            reversedSum += nums[length - i - 1];
        }
        for (int i = 0; i < length; i++) {
            if (sums[i] == reversedSums[length - i - 1])
                return i;
        }
        return -1;
    }
}
