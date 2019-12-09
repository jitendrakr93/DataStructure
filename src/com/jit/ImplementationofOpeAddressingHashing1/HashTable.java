package com.jit.ImplementationofOpeAddressingHashing1;

public class HashTable {

	private StudentRecord[] array;
	private int m; // size of the array
	int n; // number of records

	public HashTable() {
		this(11);
	}

	public HashTable(int tableSize) {
		m = tableSize;
		array = new StudentRecord[m];
		n = 0;
	}

	int hash(int key) {
		return (key % m);
	}

	public void insert(StudentRecord newRecord) {
		int key = newRecord.getStudentId();
		int h = hash(key);
		int location = h;
		for (int i = 1; i < m; i++) {
			if (array[location] == null || array[location].getStudentId() == -1) {
				array[location] = newRecord;
				n++;
				return;
			}
			if (array[location].getStudentId() == key)
				throw new UnsupportedOperationException("Duplicate Key");
			location = (h + i) % m;
		}
		System.out.println("Table is full : Record can't be inserted");
	}

	public StudentRecord search(int key) {
		int h = hash(key);
		int location = h;
		for (int i = 1; i < m; i++) {
			if (array[location] == null)
				return null;
			if (array[location].getStudentId() == key)
				return array[location];
			location = (h + i) % m;
		}
		return null;
	}

	public void displayTable() {
		for (int i = 1; i < m; i++) {
			System.out.print("[" + i + "] -----> ");
			if (array[i] != null && array[i].getStudentId() != -1)
				System.out.println(array[i]);
			else
				System.out.println("________");
		}
	}
	
	public StudentRecord delete(int key) {
		int h = hash(key);
		int location = h;
		for (int i = 1; i < m; i++) {
			if (array[location] == null)
				return null;
			if (array[location].getStudentId() == key) {
				StudentRecord temp = array[location];
				array[location].setStudentId(-1);
				n--;
				return temp;
			}
			location = (h + i) % m;
		}
		return null;
	}
}
