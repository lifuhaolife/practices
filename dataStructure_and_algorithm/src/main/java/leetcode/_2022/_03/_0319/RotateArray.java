package leetcode._2022._03._0319;

import java.util.Arrays;
import org.junit.Test;

public class RotateArray {

    /**
     * solution 1:
     * Using a new array to store nums,
     * 使用一个新的数组进行存储，
     * 找到下表的位置
     *
     * @param nums
     * @param k
     */
    public void rotateArray(int[] nums, int k) {

        int[] result = new int[nums.length];

        int move = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if ( i < nums.length - move){
                result[ i + move] = nums[i];
            }else {
                result[ i + move - nums.length] = nums[i];
            }
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public void rotateArray1(int nums[], int k){
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,k,nums.length -1);
        reverse(nums,0,k-1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start+=1;
            end -= 1;
        }
    }

    @Test
    public void test() {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        rotateArray1(a,3);
        Arrays.stream(a).forEach(System.out::println);
    }
}
