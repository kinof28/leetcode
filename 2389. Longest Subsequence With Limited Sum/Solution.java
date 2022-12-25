import java.util.Arrays;

class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < result.length; i++) {
            result[i] = maxLength(nums, queries[i]);
        }
        return result;
    }

    public int maxLength(int[] nums, int query) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum <= query) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}