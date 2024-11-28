package com.chanchal.Tree.BinaryTravarsal;

public class FindLeafNode {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		printleaf(root);
		preOrder(root);
		
		
	}
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public static void printleaf(Node root) {
		if(root == null) {
			return ;
		}if(root.left==null && root.right==null) {
			System.out.println(root.data);
		}
		printleaf(root.left);
		printleaf(root.right);
	}
	public static void preOrder(Node root) {
		if(root==null) {			
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
}
