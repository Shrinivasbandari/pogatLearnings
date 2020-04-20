package com.pogat.learnings.programs;

public class ReverseInteger {
 public static void main(String[] args) {
	 
	 reverseAnumber();
	  
 }
 
 
 public static void reverseAnumber() {
	 int num =3456;
	 int rev_num=0;
	 while(num>0) {
		 rev_num = rev_num*10+num%10;
		 num =num/10;
	 }
	 System.out.println("rev_num: "+rev_num);	
	 
 }
}
