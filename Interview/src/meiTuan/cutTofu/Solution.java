package meiTuan.cutTofu;
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Solution {
    public int[] maxTofu(int a, int m ,int[][] cuts){
        // a表示豆腐初始边长 tofu[]表示目前豆腐的xyz坐标
        int[][] tofu = new int[3][a + 1];
        int[] maxLen = new int[3];
        Arrays.fill(maxLen, a);
        // m表示切了几刀，cuts[][] m行3列 表示具体怎么切的，
        // cuts第一个值表示切第几刀
        // cuts第二个值表示 0-x轴 1-y轴 2-z轴 切的长度
        // 例如 cuts[1][2] = 2 表示第一刀在y轴切了2个单位
        int[] volumn = new int[m];
        for(int i = 0; i < m; i ++){
            int[] cut = cuts[i];
            for(int j = 0; j < 3; j ++){
                if(cut[j] != 0){
                    tofu[j][cut[j]] = 1;
                    int len = 1;
                    maxLen[j] = 1;
                    for(int k = 1; k <= a; k ++){
                        if(tofu[j][k] == 1){
                            maxLen[j] = Math.max(len, maxLen[j]);
                            len = 1;
                        }else{
                            len ++;
                        }
                    }
                    maxLen[j] = Math.max(len - 1, maxLen[j]);
                    break;
                }
            }
            volumn[i] = maxLen[0] * maxLen[1] * maxLen[2];
        }
        return volumn;

    }
}
