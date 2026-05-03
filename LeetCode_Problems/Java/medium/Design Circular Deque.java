class MyCircularDeque {

    private int k;
    Deque<Integer> deque;

    public MyCircularDeque(int k) {
        this.k = k;
        deque = new ArrayDeque<>();
    }
    
    public boolean insertFront(int value) {
        if (!isFull()) {
            deque.offerFirst(value);
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if (!isFull()) {
            deque.offerLast(value);
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if (!deque.isEmpty()) {
            deque.removeFirst();
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if (!deque.isEmpty()) {
            deque.removeLast();
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }
    
    public int getRear() {
        if (deque.isEmpty()) return -1;
        return deque.peekLast();
    }
    
    public boolean isEmpty() {
        return deque.size() == 0;
    }
    
    public boolean isFull() {
        return deque.size() == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
