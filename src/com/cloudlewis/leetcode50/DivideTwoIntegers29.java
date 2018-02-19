package com.cloudlewis.leetcode50;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author xiao
 *
 */

// can only use + and -; asking how could it overflow? unless, divisor is 0
// dividend / divisor
// can be negative value

// !!! this does not work for big number
// !!! need to use bit operation
public class DivideTwoIntegers29 {
	public int divide(int dividend, int divisor) {
		boolean nega = (dividend > 0 ^ divisor > 0);
		if (divisor == 1)
			return dividend;
		if (divisor == 0 || (divisor == -1  && dividend == Integer.MIN_VALUE) )
			return Integer.MAX_VALUE;
		if (divisor < 0)
			divisor = -divisor;
		if (dividend < 0)
			dividend = -dividend;
		if (dividend == 0 || dividend < divisor)
			return 0;
		

		int rs = 1;
		int sum = divisor;
		while (sum <= dividend) {
			sum += divisor;
			rs++;
		}
		if (nega)
			return -rs + 1;
		return rs - 1;
	}
	
	
	public int divideOpt(int dividend, int divisor) {
		boolean nega = (dividend > 0 ^ divisor > 0);
		if (divisor == 1)
			return dividend;
		if (divisor == 0 || (divisor == -1  && dividend == Integer.MIN_VALUE) )
			return Integer.MAX_VALUE;
		if (divisor < 0)
			divisor = -divisor;
		if (dividend < 0)
			dividend = -dividend;
		if (dividend == 0 || dividend < divisor)
			return 0;
		

		int rs = 1;
		int sum = divisor;
		while (sum <= dividend) {
			sum += sum;
			rs+=rs;
		}
		// let sum grow exponentially
		// trace back for the right answer
		while (sum > dividend) {
			sum -= divisor;
			rs--;
		}
		
		if (nega)
			return -rs + 1;
		return rs - 1;
	}

	public static void main(String[] args) {
		DivideTwoIntegers29 t = new DivideTwoIntegers29();
		System.out.println(t.divide(10, 3));
		System.out.println(t.divide(12, 3));
		System.out.println(t.divide(112344, 33));
		System.out.println(t.divide(22, -7));
		System.out.println(t.divide(-7, -2));
		System.out.println(t.divide(-1, 1));
		System.out.println(t.divide(2147483647, 2));
	}
}
