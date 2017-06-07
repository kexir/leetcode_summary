public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int area = 0;
        while(left < right) {
            if(leftHeight < rightHeight) {
                left ++;
                if(leftHeight > height[left]) {
                    area += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];
                }
            } else {
                right --;
                if(rightHeight > height[right]) {
                    area += (rightHeight- height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return area;
    }
}