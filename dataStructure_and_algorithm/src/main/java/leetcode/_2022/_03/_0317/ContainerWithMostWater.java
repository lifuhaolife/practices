package leetcode._2022._03._0317;

public class ContainerWithMostWater {

    public static int maxArea(int[] a) {
        int maxArea = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                if (a[i] > a[j]) {
                    maxArea = Math.max(((j - i) * a[j]), maxArea);
                } else {
                    maxArea = Math.max((a[i] * (j - i)), maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int maxArea1(int[] a) {

        int left = 0, right = a.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(a[left], a[right]);
            if (a[left] < a[right]) {
                ++left;
            } else {
                --right;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static int maxArea2(int[] a) {

        int maxArea = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int height = a[i] < a[j] ? a[i++] : a[j--];
            int area = (j - i + 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(a));
    }
}
