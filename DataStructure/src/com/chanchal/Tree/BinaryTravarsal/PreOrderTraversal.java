package com.chanchal.Tree.BinaryTravarsal;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {
	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	BinaryTree tree = new BinaryTree();
	
	Node node = tree.buildNode(nodes);
	
	System.out.println(node.data);
	preOrderTraversalPrint(node);
	System.out.println();
	inOrderTraversal(node);
	System.out.println();
	postOrder(node);
	System.out.println();
	levelOrder(node);
	System.out.println("countOfNodes= "+countOfNodes(node));
	System.out.println("Sum of Nodes= "+sumOfNodes(node));
	System.out.println("height of Nodes = "+heightOfNode(node));
	System.out.println("Diameter of Nodes ="+diameterOfNode(node));
	System.out.println("Diameter2 of Nodes ="+diameter2OfNodes(node).diameter);
	findLeafNode(node);
	
		
	}
	//Preorder traversal
	public static void preOrderTraversalPrint(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraversalPrint(root.left);
		preOrderTraversalPrint(root.right);
	}
	//Inorder Traversals
	public static void inOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	//PostOrder Traversal
	public static void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	//Level Order Traversal
	public static void levelOrder(Node root) {
		if(root==null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			Node currNode = queue.remove();
			if(currNode!=null) {
				System.out.print(currNode.data+" ");
				if(currNode.left!=null) {
					queue.add(currNode.left);
				}
				if(currNode.right!=null) {
					queue.add(currNode.right);
				}
			}else {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}
			
		}
		
	}
	//Count of Nodes
	public static int countOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int leftNodes = countOfNodes(root.left);
		System.out.println(leftNodes);
		int rightNodes = countOfNodes(root.right);
		System.out.println(rightNodes);
		return leftNodes+ rightNodes+1;
	}
	//Sum of Nodes
	public static int sumOfNodes(Node root) {
		if(root==null) {
			return 0;
		}
		int sumOfLeft = sumOfNodes(root.left);
		int sumOfRight = sumOfNodes(root.right);
		return sumOfLeft+sumOfRight+root.data;
	}
	
	//Height of Node
	public static int heightOfNode(Node root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = heightOfNode(root.left);
		int rightHeight = heightOfNode(root.right);
		return Math.max(leftHeight, rightHeight) +1;
	}
	
	//Diameter of Node Case1: Through Root Approach 1:O(N^2)
	public static int diameterOfNode(Node root) {
		if(root == null) {
			return 0;
		}
		int diameter1 = diameterOfNode(root.left);
		int diameter2 = diameterOfNode(root.right);
		int diameter3 = (heightOfNode(root.left)+heightOfNode(root.right)+1);
		return Math.max(diameter1,Math.max(diameter2,diameter3));
	}
	//Diameter of Node Case1: Through Root Approach 2:O(N)
	public static TreeInfo diameter2OfNodes(Node root) {
		if(root==null) {
			return new TreeInfo(0,0);
		}
		TreeInfo left = diameter2OfNodes(root.left);
		TreeInfo right = diameter2OfNodes(root.right);
		int myHeight = Math.max(left.height, right.height)+1;
		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height+right.height+1;
		int mydiam = Math.max(diam3,Math.max(diam2, diam1));
		
		
		TreeInfo newTreeInfo = new TreeInfo(myHeight, mydiam);
		return newTreeInfo;						
	}
	public static void findLeafNode(Node root){
		if(root==null) {
			return;
		}if(root.left==null && root.right==null) {
			System.out.println("leaf = "+root.data);
		}
		findLeafNode(root.left);
		findLeafNode(root.right);
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			
			this.data = data;
			this.left=null;
			this.right= null;
		}
		
	}
	
	static class BinaryTree{
		static int idx =-1;
		static Node buildNode(int []nodes) {
			idx++;
			if(nodes[idx]==-1) {
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildNode(nodes);
			newNode.right = buildNode(nodes);
			return newNode;
		}
	}
	static class TreeInfo{
		int height;
		int diameter;
		public TreeInfo(int height, int diameter) {
			super();
			this.height = height;
			this.diameter = diameter;
		}
		
		
	}

}
