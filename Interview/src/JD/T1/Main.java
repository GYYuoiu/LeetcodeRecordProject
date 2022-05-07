package JD.T1;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();

        while(sc.hasNextInt()){
            int tankNum = sc.nextInt();
            int blood = sc.nextInt();
            int attack = sc.nextInt();
            int enemyNum = sc.nextInt();
            int ans = s.fight(tankNum, blood, attack, enemyNum);
            System.out.println(ans);
        }

    }
}