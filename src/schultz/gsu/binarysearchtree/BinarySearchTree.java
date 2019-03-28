package schultz.gsu.binarysearchtree;

import schultz.gsu.binarytree.BinaryTreeNode;
import schultz.gsu.binarytree.LinkedBinaryTree;

public class BinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> {

	public BinarySearchTree(BinaryTreeNode<T> root) {
		super(root);
	}
	
	public BinaryTreeNode<T> search(T key, BinaryTreeNode<T> node) {
		if(node == null)
			return null;
		
		else if(key.compareTo(node.getElement()) < 0)
			return search(key, node.getLeftChild());
		
		else if(key.compareTo(node.getElement()) > 0)
			return search(key, node.getRightChild());
		
		else // key == node.getElement()
			return node;
	}
	
	public BinaryTreeNode<T> insert(T key, BinaryTreeNode<T> node) {
		if(super.isEmpty()) {
			BinaryTreeNode<T> insertedNode = new BinaryTreeNode<T>(key);
			super.setRoot(insertedNode);
			
			return insertedNode;
		}
		
		else if(key.compareTo(node.getElement()) < 0) {
			if(node.getLeftChild() == null) {
				BinaryTreeNode<T> insertedNode = new BinaryTreeNode<T>(key);
				node.setLeftChild(insertedNode);
				
				return insertedNode;
			}
			
			else
				return insert(key, node.getLeftChild());
		}

		else { // key.compareTo(node.getElement()) > 0
			if(node.getRightChild() == null) {
				BinaryTreeNode<T> insertedNode = new BinaryTreeNode<T>(key);
				node.setRightChild(insertedNode);
				
				return insertedNode;
			}
			
			else
				return insert(key, node.getRightChild());
		}
	}
	
	// Consider making this more concise?! (If possible)
	public void delete(T key, BinaryTreeNode<T> node) {
		BinaryTreeNode<T> toDelete = search(key, node);
		
		if(toDelete.getLeftChild() == null) { // Case 1
			// find out how to connect the parent: as its left subtree or right?
			if(toDelete.getParent().getLeftChild() == toDelete) {
				if(super.isExternal(toDelete))
					toDelete.getParent().setNullLeftChild();
				else
					toDelete.getParent().setLeftChild(toDelete.getRightChild());
			}
			
			else {
				if(super.isExternal(toDelete))
					toDelete.getParent().setNullRightChild();
				else
					toDelete.getParent().setRightChild(toDelete.getRightChild());
			}
		}
		
		else { // Case 2
			BinaryTreeNode<T> rightMost = getRightMost(toDelete.getLeftChild());
			
			if(rightMost == toDelete.getLeftChild()) {
				toDelete.setElement(rightMost.getElement());
				
				if(rightMost.getLeftChild() == null)
					toDelete.setNullLeftChild();
				
				else
					toDelete.setLeftChild(rightMost.getLeftChild());
			}
		
			else {
				toDelete.setElement(rightMost.getElement());
				rightMost.getParent().setRightChild(rightMost.getLeftChild());
			}
		}
	}
	
	private BinaryTreeNode<T> getRightMost(BinaryTreeNode<T> node) {
		if(node.getRightChild() == null)
			return node;
		
		return getRightMost(node.getRightChild());
		
	}

}
