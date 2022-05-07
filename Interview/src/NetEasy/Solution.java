package NetEasy;
public class Solution{
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.markChar("abdbb");
    }
    public int markChar(String str){
        int n = str.length();
        if(n < 2)  return 0;
        char[] ss = str.toCharArray();
        // dp[i]表示标记 前i个字符构成的字串的 最后两个字母， 可获得的最大分数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        int ans = 0;
        for(int i = 2; i <= n; i ++){
            if(ss[i-1] == ss[i-2] + 1 || ss[i-1] == ss[i-2] - 1 || ss[i-1] == ss[i-2]){
                dp[i] = dp[i-2] + ss[i-1] - 'a' + 1 + ss[i-2] - 'a' + 1;
            }else{
                dp[i] = dp[i-1];
            }
            ans = Math.max(dp[i], ans);
        }
        for(int i : dp) System.out.print(i);
        return ans;
    }
}

