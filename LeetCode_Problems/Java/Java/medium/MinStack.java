// class MinStack {

//     private Stack<Integer> s;
//     private Stack<Integer> min;

//     public MinStack() {
//         s = new Stack<>();
//         min = new Stack<>();
//     }
    
//     public void push(int val) {
//         s.push(val);
//         if (min.isEmpty() || val <= min.peek()) {
//             min.push(val);
//         }
//     }
    
//     public void pop() {
//         if (s.isEmpty()) return;
//         int top = s.pop();
//         if (top == min.peek()) {
//             min.pop();
//         }
//     }
    
//     public int top() {
//         return s.peek();
//     }
    
//     public int getMin() {
//         return min.peek();
//     }
// }

// /**
//  * Your MinStack object will be instantiated and called as such:
//  * MinStack obj = new MinStack();
//  * obj.push(val);
//  * obj.pop();
//  * int param_3 = obj.top();
//  * int param_4 = obj.getMin();
//  */


class MinStack {
    private Node head;
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
