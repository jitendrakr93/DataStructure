package com.jit.ImplementationofSeparateChainingHashing;

public class HashTable {

	private SingleLinkedList[] array;
	private int m; // size of the array
	int n; // number of records

	public HashTable() {
		this(11);
	}

	public HashTable(int tableSize) {
		m = tableSize;
		array = new SingleLinkedList[m];
	}

	int hash(int key) {
		return (key % m);
	}

	public void displayTable() {
		System.out.println("Number of records = " + n);
		for (int i = 1; i < m; i++) {
			System.out.print("[" + i + "] -----> ");
			if (array[i] != null)
				array[i].displayList();
			else
				System.out.println("________");
		}
	}

	public StudentRecord search(int key) {
		int h = hash(key);
		if (array[h] != null)
			return array[h].search(key);
		return null;
	}

	public void insert(StudentRecord newRecord) {
		int key = newRecord.getStudentId();
		int h = hash(key);
		if (array[h] != null)
			array[h] = new SingleLinkedList();
		array[h].insertInBeginning(newRecord);
		n++;
	}

	public void delete(int key) {
		int h = hash(key);
		if (array[h] != null) {
			array[h].deleteNode(key);
			n--;
		} else {
			System.out.println("value " + key + " not present\n");
		}

	}
}
