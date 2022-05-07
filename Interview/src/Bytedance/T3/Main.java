package Bytedance.T3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int t = sc.nextInt();
        int[] ans = new int[t];
        sc.nextLine();
        for(int k = 0; k < t; k ++){
            int buckets = sc.nextInt();
            sc.nextLine();
            List<Integer>[] arr = new List[buckets];
            for(int i = 0; i < buckets; i ++){
                arr[i] = new ArrayList<>();
                int len = sc.nextInt();
                for(int j = 0; j < len; j ++){
                    arr[i].add(sc.nextInt());
                }
                sc.nextLine();
            }
            if(s.method(arr)) ans[k] = 1;
        }
        for(int n : ans) System.out.println(n);
    }
}
