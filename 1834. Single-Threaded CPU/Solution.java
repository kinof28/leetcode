import java.util.PriorityQueue;

class Solution {

    public int[] getOrder(int[][] tasks) {
        int[] order = new int[tasks.length];
        PriorityQueue<Process> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Process> firstPriorityQueue = new PriorityQueue<>();

        for (int i = 0; i < tasks.length; i++) {
            firstPriorityQueue.add(new Process(i, tasks[i][0]));
        }
        int currentInstance = firstPriorityQueue.peek().getTime();
        for (int i = 0; i < order.length;) {
            while (!firstPriorityQueue.isEmpty() && currentInstance >= firstPriorityQueue.peek().getTime()) {
                Process process = firstPriorityQueue.poll();
                priorityQueue.add(new Process(process.getIndex(), tasks[process.getIndex()][1]));
            }
            if (!priorityQueue.isEmpty()) {
                Process process = priorityQueue.poll();
                order[i] = process.getIndex();
                i++;
                currentInstance += process.getTime();
            } else {
                currentInstance = firstPriorityQueue.peek().getTime();
            }
        }
        return order;
    }
}

class Process implements Comparable<Process> {
    private int index;
    private int time;

    public Process(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Process arg0) {
        if (Integer.compare(this.time, arg0.getTime()) == 0)
            return Integer.compare(this.index, arg0.getIndex());
        else
            return Integer.compare(this.time, arg0.getTime());
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }

}