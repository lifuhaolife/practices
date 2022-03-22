package leetcode._2022._03._0322;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();


    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
