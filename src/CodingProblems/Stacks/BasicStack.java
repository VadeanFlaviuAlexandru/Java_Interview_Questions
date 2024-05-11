package CodingProblems.Stacks;

import java.util.Stack;

public class BasicStack {
    // a LIFO data structure. push() to add to the top
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("hey1");
        stack.push("hey2");
        stack.push("hey3");
        System.out.println(stack);
        stack.pop();
        stack.peek();
        stack.search("hey3");
        // and so on
    }
}
