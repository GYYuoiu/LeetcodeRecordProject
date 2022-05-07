package pinduoduo.fight;

import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[][] Duoduo = new int[][]{{1,1}, {2,1}, {3,1}};
        int[][] Pipi = new int[][]{{1,1}, {2,2}};
        int ans = fight(Duoduo, Pipi);
        System.out.println(ans);
    }

    public static int fight(int[][] Duoduo, int[][] Pipi){
        int m = Duoduo.length, n = Pipi.length;
        Arrays.sort(Duoduo, (a, b) -> b[0] - a[0]);
        Arrays.sort(Pipi, (a, b) -> b[1] - a[1]);
        TreeSet<int[]>  duoOuts = new TreeSet<>((a, b) -> a[1] - b[1]);
        int idxOfDuoOut = 0;
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            int[] piOut = Pipi[i];
            while(idxOfDuoOut < m && Duoduo[idxOfDuoOut][0] >= piOut[1]){
                duoOuts.add(Duoduo[idxOfDuoOut ++]);
            }
            if(duoOuts.isEmpty())  return -1;
            int[] duoOut = duoOuts.ceiling(piOut);
            if(duoOut == null){
                duoOuts.pollFirst();
            }else{
                duoOuts.remove(duoOut);
                cnt ++;
            }
        }
        return cnt;
    }
}
