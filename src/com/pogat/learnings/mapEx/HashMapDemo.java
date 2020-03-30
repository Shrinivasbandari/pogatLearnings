package com.pogat.learnings.mapEx;

import java.util.HashMap;
import java.util.WeakHashMap;

public class HashMapDemo {
	public static void main(String args[]) throws Exception {
		hashMapEx();
		WeakHashMapEx();

	}

	public static void hashMapEx() throws Exception {
		System.out.println("hashMapEx has started");
		HashMap m = new HashMap();
		Demo d = new Demo();

		// puts an entry into HashMap
		m.put(d, "Storng Hi ");

		System.out.println(m);
		d = null;

		// garbage collector is called
		System.gc();

		// thread sleeps for 4 sec
		Thread.sleep(4000);
		// we can find that demo object is still exist in hashMap as key i.e demo object
		// ref doesnot garbage collected
		// Even though the object is specified as key in hashmap, it does not have any
		// reference and it is not eligible for garbage collection if it is associated
		// with HashMap i.e. HashMap dominates over Garbage Collector
		System.out.println(m);
		System.out.println("HashMap size: " + m.size());
		System.out.println("hashMapEx has ended");
	}

	// WeakHashMap example
	public static void WeakHashMapEx() throws Exception {
		System.out.println("WeakHashMapEx has started");
		WeakHashMap m = new WeakHashMap();
		Demo d = new Demo();

		// puts an entry into WeakHashMap
		m.put(d, "Weak Hi ");
		System.out.println(m);

		d = null;

		// garbage collector is called
		System.gc();

		// thread sleeps for 4 sec
		Thread.sleep(4000);

		System.out.println(m);
		System.out.println("WeakHashMap size: " + m.size());
		System.out.println("WeakHashMapEx has Ended");
	}
}

class Demo {
	public String toString() {
		return "demo";
	}

	// finalize method
	public void finalize() {
		System.out.println("Finalize method is called");
	}
}
