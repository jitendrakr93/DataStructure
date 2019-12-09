package com.jit.ImplementationofOpeAddressingHashing2;

public class StudentRecord {
	private int studentId;
	private String studentName;

	public StudentRecord(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String toString() {
		return studentId + "  " + studentName;
	}

}
