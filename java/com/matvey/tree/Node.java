package com.matvey.tree;

public class Node {
	private long key;
	private long value;
	private Node left;
	private Node right;
	private int height = 0;
	
	public Node() {}

	public Node(long key, long value) {
		this.key = key;
		this.value = value;
	}
	
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + ", height=" + height + "]";
	}
}
