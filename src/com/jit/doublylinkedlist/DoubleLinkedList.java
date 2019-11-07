package com.jit.doublylinkedlist;

public class DoubleLinkedList {
	private Node start;

	public DoubleLinkedList() {
		start = null;
	}

	public void displayList() {
		Node p;
		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		p = start;
		System.out.println("List is :\n");
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		
	}
	
}
