import java.util.HashMap;
import java.util.Map;

/**
 * 描述： Todo
 */

public class LC_397_integerReplacement {

    public static void main(String[] args) {
        int ans = integerReplacement(1);
        System.out.println(ans);
    }


    static Map<Integer, Integer> memo;

    public static int integerReplacement(int n) {
        memo = new HashMap<>();
        return minSteps(n);
    }

    public static int minSteps(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        if (n % 2 == 1) {
            if (n == Integer.MAX_VALUE) {
                ans = minSteps(n - 1) + 1;
            } else {
                ans = Math.min(minSteps(n + 1), minSteps(n - 1)) + 1;
            }
        } else {
            int m = n;
            while (m % 2 == 0) {
                m /= 2;
                ans += 1;
            }
            ans += minSteps(m);
        }
        memo.put(n, ans);
        return ans;
    }
}
