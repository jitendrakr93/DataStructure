package com.jit.stackusingarray;

import java.util.EmptyStackException;

public class StackA {
	private int stackArray[];
	private int top;

	public StackA() {
		stackArray = new int[10];
		top = -1;
	}

	public StackA(int maxSize) {
		stackArray = new int[maxSize];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == stackArray.length - 1);
	}

	public void push(int x) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		top = top + 1;
		stackArray[top] = x;
	}

	public int pop() {
		int x;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}
		x = stackArray[top];
		top = top - 1;
		return x;
	}

	public int peek() {
		int x;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}

	public void display() {
		int i;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Stack is : ");
		for (i = top; i >= 0; i--) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

}
