package com.pogat.learnings.eTag;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.databind.ObjectMapper;

class Persion {
	private int id;
	private String name;

	Persion(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
// we can use this logic whether the object is a latest version or not ?

public class GenETag {

	public static void main(String[] args) {
		Persion p = new Persion(1, "Shrini");

		System.out.println("Etag before the object state change: " + getEtag(p));
		p.setName("Shrinivas");
		System.out.println("Etag after  the object state change: " + getEtag(p));
	}

	private static String getResourceJsonString(Object object) {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(object);
			System.out.println("json from ObjectMapper: " + json);
		} catch (Exception e) {
			System.out.println("Unable convert resource object into JSON string" + e.getMessage());
		}
		return json;
	}

	private static String generateEtag(String input) {
		String hashtext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Unable to generate eTag for resource " + e.getMessage());

		}
		return hashtext;
	}

	public static String getEtag(Object object) {
		String objectJSONString = getResourceJsonString(object);
		return generateEtag(objectJSONString);
	}

}
