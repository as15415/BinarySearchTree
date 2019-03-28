package schultz.gsu.binarysearchtree;

import schultz.gsu.binarytree.BinaryTreeNode;

public class Test {
	
	public static void testFirstExample() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> nine = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
		
		root.setLeftChild(two);
		root.setRightChild(nine);
		
		two.setLeftChild(one);
		two.setRightChild(four);
		
		nine.setLeftChild(eight);
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(root);
		
		System.out.println(tree.insert(5, root).getElement() + "\n");
		
		tree.inOrder(root);
	}
	
	public static void testSecondExample() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> nine = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		
		root.setRightChild(three);
		
		three.setLeftChild(two);
		three.setRightChild(eight);
		
		eight.setLeftChild(six);
		eight.setRightChild(nine);
		
		six.setLeftChild(five);
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(root);
		
		tree.delete(3, root);
		
		tree.inOrder(root);
	}

	public static void main(String[] args) {
		testFirstExample();
		//testSecondExample();
	}

}
