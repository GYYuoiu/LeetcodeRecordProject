package Bytedance.T3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 4 3 1 2 5
    // 9 6 7 8
    Map<Integer, int[]> map;
    List<Integer>[] arr;
    public boolean method(List<Integer>[] arr){
        this.arr = arr;
        map = new HashMap<>();
        int m = arr.length;
        int max = 0;
        for(int i = 0; i < m; i ++){
            List<Integer> list = arr[i];
            int n = list.size();
            for(int j = 0; j < n; j ++){
                if(map.containsKey(list.get(j)))  return false;
                map.put(list.get(j), new int[]{i, j});
                max = Math.max(list.get(j), max);
            }
        }
        for(int i = 1; i <= max; i ++){
            if(!check(i))  return false;
        }
        return true;
    }
    public boolean check(int num){
        int i = map.get(num)[0];
        int j = map.get(num)[1];
        List<Integer> list = arr[i];
        if(j == 0 || j == list.size() - 1)  return true;
        if(num > list.get(j-1) && num > list.get(j + 1))  return false;
        return true;
    }
}
