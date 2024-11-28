package com.chanchal.Stack;

import java.util.ArrayList;

import com.chanchal.Stack.LinkedListImpmtOfStack.Stack;

public class ArrayListImplOfStack {
	
	public static void main(String[] args) {

		   Stack stack = new Stack();
		   stack.push(1);
		   stack.push(2);
		   stack.push(3);
		   stack.push(4);
		   stack.push(5);
		   while (!stack.isEmpty()){
			   System.out.println(stack.peek());
			   stack.pop();
			   {
		   }
			
		}
	}
	public static class Stack	{
		public static ArrayList<Integer> list = new ArrayList<>();
		public static boolean isEmpty() {
			return list.size()==0;
		}
		public static void push(int data) {
			list.add(data);
		}
		public static int pop() {
			int pop = list.get(list.size()-1);
			if(isEmpty()) {
				return -1;
			}
			list.remove(list.size()-1);
			return pop;			
		}
		public static int peek() {
			if(isEmpty()) {
				return -1;
			}
			return list.get(list.size()-1);
		}
	}
	
	
}
