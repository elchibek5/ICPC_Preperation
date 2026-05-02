class MedianFinder {

    PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> upper = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // insert
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.add(num);
        } else {
            upper.add(num);
        }

        // rebalace
        if (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        } else if (upper.size() > lower.size()) { 
            lower.add(upper.poll());
        }
    }
    
    public double findMedian() {
        if (lower.size() > upper.size()) {
            return lower.peek();
        } else {
            return (lower.peek() + upper.peek()) / 2.0; 
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
