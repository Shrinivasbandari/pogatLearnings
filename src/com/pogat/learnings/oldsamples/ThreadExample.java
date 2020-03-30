package com.pogat.learnings.oldsamples;

class Old {
	String name;

	synchronized public static void test(String t) {
		try {
			int i = 1;
			while (true) {
				System.out.println(t);
				Thread.sleep(100);
				if (i == 5)
					break;
				i++;
			}
		} catch (Exception e) {

		}
	}

	public void printString(int i) {
		System.out.println("PrintString :" + i);
	}

	synchronized public void test1(String t) {
		try {
			int i = 1;
			while (true) {
				System.out.println(t);
				Thread.sleep(100);
				if (i == 5)
					break;
				i++;
			}
		} catch (Exception e) {

		}
	}
}

public class ThreadExample {

	public static void main(String args[]) {
		Old obj = new Old();
		Old obj2 = new Old();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				obj.test("Thread1");
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				obj.test1("Thread2");
			}
		};
		t1.start();

		t2.start();
		obj.printString(1);
		obj2.printString(2);
	}

}
