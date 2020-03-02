716. Max Stack
Easy

475

87

Favorite

Share
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.

class MaxStack {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        
    /** initialize your data structure here. */
    public MaxStack() {
       
    }
    
    public void push(int x) {
        if(stk2.isEmpty()||x>=stk2.peek())
            stk2.push(x);
        stk1.push(x);
    }
    
    public int pop() {
        int c = stk1.peek();
        int k = stk2.peek();
        if(!stk2.isEmpty()&&c==k)
            stk2.pop();
        return stk1.pop();
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int peekMax() {
        return stk2.peek();
    }
    
    public int popMax() {
        int max = stk2.peek();
        Stack<Integer> tmp  = new Stack<>();
        while(!stk1.peek().equals(stk2.peek())){
            tmp.push(stk1.pop());
        }
        stk1.pop();
        stk2.pop();
        while(!tmp.isEmpty()){
            this.push(tmp.pop());
        }
        return max;
    }
}