package leetcode;
import java.util.*;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack1 stack = new Stack1();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
	}

}

// 总是将新插入的元素放到queue1或是queue2的第一个

class Stack1{
	LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();
 
    // Push element x onto stack.
    public void push(int x) {
        if(empty()){
            queue1.offer(x);
        }else{
            if(queue1.size()>0){
                queue2.offer(x);
              
                while(queue1.size()>0){
                    queue2.offer(queue1.poll());
                }
            }else if(queue2.size()>0){
                queue1.offer(x);
                
                while(queue2.size()>0){
                    queue1.offer(queue2.poll());
                }
            }
        }
    }
 
    // Removes the element on top of the stack.
    public int pop() {
        if(queue1.size()>0){
           return  queue1.poll();
        }else if(queue2.size()>0){
           return queue2.poll();
        }
        return 0;
    }
 
    // Get the top element.
    public int top() {
       if(queue1.size()>0){
            return queue1.peek();
        }else if(queue2.size()>0){
            return queue2.peek();
        }
        return 0;
    }
 
    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}