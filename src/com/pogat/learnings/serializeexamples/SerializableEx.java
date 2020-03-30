package com.pogat.learnings.serializeexamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NonSerial {
	public int a = 0;
}

class Serial2 extends NonSerial implements Serializable {
	public int a2 = 2;
}

class Serial1 extends Serial2 {
	public int a1 = 1;
}

public class SerializableEx extends Serial1 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		SerializableEx c = new SerializableEx();

		try {
			c.a1 = 1223;
			c.a2 = 1223;
			c.a = 1223;
			FileOutputStream fs = new FileOutputStream("/Users/nisum/test1.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream("/Users/nisum/test1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SerializableEx cc = (SerializableEx) ois.readObject();
			System.out.println("c0:" + cc.a + "\nc1:" + cc.a1 + "\nc2:" + cc.a2);
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}