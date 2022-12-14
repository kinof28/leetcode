class Solution {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[dp.length - 1];
    }

}