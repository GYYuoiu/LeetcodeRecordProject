package Task1;

import java.util.Arrays;

public class Solution {
    public void findDiameter(int len, long[] lamps){
        int n = lamps.length;
        Arrays.sort(lamps);
        long gap = 0;

        for(int i = 1; i < n; i ++){
            gap = Math.max(gap, lamps[i] - lamps[i-1]);
        }
        gap = Math.max(gap, (lamps[0] - 0) * 2);
        gap = Math.max(gap, (len - lamps[n-1]) * 2);

        System.out.println(String.format("%.2f", gap/2.0));
    }
}
