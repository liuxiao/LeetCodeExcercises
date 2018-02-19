package com.cloudlewis.leetcode.basic;

public class Fibonacci {

	public int getF(int num) {
		if (num < 0)
			return 0;
		else if (num == 1 || num == 2)
			return 1;
		return getF(num - 1 ) + getF(num -2);
	}
	
	public int getFDP(int num) {
		int num1 = 1, num2 = 1;
		while( num > 1) {
			int tmp = num2;
			num2 += num1;
			num1 = tmp;
			num--;
		}
		return num1;
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.getF(1));
		System.out.println(f.getF(2));
		System.out.println(f.getF(3));
		System.out.println(f.getF(4));
		System.out.println(f.getF(5));
		System.out.println(f.getF(6));
		System.out.println(f.getF(7));
		System.out.println(f.getF(24));
		
		System.out.println(f.getFDP(6));
		System.out.println(f.getFDP(24));
	}
}
