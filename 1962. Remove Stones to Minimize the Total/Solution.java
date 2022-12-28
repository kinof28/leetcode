import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = this.getQueueFromArray(piles);
        int val;
        for (int i = 0; i < k; i++) {
            val = pq.poll();
            val -= Math.floor(val / 2);
            pq.add(val);
        }
        int sum = 0;
        for (Integer i : pq) {
            sum -= i;
        }
        return sum;
    }

    public PriorityQueue<Integer> getQueueFromArray(int[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(array).forEach((element) -> {
            queue.add(-element);
        });
        return queue;
    }

}