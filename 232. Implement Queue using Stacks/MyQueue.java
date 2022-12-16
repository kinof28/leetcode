import java.util.Stack;

class MyQueue {
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int x) {
        while (!this.secondStack.empty()) {
            this.firstStack.push(this.secondStack.pop());
        }
        this.firstStack.push(x);
        while (!this.firstStack.empty()) {
            this.secondStack.push(this.firstStack.pop());
        }
    }

    public int pop() {
        return this.secondStack.pop();
    }

    public int peek() {
        return this.secondStack.peek();
    }

    public boolean empty() {
        return this.secondStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */