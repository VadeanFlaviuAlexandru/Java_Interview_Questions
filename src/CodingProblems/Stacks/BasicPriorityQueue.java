package CodingProblems.Stacks;

import java.util.PriorityQueue;
import java.util.Queue;

public class BasicPriorityQueue {
    public static void main(String[] args) {
        Queue<Double> queue = new PriorityQueue<>();
//        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder()); // for reversing
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.5);
        queue.offer(1.5);
        queue.offer(6.5);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
            // 1.5 , 2.5 , 3.0 , 4.5 , 6.5 -> ascending order
        }
    }
}
