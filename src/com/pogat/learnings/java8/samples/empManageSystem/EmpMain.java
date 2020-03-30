package com.pogat.learnings.java8.samples.empManageSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}

public class EmpMain {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// 1) How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);
		System.out.println("*************************\n");
		// Print the name of all departments in the organization?
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println("*************************\n");
		// What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemaleEmployees);
		System.out.println("*************************\n");

		// Get the details of highest paid employee in the organization?

		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println("highestPaidEmployee: " + highestPaidEmployee);
		System.out.println("*************************\n");
		// Get the names of all employees who have joined after 2015?
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);
		System.out.println("*************************\n");
		// Count the number of employees in each department?
		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		// alternate way to print
		// employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
		// Collectors.counting())).forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println("employeeCountByDepartment: " + employeeCountByDepartment);
		System.out.println("*************************\n");
		// What is the average salary of each department?
		Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		avgSalaryOfDepartments.forEach((k, v) -> System.out.println("avgSalaryOfDepartments--> " + k + " : " + v));
		System.out.println("*************************\n");
		// Get the details of youngest male employee in the product development
		// department?
		// employeeList.stream().filter(e->e.getGender()=="Male" &amp;&amp;
		// e.getDepartment()=="Product Development"
		// ).min(Comparator.comparingInt(Employee::getAge));

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender() == "Male").filter(e -> e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(
				"youngestMaleEmployeeInProductDevelopment: " + youngestMaleEmployeeInProductDevelopmentWrapper.get());
		System.out.println("*************************\n");
		// Who has the most working experience in the organization?
		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
		System.out.println("seniorMostEmployee: " + seniorMostEmployee);
		System.out.println("*************************\n");
		// How many male and female employees are there in the sales and marketing team?
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
		System.out.println("*************************\n");

		// What is the average salary of male and female employees?
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfMaleAndFemaleEmployees);

		System.out.println("*************************\n");
		// List down the names of all employees in each department?

		Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		employeeListByDepartment.forEach((k, v) -> {
			System.out.println("****" + k + "*****");
			v.forEach(e -> System.out.println(e.getName()));
		});
		// What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
		// summing salary
		Double sumSal = employeeList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
		System.out.println("sumSal: " + sumSal);

	}

}
