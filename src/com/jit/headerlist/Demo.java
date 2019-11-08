package com.jit.headerlist;

import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {
		int choice, data, x,k;
		Scanner scan = new Scanner(System.in);
		HeaderList list = new HeaderList();
		while (true) {
			System.out.println("1.Display List");
			System.out.println("2.Insert a node at the end of the list");
			System.out.println("3.Insert a node before a  node");
			System.out.println("4.Insert at a given position");
			System.out.println("5.Delete a node");
			System.out.println("6.Reverse the list");
			System.out.println("7.Quit");
			
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 7)
				break;

			switch (choice) {
			case 1:
				list.displayList();
				break;
			case 2:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				list.insertAtEnd(data);
				break;
			case 3:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				System.out.println("Enter the element before which to insert : ");
				x=scan.nextInt();
				list.insertBefore(data,x);
				break;
			case 4:
				System.out.println("Enter the element to be inserted : ");
				data=scan.nextInt();
				System.out.println("Enter the position at which to insert : ");
				x=scan.nextInt();
				list.insertAtPosition(data, x);
				break;
			case 5:
				System.out.println("Enter the element to be deleted : ");
				data=scan.nextInt();
				list.deleteNode(data);
				break;
			case 6:
				list.reverse();
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
