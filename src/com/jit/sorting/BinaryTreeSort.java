package com.jit.sorting;

import java.util.Scanner;

public class BinaryTreeSort {
	private BinaryTreeSort() {
	}

	public static void sort(int a[], int n) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < n; i++)
			tree.insert(a[i]);
		tree.inorder(a);
	}

	public static void main(String[] args) {
		int i,n;
		int[] a= new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		n=scan.nextInt();
		for(i=0;i<n;i++) {
			System.out.println("Enter element "+(i+1)+" : ");
			a[i]=scan.nextInt();
		}
		sort(a,n);
		System.out.println("Sorted array is : ");
		for(i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		scan.close();
	}
}
