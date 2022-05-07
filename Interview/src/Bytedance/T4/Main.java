package Bytedance.T4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        String temp = sc.nextLine();
        String[] cards = temp.split(" ");
        int ans = s.method(cards);
        System.out.println(ans);
    }
}
