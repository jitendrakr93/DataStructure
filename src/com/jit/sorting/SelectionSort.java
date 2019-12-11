package com.jit.sorting;

import java.util.Scanner;

public class SelectionSort {
	private SelectionSort() {
	}

	public static void sort(int a[], int n) {
		int midIndex, temp, i, j;
		for (i = 0; i < n - 1; i++) {
			midIndex = i;
			for (j = i + 1; j < n; j++) {
				if (a[j] < a[midIndex])
					midIndex = j;
			}
			if (i != midIndex) {
				temp = a[i];
				a[i] = a[midIndex];
				a[midIndex] = temp;
			}

		}
	}

	public static void main(String[] args) {
		int i, n;
		int a[] = new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		n = scan.nextInt();

		for (i = 0; i < n; i++) {
			System.out.println("Enter the elements " + (i + 1) + " :");
			a[i] = scan.nextInt();
		}
		sort(a, n);
		System.out.println("Sorted array is : ");
		for (i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		scan.close();
	}

}
