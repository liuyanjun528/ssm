package com.springboot.utils;

public class MyClassLoader {
	
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(int.class.getClassLoader());


	}

}
