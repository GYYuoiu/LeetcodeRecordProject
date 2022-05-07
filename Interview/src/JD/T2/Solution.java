package JD.T2;

public class Solution {
    public int function(int n, int m, int[][] edges){
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int[] edge : edges){
            left = Math.min(left, edge[2]);
            right = Math.max(right, edge[2]);
        }

        while(left < right){
            int mid = left + (right - left) / 2 + 1;
            if(check(n, edges, mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean check(int n, int[][] edges, int w){
        UF uf = new UF(n);
        for(int[] edge : edges){
            if(edge[2] < w)  continue;
            uf.union(edge[0]-1, edge[1]-1);
        }
        return uf.count() == 1;
    }
}
