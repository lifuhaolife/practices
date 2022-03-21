package leetcode._2022._03._0320;

import org.junit.Test;

public class MergeTwoSortedArray {

    public int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int position = 0;
        for (int i = nums1.length - 1; i >= 0 ; i--) {
                if (nums1[i] != 0){
                    position = i + 1;
                    break;
                }
        }
        for (int j = 0; j < nums2.length; j++) {
            nums1[j + position] = nums2[j];
        }

        for (int i = 0; i < nums1.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums1.length ; j++) {
                minIndex = nums1[minIndex] > nums1[j] ? j : minIndex;
            }
            int temp = nums1[minIndex];
            nums1[minIndex] = nums1[i];
            nums1[i] = temp;
        }
        return nums1;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0; int p2 = 0;
        int[] sorted = new int[m+n];
        int cur;
        while (p1 < m || p2 < n){

            if ( p1 == m){
                cur = nums2[p2++];
            }else if ( p2 == n){
                cur = nums1[p1++];
            }else if (nums1[p1] < nums2[p2]){
                cur = nums1[p1++];
            }else {
                cur = nums2[p2++];
            }
            sorted[ p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }

    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while ( len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        while (len2 >= 0){
            nums1[len -- ] = nums2[len2--];
        }
    }

    @Test
    public void test(){
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7,0,0,0,0};
        int[] b = { 6, 2, 3, 7};
        mergeTwoArray(a,b);
    }
}
