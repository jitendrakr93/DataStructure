package com.jit.queueusingarray;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, x;
		Scanner scan = new Scanner(System.in);
		QueueA qu = new QueueA(8);

		while (true) {
			System.out.println("1.Insert an element on the queue");
			System.out.println("2.Delete an element from the queue");
			System.out.println("3.Display the element at the front");
			System.out.println("4.Display all elements of the queue");
			System.out.println("5.Display size of the queue");
			System.out.println("6.Quit");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 6) {
				break;
			}
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be pushed : ");
				x = scan.nextInt();
				qu.insert(x);
				break;
			case 2:
				x = qu.delete();
				System.out.println("Deleted element is : " + x);
				break;
			case 3:
				System.out.println("Element at the top is : " + qu.peek());
				break;
			case 4:
				qu.display();
				break;
			case 5:
				System.out.println("Size of stack is : " + qu.size());
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
			System.out.println();
		}
		scan.close();

	}

}
