package LC_6029_maximumBobPoints;

class Solution{
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 3;
        int[] alice = new int[]{0,0,1,0,0,0,0,0,0,0,0,2};
        int[] ans = s.maximumBobPoints(num, alice);
    }
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        // dp[i][j] 表示 用j支箭 在i区域及其之前区域 中 能拿下的最大分数
        int[][] dp = new int[n][numArrows + 1];
        // path[i][j] 表示 用j支箭 在i区域 赢下比分
        int[][] path = new int[n][numArrows + 1];
        // 动态规划，记录路径
        for(int i = 1; i < n; i ++){
            for(int j = 0; j <= numArrows; j ++){
                // 放弃本环
                int a = dp[i-1][j];
                // 赢下本环
                int b = j >= aliceArrows[i] + 1 ? dp[i-1][j - aliceArrows[i] - 1] + i : 0;
                path[i][j] = b > a ? 1 : 0;
                dp[i][j] = Math.max(a, b);
            }
        }
        printArray(dp);
        printArray(path);
        // 路径还原
        int[] ans = new int[n];
        int cnt = numArrows;
        for(int i = 11; i >= 0; i --){
            if(path[i][cnt] == 1 && cnt >= aliceArrows[i] + 1){
                ans[i] = aliceArrows[i] + 1;
                cnt -= ans[i];
            }else{
                ans[i] = 0;
            }
        }
        // 剩余的箭
        if(cnt > 0)  ans[n-1] += cnt;
        return ans;
    }

    public void printArray(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
