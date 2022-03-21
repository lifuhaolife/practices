package leetcode._2022._03._0318;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] result = {0, 1};
        if (nums.length <= 2){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            result[0] = nums[i];
            int searchNum = target - nums[i];
            for (int j = 1, k = nums.length - 1; j < k; j++, k--) {
                if (nums[j] == searchNum) {
                    result[1] = j;
                    return result;
                }
                if (nums[k] == searchNum){
                     result[1] = k;
                    return result;
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Arrays.stream(twoSum3(a, 10)).forEach(System.out::println);
    }
}
