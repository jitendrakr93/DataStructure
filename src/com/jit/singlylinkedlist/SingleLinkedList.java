package com.jit.singlylinkedlist;

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

	public void countNodes() {
		int n = 0;
		Node p = start;
		while (p != null) {
			n++;
			p = p.link;
		}
		System.out.println("Number of nodes in the List = " + n);
	}

	public boolean search(int x) {
		Node p;
		int position = 1;
		p = start;

		while (p != null) {
			if (p.info == x)
				break;
			position++;
			p = p.link;
		}
		if (p == null) {
			System.out.println(x + " not found in list");
			return false;
		} else {
			System.out.println(x + " is at position " + position);
			return true;
		}
	}

	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.link = start;
		start = temp;
	}

	public void insertAtEnd(int data) {
		Node p;
		Node temp = new Node(data);

		if (start == null) {
			start = temp;
			return;
		}
		p = start;
		while (p.link != null)
			p = p.link;
		p.link = temp;
	}

	public void createList() {
		int i, n, data;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of nodes : ");
		n = scan.nextInt();
		if (n == 0)
			return;
		for (i = 1; i <= n; i++) {
			System.out.println("Enter the element to be inserted : ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
	}

	public void inserAfter(int data, int x) {
		Node p = start;
		while (p != null) {
			if (p.info == x)
				break;
			p = p.link;
		}
		if (p == null)
			System.out.println(x + " not present in the list");
		else {
			Node temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}
	}

	public void insertBefore(int data, int x) {
		Node temp;

		/* If List is empty */
		if (start == null) {
			System.out.println("List is empty");
			return;
		}

		/* x is in first node, new node is to be inserted before first node */
		if (x == start.info) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}
		/* find reference to predecessor of node containing x */
		Node p = start;
		while (p.link != null) {
			if (p.link.info == x)
				break;
			p = p.link;
		}
		if (p.link == null) {
			System.out.println(x + " not present in list");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void insertAtPosition(int data, int k) {
		Node temp;
		int i;
		if (k == 1) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}
		Node p = start;
		for (i = 1; i < k - 1 && p != null; i++) /* find a reference to k-1 node */
			p = p.link;
		if (p == null)
			System.out.println("You can insert only upto " + i + " th position");
		else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void deleteFirstNode() {
		if (start == null)
			return;
		start = start.link;
	}

	public void deleteLastNode() {
		if (start == null)
			return;
		if (start.link == null) {
			start = null;
			return;
		}
		Node p = start;
		while (p.link.link != null)
			p = p.link;
		p.link = null;
	}

	public void deleteNode(int x) {
		if (start == null) {
			System.out.println("List is empty\n");
			return;
		}
		/* Deletion of first node */
		if (start.info == x) {
			start = start.link;
			return;
		}
		/* Deletion in between or at the end */
		Node p = start;
		while (p.link != null) {
			if (p.link.info == x)
				break;
			p = p.link;
		}

		if (p.link == null)
			System.out.println("Elemnet " + x + " is not in list");
		else
			p.link = p.link.link;
	}

	public void reverseList() {
		Node prev, p, next;
		prev = null;
		p = start;
		while (p != null) {
			next = p.link;
			p.link = prev;
			prev = p;
			p = next;
		}
		start = prev;
	}

	public void BubbleSortExData() {
		Node end, p, q;
		for (end = null; end != start.link; end = p) {
			for (p = start; p.link != end; p = p.link) {
				q = p.link;
				if (p.info > q.info) {
					int temp = p.info;
					p.info = q.info;
					q.info = temp;
				}
			}
		}
	}

	public void BubbleSortExLinks() {
		Node end, r, p, q, temp;
		for (end = null; end != start.link; end = p) {
			for (r = p = start; p.link != end; r = p, p = p.link) {
				q = p.link;
				if (p.info > q.info) {
					p.link = q.link;
					q.link = p;
					if (p != start) {
						r.link = q;
					} else {
						start = q;
					}
					temp = p;
					p = q;
					q = temp;
				}
			}
		}
	}

	public SingleLinkedList merge1(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = merge1(start, list.start);
		return mergeList;

	}

	private Node merge1(Node p1, Node p2) {
		Node startM;
		if (p1.info <= p2.info) {
			startM = new Node(p1.info);
			p1 = p1.link;
		} else {
			startM = new Node(p2.info);
			p2 = p2.link;
		}
		Node pM = startM;
		while (p1 != null && p2 != null) {
			if (p1.info <= p2.info) {
				pM.link = new Node(p1.info);
				p1 = p1.link;
			} else {
				pM.link = new Node(p2.info);
				p2 = p2.link;
			}
			pM = pM.link;
		}
		/* If Second list has finished and elements left in the first list */
		while (p1 != null) {
			pM.link = new Node(p1.info);
			p1 = p1.link;
			pM = pM.link;
		}

		/* If first list has finished and elements left in the second list */
		while (p2 != null) {
			pM.link = new Node(p2.info);
			p2 = p2.link;
			pM = pM.link;
		}
		return startM;
	}

	public SingleLinkedList merge2(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = merge2(start, list.start);
		return mergeList;

	}

	private Node merge2(Node p1, Node p2) {
		Node startM;
		if (p1.info <= p2.info) {
			startM = p1;
			p1 = p1.link;
		} else {
			startM = p2;
			p2 = p2.link;
		}
		Node pM = startM;
		while (p1 != null && p2 != null) {
			if (p1.info <= p2.info) {
				pM.link = p1;
				pM = pM.link;
				p1 = p1.link;
			} else {
				pM.link = p2;
				pM = pM.link;
				p2 = p2.link;
			}

		}
		if (p1 == null)
			pM.link = p2;
		else
			pM.link = p1;
		return startM;
	}

}
