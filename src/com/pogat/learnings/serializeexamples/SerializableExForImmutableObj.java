package com.pogat.learnings.serializeexamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

final class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int id;

	Emp(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}

public class SerializableExForImmutableObj {

	public static void main(String[] args) {

		SerializableExForImmutableObj c = new SerializableExForImmutableObj();

		Emp emp = new Emp(20);

		try {

			FileOutputStream fs = new FileOutputStream("/Users/nisum/test1.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(emp);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream("/Users/nisum/test1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Emp cc = (Emp) ois.readObject();
			System.out.println("c0:" + cc.getId());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}