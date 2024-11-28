package com.chanchal.Stack;

import java.util.Stack;

public class StackProblems {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(10);
		pushAtBottom(4, stack);
		newStack=	printMaxFirst(stack);
	//	4 3 2 1
		//reverse(stack);
		while(!newStack.isEmpty()) {
			System.out.println(newStack.peek());
			newStack.pop();
		}
		System.out.println(	);
	}
	public static void pushAtBottom(int data, Stack<Integer> stack) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int top = stack.pop();
		pushAtBottom(data, stack);
		stack.push(top);		
	}
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		reverse(stack);
		pushAtBottom(top, stack);
	}
	static Stack<Integer> newStack = new Stack<>();
	public static Stack printMaxFirst(Stack<Integer> stack) {	
		while(!stack.empty()) {
			if(newStack.isEmpty()) {
				newStack.push(stack.pop());
			}
			if(newStack.peek()>stack.peek()) {
				pushAtBottom(stack.pop(), newStack);
			}
			else {
				newStack.push(stack.pop());
			}
		}
		if(stack.isEmpty()) {
			return newStack;
		}
		
		return newStack;
	}
}
