package offeragain;

import java.util.Stack;

// 包含Min函数的栈
public class StackWithMinFunc {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> hs = new Stack<>();


    public StackWithMinFunc() {

    }

    public void push(int x) {
        stack.push(x);
        if (hs.isEmpty() || hs.peek()>=x){
            hs.push(x);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (hs.peek() == value)
            hs.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return hs.peek();
    }
}
