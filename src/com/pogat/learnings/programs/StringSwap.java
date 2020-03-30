package com.pogat.learnings.programs;

public class StringSwap {
	public static void main(String[] args) {
		// String str1 = "good", str2 = "Morning";
		// System.out.println("str1: " + str1 + " Str2: " + str2);
		// str1 = str1 + str2;
		// str2 = str1.substring(0, (str1.length() - str2.length()));
		// str1 = str1.substring(str2.length());
		// System.out.println("str1: " + str1 + " Str2: " + str2);

		/*
		 * int i = 010; int j = 07;
		 * 
		 * System.out.println(i + "      " + j);
		 */
		/*
		 * try { int x = 0; for (x = 1; x < 4; x++) ; System.out.println(x); } catch
		 * (Exception e) { System.out.println("Error____");
		 * 
		 * } finally { System.out.println("Error"); }
		 */
		/*
		 * short s = 9; System.out.println(add(s, 1));
		 */

		/*
		 * int a = 2, b = 3, c = 4, d = 5; System.out.println(- -b * a + c * d--);
		 */

		/*
		 * int result = 0, x = 1; while (x <= 10) { if (x % 2 == 0) result += x; ++x; }
		 * System.out.println(result);
		 */

		// System.out.println(f[0]);

		class Inner {
			Integer i6 = 6, i7 = 7;
			StringSwap ss = new StringSwap();

			Inner() {
				System.out.println("Constructor Inner");
			}

			public void display() {
				System.out.println("public display Inner");
				ss.outMethod1();
			}

			private void displayp() {
				System.out.println("private display Inner");
			}

			protected void displaypr() {
				System.out.println("protected displaypr Inner");
			}
		}

		Inner in = new Inner();
		in.display();
		in.displayp();
		in.displaypr();
		// <<
		Integer i1 = 1;
		Integer i2 = 1;
		Integer i3 = new Integer(i2);
		if (i1 == i2)
			System.out.println("i1==i2: " + true);
		if (i1.equals(i2))
			System.out.println("i1equalsi2: " + true);
		if (i1.equals(i3))
			System.out.println("i1.equals(i3): " + true);
		if (i1 == i3)
			System.out.println("i1 == i3: " + true);
		// >>

	}

	private void outMethod1() {
		System.out.println("outMethod1 Outer");
	}
	// private static float[] f = new float[2];
	/*
	 * public static int add(int i, int j) { return i + j;
	 * 
	 * }
	 */

}
