package MonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

public class LC_84_LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;

        for(int i = 0; i <= n; i ++){
            int cur = i == n ? 0 : heights[i];
            while(!stack.isEmpty() && cur < heights[stack.peek()]){
                int width = i - stack.peek();
                int height = heights[stack.pop()];
                int area = width * height;
                ans = Math.max(ans, area);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        LC_84_LargestRectangleInHistogram solution = new LC_84_LargestRectangleInHistogram();
        int ans = LC_84_LargestRectangleInHistogram.largestRectangleArea(heights);
        System.out.println(ans);
    }
}
