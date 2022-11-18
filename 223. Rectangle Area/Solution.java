public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rectangle1 = (ax2 - ax1) * (ay2 - ay1), rectangle2 = (bx2 - bx1) * (by2 - by1);
        int overlapped = Math.max((Math.min(ax2, bx2) - Math.max(ax1, bx1)), 0)
                * Math.max((Math.min(ay2, by2) - Math.max(ay1, by1)), 0);
        return rectangle1 + rectangle2 - overlapped;
    }
}
