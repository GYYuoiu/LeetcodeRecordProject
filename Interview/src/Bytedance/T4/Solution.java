package Bytedance.T4;

import java.util.*;

public class Solution {
    String[] cards;
    Map<Character, Integer> exit;
    int cardNum;
    int ans;
    public int method(String[] cards){
        this.cards = cards;
        exit = new HashMap<>();
        cardNum = 0;
        ans = cards.length + 1;
        backtrack(0, exit);
        return ans == cards.length + 1 ? -1 : ans;
    }
    public void backtrack(int idx, Map<Character, Integer> exit){
        if(exit.size() == 10){
            ans = Math.min(ans, cardNum);
            return;
        }

        for(int i = idx; i < cards.length; i ++){
            String cur = cards[idx];
            for(int j = 0; j < 3; j ++){
                char ch = cur.charAt(j);
                exit.put(ch, exit.getOrDefault(ch, 0) + 1);
            }
            cardNum += 1;
            backtrack(i + 1, exit);
            cardNum -= 1;
            for(int j = 0; j < 3; j ++){
                char ch = cur.charAt(j);
                exit.put(ch, exit.get(ch) - 1);
                if(exit.get(ch) == 0)  exit.remove(ch);
            }
        }
    }
}
