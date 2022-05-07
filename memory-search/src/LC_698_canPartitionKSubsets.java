import java.util.TreeMap;

/**
 * 描述： 贪心做不了，timeout
 */

public class LC_698_canPartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        int k = 5;
        boolean ans = canPartitionKSubsets(nums, k);
        System.out.println(ans);
    }

    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if(n < k)  return false;
        int max = 0, sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(sum % k != 0)  return false;
        int target = sum / k;
        if(max > target)  return false;

        int[] bucket = new int[k];
        for(int i = 0; i < k; i ++) {
            int diff = target;
            while(diff > 0) {
                Integer num = map.floorKey(diff);
                if(num == null)  return false;

                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0)  map.remove(num);

                diff -= num;
            }
        }
        return true;
    }
}
