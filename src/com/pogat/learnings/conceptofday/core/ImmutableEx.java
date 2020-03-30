package com.pogat.learnings.conceptofday.core;

public final class ImmutableEx {
	private final String name;
	private B b;

	ImmutableEx(String name, B b) {
		this.name = name;
		this.b = b;
	}

	public B getB() throws CloneNotSupportedException {
		return b.clone();
	}

	public String getName() {
		return name;
	}

	protected ImmutableEx clone() throws CloneNotSupportedException {

		return (ImmutableEx) super.clone();
	}

	public static void main(String[] args) {
		B b1 = new B();

	}

}

class B {
	public int id;

	protected B clone() throws CloneNotSupportedException {
		return (B) super.clone();
	}

}
