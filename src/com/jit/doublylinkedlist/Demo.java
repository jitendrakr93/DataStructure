package com.jit.doublylinkedlist;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data, x;
		Scanner scan = new Scanner(System.in);
		DoubleLinkedList list = new DoubleLinkedList();
		list.createList();
		while (true) {
			System.out.println("1.Display List");
			System.out.println("2.Insert in empty list");
			System.out.println("3.Insert a node in the beginning of the list");
			System.out.println("4.Insert a node at the end of the list");
			System.out.println("5.Insert a node after a specified node");
			System.out.println("6.Insert a node before a specified node");
			System.out.println("7.Delete first node");
			System.out.println("8.Delete last node");
			System.out.println("9.Delete any node");
			System.out.println("10.Reverse the list");
			System.out.println("11.Quit");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 11)
				break;

			switch (choice) {
			case 1:
				list.displayList();
				break;
			case 2:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				list.insertInEmptyList(data);
				break;
			case 3:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				list.insertInBeginning(data);
				break;
			case 4:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				list.insertAtEnd(data);
				break;
			case 5:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				System.out.println("Enter the element after which to insert : ");
				x=scan.nextInt();
				list.insertAfter(data,x);
				break;
			case 6:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				System.out.println("Enter the element before which to insert : ");
				x=scan.nextInt();
				list.insertBefore(data,x);
				break;
			case 7:
				list.deleteFirstNode();
				break;
			case 8:
				list.deleteLastNode();
				break;
			case 9:
				System.out.println("Enter the element to be deleted : ");
				data = scan.nextInt();
				list.deleteNode(data);
				break;
			case 10:
				list.reverseList();
				break;
			default :
				System.out.println("Wrong choice");
			}
			System.out.println();

		}
		scan.close();
		System.out.println("Exiting");
	}

}
