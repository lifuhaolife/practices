package leetcode._2022._04._20;


import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        Queue<String> q = new PriorityQueue<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为队列为空
        System.out.println(q.poll()); // null,因为队列为空
    }
}
