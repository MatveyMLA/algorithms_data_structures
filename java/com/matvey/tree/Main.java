package com.matvey.tree;

public class Main {

	public static void main(String[] args) {
		var tree = new AVLTree();
		var node = new Node(10, 10);
		tree.insert(node, 14, 14);
		tree.insert(node, 33, 33);
		tree.insert(node, 8, 8);
		tree.insert(node, 1, 1);
		tree.insert(node, 55, 55);
		tree.insert(node, 4, 4);
		tree.insert(node, 16, 16);
		tree.insert(node, 10, 10);
		tree.insert(node, 13, 13);
		tree.insert(node, 67, 67);
		tree.insert(node, 100, 100);
		tree.insert(node, 0, 0);
		tree.insert(node, 22, 22);
		
		tree.simmetricPrintTree(node);
		
//		print:
//				[key=0, value=0]
//				[key=1, value=1]
//				[key=4, value=4]
//				[key=8, value=8]
//				[key=10, value=10]
//				[key=10, value=10]
//				[key=13, value=13]
//				[key=14, value=14]
//				[key=16, value=16]
//				[key=22, value=22]
//				[key=33, value=33]
//				[key=55, value=55]
//				[key=67, value=67]
//				[key=100, value=100]
		
		System.out.println(tree.search(node, 33)); 
//              Searching 33 with Node 10 : [key=33, value=33]
				
	}

}
