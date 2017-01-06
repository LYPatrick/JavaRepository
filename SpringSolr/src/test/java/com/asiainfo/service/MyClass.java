package com.asiainfo.service;

public class MyClass {
	private static int num = 0;
	private static int getNum(){
		num += 1;
		return num;
	}
	
	public static int getNum1(){
		num += 1;
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(getNum());
		System.out.println(getNum());
	}
}
