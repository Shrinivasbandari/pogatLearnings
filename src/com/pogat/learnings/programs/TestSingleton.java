package com.pogat.learnings.programs;

import java.lang.reflect.Constructor;

class Singleton implements Cloneable {
	private static Singleton soleInstance = new Singleton();

	private Singleton() {
		if (soleInstance != null) {
			throw new RuntimeException("please create a instance with getInstance");
		}
		System.out.println("constructing");
	}

	public static Singleton getInstance() {
		return soleInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class TestSingleton {

	public static void main(String[] args) throws Exception {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		print("s1", s1);
		print("s2", s2);

		// Reflection
		Class clazz = Class.forName("com.pogat.programs.Singleton");
		Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);
		Singleton s3 = ctor.newInstance();
		print("s3", s3);
	}

	private static void print(String name, Singleton object) {
		System.out.println(String.format("Singleton : %s, Hashcode : %d", name, object.hashCode()));
	}
}