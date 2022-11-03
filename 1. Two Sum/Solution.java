import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] list = { 3, 2, 4 };
        System.out.println(Arrays.toString(solution.twoSum2(list, 6)));
    }

    // this is the very first problem on leetcode and this is the naive and simple
    // solution
    // this solution has time complexity of O(n^2) and space complexity of O(1)
    public int[] twoSum2(int[] nums, int target) {
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

    // the second solution using a hashmap
    // time complexity is O(n) and space complexity of O(n)
    public int[] twoSum(int[] nums, int target) {
        // creation of a new hashmap cause access of values in hashmap is of complexity
        // of O(1)
        Map<Integer, Integer> map = new HashMap<>();
        // here is the returned result
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // go throw all elements in nums just once and check
            // if there is another number in nums which equals target-nums[i]
            if (map.containsKey(target - nums[i])) {
                // if so we return the result list
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            // else it's added to the map to be checked later
            map.put(nums[i], i);
        }
        // return null else
        return null;
        // simple and elegant answer
    }
}