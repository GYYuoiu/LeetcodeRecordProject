package Task1;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int len = sc.nextInt();
            long[] lamps = new long[n];
            for(int i = 0; i < n; i ++){
                lamps[i] = sc.nextLong();
            }
            solution.findDiameter(len, lamps);
        }
    }
}
