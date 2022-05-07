import java.util.HashMap;
import java.util.Map;

/**
 * 描述： timeout
 */

public class LC_546_removeBoxes {

    public static void main(String[] args) {
        int ans = removeBoxes(new int[]{1,2,2,1,1,1,2,1,1,2,1,2,1,1,2,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,1,1,2,2,1,2,1,2,2,1,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1});
        System.out.println(ans);
    }

    static Map<String, Integer> memo;
    public static int removeBoxes(int[] boxes) {
        memo = new HashMap<>();
        return dfs(arr2Str(boxes, 0, boxes.length));
    }

    public static int dfs(String board) {
        if(board.length() == 0)  return 0;
        if(!memo.containsKey(board)) {
            int[] boxes = str2Arr(board);
            int len = boxes.length;
            int maxScore = 1;

            for(int i = 0; i < len; i ++) {
                int j = i + 1;
                while(j < len && boxes[j] == boxes[i])  j ++;
                int curScore = (j - i) * (j - i);
                String leftStr = arr2Str(boxes, 0, i);
                String rightStr = arr2Str(boxes, j, boxes.length);
                String remain = leftStr + rightStr;
                int allScore = curScore + dfs(remain);
                maxScore = Math.max(maxScore, allScore);
            }
            memo.put(board, maxScore);
        }
        return memo.get(board);
    }

    public static String arr2Str(int[] boxes, int i, int j){
        StringBuffer board = new StringBuffer();
        for(int k = i; k < j; k ++)  board.append(boxes[k] + "_");
        return board.toString();
    }

    public static int[] str2Arr(String str){
        String[] strArr = str.split("_");
        int[] boxes = new int[strArr.length];
        for(int i = 0; i < strArr.length; i ++) {
            boxes[i] = Integer.parseInt(strArr[i]);
        }
        return boxes;
    }
}
