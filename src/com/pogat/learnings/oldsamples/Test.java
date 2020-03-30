package com.pogat.learnings.oldsamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Employee {
	private String name;
	private int age;
	File empFile;

	Employee(String name, int age, String empFile) throws IOException {
		this.name = name;
		this.age = age;
		this.empFile = new File(empFile);
		// cyclic object creation
		// Employee emp = new Employee("Krishna", 25, empFile);
		new FileWriter(empFile).write("Employee name is " + name + "and age is " + age);
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

public class Test {
	// if we remove throws Exception... we cann't create Employee object
	public static void main(String args[]) throws Exception {
		String filePath = "samplefile.txt";
		System.out.println("********1***********");
		Employee emp = new Employee("Krishna", 25, filePath);
		System.out.println("********2***********");
		emp.display();
	}
}
