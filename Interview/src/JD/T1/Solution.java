package JD.T1;

public class Solution {
    public int fight(int tankNum, int blood, int attack, int enemyNum){
        int cnt = 0;
        int remainBlood = blood * enemyNum;
        while(tankNum > 0 && remainBlood > 0){
            remainBlood -= tankNum;
            enemyNum = (remainBlood + blood - 1) / blood;
            tankNum -= enemyNum * attack;
            cnt ++;
        }
        if(remainBlood > 0)  return -1;
        return cnt;
    }
}
