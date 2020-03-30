package com.pogat.learnings.oldsamples;

import java.util.HashMap;

class Name {
	String name;

	Name(String name) {
		this.name = name;
	}
	/*
	 * @Override public int hashCode(){ //return this.name.hashCode(); return 1; }
	 * 
	 * @Override public boolean equals(Object o){ return
	 * this.name.equals(((Name)o).name); }
	 */
}

public class HashMapExample {
	public static void main(String args[]) {
		HashMap map = new HashMap();
		for (int i = 0; i < 10; i++) {
			map.put(new Name("kiran"), null);
			// mapput(new Name("kiran"),null);
		}
		System.out.println(map.size());
	}
}
