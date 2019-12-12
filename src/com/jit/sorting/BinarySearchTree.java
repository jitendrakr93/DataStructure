package com.jit.sorting;

public class BinarySearchTree {
	private TreeNode root;
	private static int x;

	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void insert(int x) {
		root = insert(root, x);
	}

	private TreeNode insert(TreeNode p, int x) {
		if (p == null)
			p = new TreeNode(x);
		else if (x < p.info)
			p.lchild = insert(p.lchild, x);
		else if (x > p.info)
			p.rchild = insert(p.rchild, x);
		else
			System.out.println(x + " alredy present in the tree.");
		return p;
	}

	public boolean search1(int x) {
		TreeNode p = root;
		while (p != null) {
			if (x < p.info)
				p = p.lchild;/* Move to left child */
			else if (x > p.info)
				p = p.rchild;/* Move to right child */
			else
				return true;
		}
		return false;
	}

	public boolean search(int x) {
		return (search(root, x) != null);
	}

	private TreeNode search(TreeNode p, int x) {
		if (p == null)
			return null;/* Key not found */
		if (x < p.info)/* Search in left sub tree */
			return search(p.lchild, x);
		if (x > p.info)/* Search in right sub tree */
			return search(p.rchild, x);
		return p;/* Key found */
	}

	public int min1() {
		if (isEmpty())
			throw new NullPointerException("Tree is empty");
		TreeNode p = root;
		while (p.lchild != null)
			p = p.lchild;
		return p.info;
	}

	public int max1() {
		if (isEmpty())
			throw new NullPointerException("Tree is empty");
		TreeNode p = root;
		while (p.rchild != null)
			p = p.rchild;
		return p.info;
	}

	public int min() {
		if (isEmpty())
			throw new NullPointerException("Tree is empty");
		return min(root).info;
	}

	private TreeNode min(TreeNode p) {
		if (p.lchild == null)
			return p;
		return min(p.lchild);
	}

	public int max() {
		if (isEmpty())
			throw new NullPointerException("Tree is empty");
		return max(root).info;
	}

	private TreeNode max(TreeNode p) {
		if (p.rchild == null)
			return p;
		return max(p.rchild);
	}

	public void insert1(int x) {
		TreeNode p = root;
		TreeNode par = null;
		while (p != null) {
			par = p;
			if (x < p.info)
				p = p.lchild;
			else if (x > p.info)
				p = p.rchild;
			else {
				System.out.println(x + " already present in the tree.");
			}
		}
		TreeNode temp = new TreeNode(x);
		if (par == null)
			root = temp;
		else if (x < par.info)
			par.lchild = temp;
		else
			par.rchild = temp;
	}

	public void delete1(int x) {
		TreeNode p = root;
		TreeNode par = null;
		while (p != null) {
			if (x == p.info)
				break;
			par = p;
			if (x < p.info)
				p = p.lchild;
			else
				p = p.rchild;
		}
		if (p == null) {
			System.out.println(x + " Not found");
			return;
		}
		/* case 0: 2 children */
		/* Find inorder successor and its parent */
		/* s - inorder successor,ps- parent of inorder successor */
		TreeNode s, ps;
		if (p.lchild != null && p.rchild != null) {
			ps = p;
			s = p.rchild;
			while (s.lchild != null) {
				ps = s;
				s = s.lchild;
			}
			p.info = s.info;
			p = s;
			par = ps;
		}
		/* case B and case A: 1 or no child */
		TreeNode ch;
		if (p.lchild != null)/* Node to be deleted has left child */
			ch = p.lchild;
		else /* Node to be deleted has right child or no child */
			ch = p.rchild;
		if (par == null) /* Node to be deleted is root node */
			root = ch;
		else if (p == par.lchild)/* Node is left child of its parent */
			par.lchild = ch;
		else/* Node is right child of its parent */
			par.rchild = ch;
	}

	public void delete(int x) {
		root = delete(root, x);
	}

	private TreeNode delete(TreeNode p, int x) {
		TreeNode ch, s;
		if (p == null) {
			System.out.println(x + " not found");
			return p;
		}
		if (x < p.info)/* delete from left sub tree */
			p.lchild = delete(p.lchild, x);
		if (x > p.info)/* delete from right sub tree */
			p.rchild = delete(p.rchild, x);
		else {
			/* key to be deleted is found */
			if (p.lchild != null && p.rchild != null) {/* 2 children */
				s = p.rchild;
				while (s.lchild != null)
					s = s.lchild;
				p.info = s.info;
				p.rchild = delete(p.rchild, s.info);
			} else {/* one child or no child */
				if (p.lchild != null)/* only left child */
					ch = p.lchild;
				else /* Only right child or no child */
					ch = p.rchild;
				p = ch;
			}
		}
		return p;
	}

	/* Below methods are same as Binary tree */
	public void display() {
		display(root, 0);
		System.out.println();
	}

	private void display(TreeNode p, int level) {
		int i;
		if (p == null)
			return;
		display(p.rchild, level + 1);
		System.out.println();
		for (i = 0; i < level; i++)
			System.out.print(" ");
		System.out.print(p.info);
		display(p.lchild, level + 1);
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(TreeNode p) {
		if (p == null)
			return;
		System.out.print(p.info + " ");
		preorder(p.lchild);
		preorder(p.rchild);
	}

	public void inorder(int[] a) {
		x = 0;
		inorder(root,a);
	}

	private void inorder(TreeNode p,int a[]) {
		if (p == null)
			return;
		inorder(p.lchild,a);
		a[x++]=p.info;
		inorder(p.rchild,a);
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(TreeNode p) {
		if (p == null)
			return;
		postorder(p.lchild);
		postorder(p.rchild);
		System.out.print(p.info + " ");

	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode p) {
		int hL, hR;
		if (p == null)
			return 0;
		hL = height(p.lchild);
		hR = height(p.rchild);
		if (hL > hR)
			return 1 + hL;
		else
			return 1 + hR;
	}

}
