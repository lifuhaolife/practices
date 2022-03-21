package leetcode._2022._03._0319;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {

    //a + b + c =0  　转换　ａ　＋　ｂ　＝　－ｃ　
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        selectSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 存在的几种情况:
         *  if 三数之和
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if ((nums[i]) > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; j++, k--) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                    continue;
                }
                if (sum > 0) {
                    k--;
                    continue;
                }
                if (sum == 0) {
                    List<Integer> collect = Stream.of(nums[i], nums[j], nums[k]).collect(Collectors.toList());
                    result.add(collect);
                    j++;
                    k--;
                }

            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum3(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if ( i == 0 || (i > 0) && nums[i] != nums[i - 1]){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi){

                    if (nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) lo++;
                        lo++;
                        hi--;
                    }else if (nums[lo] + nums[hi] < sum){
                        lo++;
                    }else hi--;
                }

            }

        }
        return res;
    }

    private static int[] selectSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                min = (nums[min] > nums[j]) ? j : min;
            }
            swap(nums, i, min);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int min) {
        int temp = nums[min];
        nums[min] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, -1, -2, -4, -3, 7};
        Arrays.stream(selectSort(a)).forEach(System.out::println);
//        Arrays.stream(insertSort(a)).forEach(System.out::println);
//        threeSum2(a).stream().forEach(System.out::println);
//        threeSum3(a).stream().forEach(System.out::println);

    }
}
//