package leetcode._2022._03._0321;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.Test;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public boolean checkValidString1(String s) {
        int l = 0, m = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                l--;
            } else {
                m++;
            }

            if (l < 0) {
                l++;
                m--;
            }
            if (m < 0) {
                return false;
            }
        }
        int r = 0;
        m = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                r++;
            } else if (c == '(') {
                r--;
            } else {
                m++;
            }

            if (r < 0) {
                r++;
                m--;
            }
            if (m < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValidString2(String s) {
        // minCount 和 将 * 当成 (  maxCount 将 * 当作 )
        int minCount = 0, maxCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.min(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.min(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }

    @Test
    public void test1() {
        System.out.println(checkValidString("(()*******))()()()"));
    }
    //TODO: 使用动态规划贪心算法实现
}
