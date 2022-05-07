import java.util.Arrays;

/**
 * 描述： Todo
 */

public class LC_488_findMinStep {

    public static void main(String[] args) {
        int ans = findMinStep("WWRRBBWW", "WRBRW");
        System.out.println(ans);
    }

    public static int findMinStep(String board, String hand) {
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        hand = String.valueOf(arr);
        return dfs(board, hand);
    }

    public static int dfs(String board, String hand) {
        if(board.length() == 0)  return 0;
        if(hand.length() == 0)  return -1;

        int minStep = 6;

        for(int i = 0; i < board.length() - 1; i ++) {
            if(board.charAt(i) == board.charAt(i + 1)) {
                int idx = valid(hand, board.charAt(i));
                if(idx == -1)  return -1;
                int[] seat = findSeat(board, i);
                String nxtHand = hand.substring(0, idx) + hand.substring(idx + 1);
                String nxtBoardTemp = board.substring(0, seat[0]) + board.substring(seat[1] + 1);
                String nxtBoard = autoEliminate(nxtBoardTemp);
                int remainStep = dfs(nxtBoard, nxtHand);
                if(remainStep != -1)  minStep = Math.min(remainStep + 1, minStep);
            }
        }
        return minStep == 6 ? -1 : minStep;
    }
    public static int[] findSeat(String board, int start) {
        int end = start + 1;
        while(end < board.length() && board.charAt(end) == board.charAt(start))  end ++;
        return new int[]{start, end - 1};
    }

    public static int valid(String hand, char ch) {
        for(int i = 0; i < hand.length(); i ++) {
            if(hand.charAt(i) == ch)  return i;
        }
        return -1;
    }

    public static String autoEliminate(String board) {
        int len = board.length();
        char[] arr = board.toCharArray();
        boolean[] delete = new boolean[len];
        boolean flag = false;

        for(int i = 0; i < len - 2; ) {
            if(arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                flag = true;
                int j = i;
                while(j < len && arr[j] == arr[i]) {
                    delete[j] = true;
                    j ++;
                }
                i = j;
            } else {
                i ++;
            }
        }
        if(!flag)  return board;
        StringBuffer temp = new StringBuffer();
        for(int i = 0; i < len; i ++) {
            if(!delete[i])  temp.append(arr[i]);
        }
        return autoEliminate(temp.toString());
    }
}
