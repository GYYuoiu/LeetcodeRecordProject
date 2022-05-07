package huawei.T2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int method(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0])  return b[1] - a[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < n; i ++){
            int[] curTask = arr[i];
            if(q.size() < curTask[0]){
                q.offer(curTask[1]);
            }else if(q.size() == curTask[0]){
                if(curTask[1] > q.peek()){
                    q.poll();
                    q.offer(curTask[1]);
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty())  ans += q.poll();
        return ans;
    }
}
