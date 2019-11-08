package com.jit.singlylinkedlist;

public class ConcatenateDemo {

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();
		System.out.println("Enter first list : ");
		list1.createList();
		System.out.println("Enter second list : ");
		list2.createList();
		System.out.print("First ");
		list1.displayList();
		System.out.print("Second ");
		list2.displayList();
		
		list1.concatenate(list2);
		System.out.print("First ");
		list1.displayList();
	}

}
