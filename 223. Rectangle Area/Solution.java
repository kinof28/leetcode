public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // set ax1 to the bigger and ax2 to the smaller
        int temp1 = Math.max(ax1, ax2), temp2 = Math.min(ax1, ax2);
        ax1 = temp1;
        ax2 = temp2;
        // set ay1 to the bigger and ay2 to the smaller
        temp1 = Math.max(ay1, ay2);
        temp2 = Math.min(ay1, ay2);
        ay1 = temp1;
        ay2 = temp2;
        // set bx1 to the bigger and bx2 to the smaller
        temp1 = Math.max(bx1, bx2);
        temp2 = Math.min(bx1, bx2);
        bx1 = temp1;
        bx2 = temp2;
        // set by1 to the bigger and by2 to the smaller
        temp1 = Math.max(by1, by2);
        temp2 = Math.min(by1, by2);
        by1 = temp1;
        by2 = temp2;
        int rectangle1 = (ax1 - ax2) * (ay1 - ay2), rectangle2 = (bx1 - bx2) * (by1 - by2);
        int sum = rectangle1 + rectangle2;
        if (bx1 <= ax1 && bx1 >= ax2 && bx2 <= ax1 && bx2 >= ax2 && by1 <= ay1 && by1 >= ay2 && by2 <= ay1 && by2 >= ay2 ) {
            // case of second rectangle inside the first one
            sum=sum-rectangle2;
        }else if()
        return sum;
    }
}
