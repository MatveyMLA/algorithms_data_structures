package com.matvey.tree;

import static java.util.Objects.isNull;

public class AVLTree {
	
	public void insert(Node node, int key, int value) {	
		if(key < node.getKey()) {
			if(isNull(node.getLeft())) {
				node.setLeft(new Node(key, value));
			}
			else {
				insert(node.getLeft(), key, value);
			}
		}
		else if(key >= node.getKey()) {
			if(isNull(node.getRight())) {
				node.setRight(new Node(key, value));
			}
			else {
				insert(node.getRight(), key, value);
			}
		}
		updateHeight(node);
		
		if(getHeight(node) > 1) {
			balance(node);
		}
	}
	
	public Node delete(Node node, long key) {
		if(isNull(node)) {
			return null;
		}
		else if(key < node.getKey()) {
			node.setLeft(delete(node.getLeft(), key));
		}
		else if(key > node.getKey()) {
			node.setRight(delete(node.getRight(), key));			
		}
		else {
			if(isNull(node.getLeft()) || isNull(node.getRight())) {		
				node = isNull(node.getLeft()) ? node.getRight()  : node.getLeft();
			}
			else {
				Node maxLeft = getMaxElement(node.getLeft());
				node.setKey(maxLeft.getKey());
				node.setValue(maxLeft.getValue());
				node.setRight(delete(node.getRight(), node.getKey()));
			}
		}	
		if(!isNull(node)) {
			updateHeight(node);
			balance(node);
		}
		return node;
	}
	
	public Node search(Node node, long key) {
		if(isNull(node)) {
			return null;
		}
		if(node.getKey() == key) {
			return node;
		}
		return node.getKey() < key ? search(node.getRight(), key) : search(node.getLeft(), key);
	}
	
	public void balance(Node node) {
		int balaninHeight = getBalaninHeight(node);
		if(balaninHeight == -2) {
			if(getBalaninHeight(node.getLeft()) == 1) {
				leftRotate(node.getLeft());
			}
			rightRotate(node);
		} 
		else if(balaninHeight == 2) {
			if(getBalaninHeight(node.getRight()) == -1) {
				rightRotate(node.getRight());
			}
			leftRotate(node);
		}
	}
		
	public Node getMinElement(Node node) {
		if(isNull(node)) {
			return null;
		}	
		if(isNull(node.getLeft())) {
			return node;
		}		
		return getMinElement(node.getLeft());
	}
	
	public Node getMaxElement(Node node) {
		if(isNull(node)) {
			return null;
		}
		if(isNull(node.getRight())) {
			return node;
		}	
		return getMaxElement(node.getLeft());
	}
	
	private void updateHeight(Node node) {
		int newHeight = Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
		node.setHeight(newHeight);
	}
	
	public int getBalaninHeight(Node node) {
		// if result is -2 -> Left  side is higher, so rotate to the right;
		// if result is  2 -> Right side is higher, so rotate to the left;
		return isNull(node) ? 0 : getHeight(node.getRight()) - getHeight(node.getLeft());
	}
	
	public void rightRotate(Node node) {
		swap(node, node.getLeft());
		var temp = node.getRight();
		node.setRight(node.getLeft());
		node.setLeft(node.getRight().getLeft());
		node.getRight().setLeft(node.getRight().getRight());
		node.getRight().setRight(temp);
		updateHeight(node.getRight());
		updateHeight(node);
	}
	
	public void leftRotate(Node node) {
		swap(node, node.getRight());
		var temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(node.getLeft().getRight());
		node.getLeft().setRight(node.getLeft().getLeft());
		node.getLeft().setLeft(temp);
		updateHeight(node.getLeft());
		updateHeight(node);
	}
	
	public void swap(Node a, Node b) {
		long aKey = a.getKey();
		a.setKey(b.getKey());
		b.setKey(aKey);
		long aValue = a.getValue();
		a.setValue(b.getValue());
		b.setValue(aValue);
	}

	public int getHeight(Node node) {
		return isNull(node) ?  -1 : node.getHeight();
	}
	
	//Use for checking tree after inserting or deleting
	public void simmetricPrintTree(Node node) {
		if(isNull(node)) {
			return;
		}		
		simmetricPrintTree(node.getLeft());
		System.out.println(node);
		simmetricPrintTree(node.getRight());	
	}
	//deleteTree(Node node) - for no GC. Manual memory management languages
	public void reversePrintTree(Node node) {
		if(isNull(node)) {
			return;
		}
		reversePrintTree(node.getLeft());
		reversePrintTree(node.getRight());
		System.out.println((node));
	}

	//copyTree(Node node) - Might be used for coping tree in memory.
	public void streightPrintTree(Node node) {
		if(isNull(node)) {
			return;
		}
	    System.out.println((node));
	    streightPrintTree(node.getLeft());
	    streightPrintTree(node.getRight());
	}	
}
