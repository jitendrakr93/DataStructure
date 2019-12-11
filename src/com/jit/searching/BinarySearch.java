package com.jit.searching;

import java.util.Scanner;

public class BinarySearch {
	private BinarySearch() {
	}

	public static int search(int[] a, int n, int searchValue) {
		int first = 0, last = n - 1, mid;
		while (first <= last) {
			mid = (first + last) / 2;
			if (searchValue < a[mid])
				last = mid - 1;/*Search in the left half*/
			else if (searchValue > a[mid])
				first = mid + 1;/*Search in the right half*/
			else
				return mid;/*Search value present at index mid*/
		}
		return -1;
	}

	public static void main(String[] args) {
		int i, n, searchValue, index;
		int a[] = new int[100];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		n = scan.nextInt();
		System.out.println("Enter the elements in sorted order: ");
		for (i = 0; i < n; i++)
			a[i] = scan.nextInt();
		System.out.println("Enter the search value : ");
		searchValue = scan.nextInt();
		index = search(a, n, searchValue);
		if (index == -1)
			System.out.println("Value " + searchValue + " not present in the array.");
		else
			System.out.println("Value " + searchValue + " present at the index " + index);
	}
}
