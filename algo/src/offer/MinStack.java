package offer;

import org.junit.Test;

import java.util.Stack;

// 包含min函数的栈
public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void push(int node) {
        if(stack1.isEmpty()){
            stack2.push(node);
        }else {
            if(node <= stack2.peek()){
                stack2.push(node);
            }
        }

        stack1.push(node);
    }

    public void pop() {
        if(!stack1.isEmpty()){
            int value = stack1.pop();
            if(value == stack2.peek()){
                stack2.pop();
            }
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }


    @Test
    public void test(){
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
    }
}
