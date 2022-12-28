import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStoneSum(new int[] { 7481, 7973, 3635, 5320, 2721, 4394, 7861 }, 10));
    }

    public int minStoneSum(int[] piles, int k) {
        Arrays.sort(piles);
        System.out.println("array: " + Arrays.toString(piles));
        int index = piles.length;
        int min = index;
        for (int i = 0; i < k; i++) {
            index = this.getMaxIndex(piles, min);
            if (min > index)
                min = index;
            piles[index] -= Math.floor(piles[index] / 2);
            System.out.println("array: " + Arrays.toString(piles));
        }

        int sum = Arrays.stream(piles).sum();
        return sum;
    }

    public int getMaxIndex(int[] array, int currentMax) {
        int max = array.length - 1;
        int maxValue = array[max];
        if (currentMax == 0)
            currentMax++;
        for (int i = max; i >= currentMax - 1; i--) {
            if (maxValue < array[i]) {
                maxValue = array[i];
                max = i;
            }
        }
        return max;
    }

}