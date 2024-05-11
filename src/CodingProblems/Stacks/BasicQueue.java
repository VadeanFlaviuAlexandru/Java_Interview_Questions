package CodingProblems.Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue {
    // a FIFO data structure
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("cherry");
        // ...
    }

}
