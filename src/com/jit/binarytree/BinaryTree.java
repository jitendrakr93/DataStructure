package com.jit.binarytree;

public class BinaryTree {
	private Node root;

	public BinaryTree() {
		root = null;
	}
	
	public void display() {
		display(root,0);
		System.out.println();
	}

	private void display(Node p, int level) {
		int i;
		if(p == null)
			return;
		display(p.rchild, level+1);
		System.out.println();
		for(i =0 ;i<level;i++)
		
	}

}
