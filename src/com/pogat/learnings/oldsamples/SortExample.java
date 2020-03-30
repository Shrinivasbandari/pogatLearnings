package com.pogat.learnings.oldsamples;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

class Employee1 implements Comparable {
	String name;
	String address;

	Employee1(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(((Employee1) arg0).name);
	}

}

class NameComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return ((Employee1) arg0).name.compareTo(((Employee1) arg1).name);
	}

}

class AddressComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return ((Employee1) arg0).address.compareTo(((Employee1) arg1).address);
	}

}

public class SortExample {
	public static void main(String args[]) {
		/*
		 * ArrayList<Employee> al = new ArrayList<Employee>(); al.add(new
		 * Employee("srinu","Banglore")); al.add(new Employee("kiran","Hyd"));
		 * Collections.sort(al,new AddressComparator()); for(Employee e: al)
		 * System.out.println(e.name+","+e.address);
		 */
		TreeMap<Employee1, String> map = new TreeMap<Employee1, String>(new NameComparator());
		// TreeMap<Employee, String> map = new TreeMap<Employee,String>();
		map.put(new Employee1("srinu", "Banglore"), null);
		map.put(new Employee1("kiran", "Hyd"), null);
		Set<Employee1> set = map.keySet();
		for (Employee1 e : set) {
			System.out.println(e.name);
		}
	}
}
