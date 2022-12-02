import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2, 4, 5, 6 }));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = nums1.length > nums2.length ? nums1 : nums2;
        nums2 = nums1.length > nums2.length ? nums2 : nums1;
        nums1 = temp;
        int firstIndex=nums2.length/2+nums2.length%2;
        int secondIndex=(nums1.length+nums2.length)-firstIndex;
        int num1=nums1[secondIndex],num2=nums2[firstIndex];
        while(true){
            if(nums2[firstIndex])
        }
        return 0;
    }
}