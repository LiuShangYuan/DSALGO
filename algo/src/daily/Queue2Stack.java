package daily;

import java.util.LinkedList;

//
public class Queue2Stack {

    LinkedList<Integer> queue = new LinkedList<>();
    /** Initialize your data structure here. */
    public Queue2Stack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
