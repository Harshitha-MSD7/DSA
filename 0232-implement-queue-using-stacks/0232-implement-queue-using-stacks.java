class MyQueue {

    Stack<Integer> stack1; 
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 =  new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        shift(stack1, stack2);
        int res = stack2.pop();
        shift(stack2, stack1);
        return res;

    }
    
    public int peek() {
        shift(stack1, stack2);
        int res = stack2.peek();
        shift(stack2, stack1);
        return res;
    }
    
    public boolean empty() {
        if(stack1.isEmpty()) return true;
        return false;
    }

    // shift elemets from stack1 to stack2
    private void shift(Stack<Integer> stack1, Stack<Integer> stack2){
        int size = stack1.size();
        for(int i = 0; i<size; i++){
            stack2.push(stack1.pop());
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