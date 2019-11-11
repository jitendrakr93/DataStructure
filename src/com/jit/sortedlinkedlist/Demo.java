package com.jit.sortedlinkedlist;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data;
		Scanner scan = new Scanner(System.in);
		SortedLinkedList list = new SortedLinkedList();
		list.createList();
		while (true) {
			System.out.println("1.Display List");
			System.out.println("2.Insert a node");
			System.out.println("3.Search");
			System.out.println("4.Exit");

			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 4)
				break;

			switch (choice) {
			case 1:
				list.displayList();
				break;
			case 2:
				System.out.println("Enter the element to be inserted : ");
				data = scan.nextInt();
				list.insertInOrder(data);
				break;
			case 3:
				System.out.println("Enter the element to be searched : ");
				data = scan.nextInt();
				list.search(data);
				break;
			default:
				System.out.println("Wrong choice");
			}
			System.out.println();

		}
		scan.close();
		System.out.println("Exiting");
	}

}
