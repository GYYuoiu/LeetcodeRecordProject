package meiTuan.cutTofu;
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String[] ch = str.split(" ");

            int[][] cuts = new int[m][3];

            for (int i = 0; i < m; i++) {
                int len = sc.nextInt();
                if (ch[i].equals("x")) {
                    cuts[i][0] = len;
                } else if (ch[i].equals("y")) {
                    cuts[i][1] = len;
                } else {
                    cuts[i][2] = len;
                }
            }
            for(int[] cut : cuts){
                for(int i = 0; i < 3; i ++){
                    System.out.print(cut[i] + " ");
                }
                System.out.println();
            }
            int[] volumn = s.maxTofu(a, m, cuts);
            for (int i = 0; i < m; i++) {
                System.out.println(volumn[i]);
            }
            return;
        }
    }
}
