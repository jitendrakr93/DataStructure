package com.jit.ImplementationofOpeAddressingHashing2;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int id, choice;
		String name;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter initial size of table : ");
		int size = scan.nextInt();
		HashTable table = new HashTable(size);
		while (true) {
			System.out.println("1.Insert a record");
			System.out.println("2.Search a record");
			System.out.println("3.Delete a record");
			System.out.println("4.Display table");
			System.out.println("5.Exit");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			if (choice == 5)
				break;
			switch (choice) {
			case 1:
				System.out.println("Enter student id : ");
				id = scan.nextInt();
				System.out.println("Enter student name : ");
				name = scan.next();
				StudentRecord aRecord = new StudentRecord(id, name);
				table.insert(aRecord);
				break;
			case 2:
				System.out.println("Enter a key to be searched : ");
				id = scan.nextInt();
				aRecord = table.search(id);
				if (aRecord == null)
					System.out.println("Key is not found");
				else
					System.out.println(aRecord);
				break;
			case 3:
				System.out.println("Enter a key to be deleted : ");
				id = scan.nextInt();
				table.delete(id);
				break;
			case 4:
				table.displayTable();
				break;
			}
		}
		scan.close();
	}

}
