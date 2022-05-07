/**
 * 描述： Todo
 */

public class LC_1375_numTimesAllBlue {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.numTimesAllBlue(new int[]{3,2,4,1,5});
        System.out.println(ans);
    }

    static class Solution {
        public int numTimesAllBlue(int[] flips) {
            int n = flips.length;
            int cnt = 0;
            BIT bit = new BIT(n);
            for(int i = 0; i < n; i ++) {
                bit.update(flips[i], 1);
                if(bit.query(flips[i]) == i + 1)  cnt ++;
            }
            return cnt;
        }
    }
    static class BIT{
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return  x & (-x);
        }

        public void update(int x, int d) {
            while(x <= n) {
                tree[x] += d;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while(x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
