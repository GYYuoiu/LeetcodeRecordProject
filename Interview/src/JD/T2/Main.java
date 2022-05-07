package JD.T2;

import JD.T2.Solution;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();

        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < 3; j ++){
                    edges[i][j] = sc.nextInt();
                }
            }
            int ans = s.function(n, m, edges);
            System.out.println(ans);
        }

    }
}
