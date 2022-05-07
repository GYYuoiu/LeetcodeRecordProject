package huawei.T2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int N = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < 2; j ++){
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int ans = s.method(arr);
        System.out.println(ans);
    }
}
