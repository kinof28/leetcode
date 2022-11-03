import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] list = { 3, 2, 4 };
        System.out.println(Arrays.toString(solution.twoSum(list, 6)));
    }

    // this is the very first problem on leetcode and this is the naive and simple
    // solution
    // this solution has time complexity of O(n^2) and space complexity of O(1)
    public int[] twoSum(int[] nums, int target) {
        // we declare an array of two integers which will store indexes
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            // we store the first index in every loop
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                // the second index
                result[1] = j;
                // here we return the result if the condition is fulfilled
                if (nums[result[0]] + nums[result[1]] == target)
                    return result;
            }
        }
        // return null in case we didn't find a solution
        return null;
    }
}