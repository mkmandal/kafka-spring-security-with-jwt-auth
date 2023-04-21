package com.manoj.spring.cloud.utility;

import java.util.HashSet;

public class Recursion {

	static int sum = 0;
	static int fact = 0;
	static int i = 0;

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter Number");
		// int num = sc.nextInt();

		// recursion(num);
		// System.out.println("sum is == " + factorialUsingRecursion(num));

		// System.out.println("sum is == " + factorialUsingRecursion(num));

		// System.out.println(isPalindrome("MADAMS"));

		//System.out.println(fibbonacciNumber(8));
		hashSet();

	}

	private static void recursion(int i) {

		if (i < 1) {
			return;
		}

		int j = i - 1;
		System.out.println(i);
		recursion(j);

	}

	private static int factorialUsingRecursion(int i) {

		if (i == 0) {
			return 1;
		}

		if (i > 0) {
			fact = i * factorialUsingRecursion(i - 1);
			// factorialUsingRecursion(i-1);
		}

		return fact;

	}

	private static int sumUsingRecursion(int i) {

		if (i == 0) {
			return 1;
		}

		if (i > 0) {
			sum = i + factorialUsingRecursion(i - 1);
			// factorialUsingRecursion(i-1);
		}

		return sum;

	}

	private static boolean isPalindrome(String s) {

		char ch[] = s.toCharArray();
		int size = s.length();
		if (i >= size / 2) {
			return true;
		}
		if (ch[i] != ch[size - i - 1]) {
			return false;
		}
		i++;
		return isPalindrome(s);
	}

	private static int fibbonacciNumber(int num) {

		if (num <= 1) {
			return num;
		}

		int last = fibbonacciNumber(num - 1);
		int slast = fibbonacciNumber(num - 2);

		return last + slast;
	}
	
	private static void hashSet() {
		 HashSet<Integer> data= new HashSet<Integer>(6);
		 
		 data.add(5);
		 System.out.println(data);
		
	}
}
