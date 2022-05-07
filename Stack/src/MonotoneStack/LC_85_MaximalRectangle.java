package MonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

public class LC_85_MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'},
                                        {'1', '0', '1', '1', '1'},
                                        {'1', '1', '1', '1', '1'},
                                        {'1', '0', '0', '1', '0'}};
        LC_85_MaximalRectangle solution = new LC_85_MaximalRectangle();
        int ans = solution.maximalRectangle(matrix);
        System.out.println(ans);
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 用 up[][] 数组记录每个位置上（包括自己）边连续1的个数
        int[][] up = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i == 0)  up[i][j] = matrix[i][j] == '0' ? 0 : 1;
                else{
                    up[i][j] = matrix[i][j] == '0' ? 0 : up[i-1][j] + 1;
                }
            }
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                System.out.print(up[i][j] + " ");
            }
            System.out.println();
        }

        // up[][] 的每一行都是一个 柱状图中最大矩形问题
        // 找到每个柱子前后比它小的最近的柱子，用递增栈
        int ans = 0;
        for(int i = 0; i < m; i ++){
            int[] heights = up[i];
            Deque<Integer> stack = new LinkedList<>();
            for(int j = 0; j <= n; j ++){
                int curH = j == n ? 0 : heights[j];
                while(!stack.isEmpty() && curH < heights[stack.peek()]){
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    int area = height * width;
                    ans = Math.max(ans, area);
                }
                stack.push(j);
            }
        }
        return ans;
    }
}
