package com.jit.heaptree;

import java.util.NoSuchElementException;

public class Heap {
	private int[] a;
	private int n;

	public Heap() {
		a = new int[10];
		n = 0;
		a[0] = 99999;
	}

	public Heap(int maxSize) {
		a = new int[maxSize];
		n = 0;
		a[0] = 99999;
	}

	public void insert(int value) {
		n++;
		a[n] = value;
		restoreUp(n);
	}

	private void restoreUp(int i) {
		int k = a[i];
		int iparent = i / 2;

		while (a[iparent] < k)/* No sentinel : while(iparent>=1 && a[iparent]<k) */
		{
			a[i] = a[iparent];
			i = iparent;
			iparent = i / 2;
		}
		a[i] = k;
	}

	public int deleteRoot() {
		if (n == 0)
			throw new NoSuchElementException("Heap is empty");
		int maxValue = a[1];
		a[1] = a[n];
		n--;
		restoreDown(1);
		return maxValue;
	}

	private void restoreDown(int i) {
		int k = a[i];
		int lChild = 2 * i, rChild = lChild + 1;
		while (rChild <= n) {
			if (k >= a[lChild] && k >= a[rChild]) {
				a[i] = k;
				return;
			} else if (a[lChild] > a[rChild]) {
				a[i] = a[lChild];
				i = lChild;
			} else {
				a[i] = a[rChild];
				i = rChild;
			}
			lChild = 2 * i;
			rChild = lChild + 1;
		}
		/* If Number of node is even */
		if (lChild == n && k < a[lChild]) {
			a[i] = a[lChild];
			i = lChild;
		}
		a[i] = k;
	}
	
	public void display() {
	/*Implement by own*/	
	}
}
