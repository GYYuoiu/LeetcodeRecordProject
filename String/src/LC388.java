import java.util.Deque;
import java.util.LinkedList;

public class LC388 {
    public static void main(String[] args) {
        String input =
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int ans = lengthLongestPath(input);
        System.out.println(ans);
    }

    //dir \n \tsubdir1 \n \t\tfile1.ext \n \t\tsubsubdir1 \n \tsubdir2 \n \t\tsubsubdir2 \n \t\t\tfile2.ext

    public static int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        int n = files.length;
        // 给每个文件 按层数编个号
        int[] idx = new int[n];
        boolean[] isFile = new boolean[n];
        for(int i = 0; i < n; i ++){
            String file = files[i];
            int level = 0;
            for(int j = 0; j < file.length(); j ++){
                // if(file.charAt(j) != '\\' || file.charAt(j) != 't')  break;
                if(file.charAt(j) == '\t')  level ++;
                if(file.charAt(j) == '.'){
                    isFile[i] = true;
                    break;
                }
            }
            idx[i] = level;
        }
        Deque<Integer> stack = new LinkedList<>();
        int maxLen = 0;
        int curLen = 0;
        for(int i = 0; i < n; i ++){
            String file = files[i];
            int level = idx[i];
            while(stack.size() > level){
                curLen -= stack.pop();
            }
            stack.push(file.length() - level);
            curLen += stack.peek();
            if(isFile[i])  maxLen = Math.max(maxLen, curLen + stack.size() - 1);
        }
        return maxLen;
    }
}
