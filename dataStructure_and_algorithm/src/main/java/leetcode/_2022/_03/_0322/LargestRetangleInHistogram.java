package leetcode._2022._03._0322;

import java.util.Stack;
import org.junit.Test;

public class LargestRetangleInHistogram {

    //1.暴力方式解决
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int curHight = heights[i];
            while (left > 0 && heights[left - 1] >= curHight) {
                left--;
            }
            int right = i;
            while (right < len && heights[right + 1] >= curHight) {
                right++;
            }
            int with = right - left + 1;
            area = Math.max(area, with * curHight);
        }
        return area;
    }

    //2 单调栈解决
    public int largestRectangleArea1(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (heights[i]));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek()));
        }
        return maxArea;
    }


    @Test
    public void test(){
        int[] ints = {2, 1, 5, 6, 2, 3};
        largestRectangleArea1(ints);
    }
}

