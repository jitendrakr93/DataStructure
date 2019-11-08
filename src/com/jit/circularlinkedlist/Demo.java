package com.jit.circularlinkedlist;

import java.util.Scanner;



public class Demo {
	
	public static void main(String[] args) {
		int choice, data, x;
		Scanner scan = new Scanner(System.in);
		CircularLinkedList list = new CircularLinkedList();
		list.createList();
		while (true) {
			System.out.println("1.Display List");
			System.out.println("2.Insert in empty list");
			System.out.println("3.Insert in the beginning");
			System.out.println("4.Insert at the end");
			System.out.println("5.Insert after a node");
			System.out.println("6.Delete first node");
			System.out.println("7.Delete last node");
			System.out.println("8.Delete any node");
			System.out.println("9.Quit");
			

			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 9)
				break;
			
			switch (choice) {
			case 1:
				list.displayList();
				break;
			case 2:
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				list.insertInEmptyList(data);
				break;
			case 3:
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				list.insertInBeginning(data);
				break;
			case 4:
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				list.insertAtEnd(data);
				break;
			case 5:
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				System.out.println("Enter the element after which to insert : ");
				x = scan.nextInt();
				list.insertAfter(data,x);
				break;
			case 6:
				list.deleteFirstNode();
				break;
			case 7:
				list.deleteLastNode();
				break;
			case 8:
				System.out.println("Enter the element to be deleted : ");
				data=scan.nextInt();
				list.deleteNode(data);
				break;
			
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println();

		}
		scan.close();
		System.out.println("Exiting");
	}

}
