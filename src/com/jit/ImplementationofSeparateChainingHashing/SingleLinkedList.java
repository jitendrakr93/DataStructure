package com.jit.ImplementationofSeparateChainingHashing;

import java.util.Scanner;

public class SingleLinkedList {

	public Node start;

	public SingleLinkedList() {
		start = null;
	}

	public void displayList() {
		Node p;
		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("List is : ");
		p = start;
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public StudentRecord search(int x) {
		Node p = start;

		while (p != null) {
			if (p.info.getStudentId() == x)
				break;
			p = p.link;
		}
		if (p == null) {
			System.out.println(x + " not found in list");
			return null;
		} else {
			return p.info;
		}
	}

	public void insertInBeginning(StudentRecord data) {
		Node temp = new Node(data);
		temp.link = start;
		start = temp;
	}

	public void deleteNode(int x) {
		if (start == null) {
			System.out.println("List is empty\n");
			return;
		}
		/* Deletion of first node */
		if (start.info.getStudentId() == x) {
			start = start.link;
			return;
		}
		/* Deletion in between or at the end */
		Node p = start;
		while (p.link != null) {
			if (p.link.info.getStudentId() == x)
				break;
			p = p.link;
		}

		if (p.link == null)
			System.out.println("Elemnet " + x + " is not in list");
		else
			p.link = p.link.link;
	}

}
