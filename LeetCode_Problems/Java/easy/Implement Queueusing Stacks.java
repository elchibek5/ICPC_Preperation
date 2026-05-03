// class MyQueue {

//     private Stack<Integer> stack;
//     private Stack<Integer> stack2;

//     public MyQueue() {
//         stack = new Stack<>();
//         stack2 = new Stack<>();
//     }

//     public void push(int x) {
//         stack.push(x);
//     }

//     public int pop() {
//         check();
//         return stack2.pop();
//     }

//     public int peek() {
//         check();
//         return stack2.peek();
//     }

//     public boolean empty() {
//         return stack.isEmpty() && stack2.isEmpty();
//     }

//     public void check() {
//         if (stack2.isEmpty()) {
//             while (!stack.isEmpty()) {
//                 stack2.push(stack.pop());
//             }
//         }
//     }
// }

// /**
//  * Your MyQueue object will be instantiated and called as such:
//  * MyQueue obj = new MyQueue();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.peek();
//  * boolean param_4 = obj.empty();
//  */

class MyQueue {

    private Deque<Integer> in = new ArrayDeque<>();
    private Deque<Integer> out = new ArrayDeque<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return out.pop();
    }

    public int peek() {
        moveIfNeeded();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void moveIfNeeded() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
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
