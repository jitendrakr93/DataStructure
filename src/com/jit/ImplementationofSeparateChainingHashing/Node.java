package com.jit.ImplementationofSeparateChainingHashing;

public class Node {
	public StudentRecord info;
	public Node link;
	
	public Node(StudentRecord rec) {
		info = rec;
		link = null;
	}
}
