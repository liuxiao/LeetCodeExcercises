package com.cloudlewis.leetcode.basic;

import java.math.BigInteger;

public class KaratsubaMultiply {

	/*
	 * @formatter:off
	 * Master algorithm is 10^n*ac + 10^(n/2)*(ac+bd) + db
	 * where ac+bd = (a+b)*(c+d) - ac - db
	 * 
	 * @formatter:on
	 */
	public static long multiply(long num1, long num2) {
		if (num1 < 10 || num2 < 10)
			return num1 * num2;
		long count1 = numOfDigits(num1), count2 = numOfDigits(num2);
		long m = Math.max(count1, count2);
		long m2 = m / 2;
		long commonDivider = (long) Math.pow(10, m2);
		long a = (long) (num1 / commonDivider); // high1
		long b = (long) (num1 % commonDivider); // high 2
		long c = (long) (num2 / commonDivider);
		long d = (long) (num2 % commonDivider);

		long ac = multiply(a, c);
		long bd = multiply(b, d);
		long acdb = multiply(a + b, c + d) - ac - bd;

		return (long) (ac * Math.pow(10, m2 * 2) + Math.pow(10, m2) * acdb + bd);
	}

	private static long numOfDigits(long num) {
		long d = 0;
		while (num > 0) {
			num /= 10;
			d++;
		}
		return d;
	}

	public static BigInteger multiply(BigInteger x, BigInteger y) {

		// cutoff to brute force
		int N = Math.max(x.bitLength(), y.bitLength());
		if (N <= 2000)
			return x.multiply(y); // optimize this parameter

		// number of bits divided by 2, rounded up
		N = (N / 2) + (N % 2);

		// x = a + 2^N b, y = c + 2^N d
		BigInteger b = x.shiftRight(N);
		BigInteger a = x.subtract(b.shiftLeft(N));
		BigInteger d = y.shiftRight(N);
		BigInteger c = y.subtract(d.shiftLeft(N));

		// compute sub-expressions
		BigInteger ac = multiply(a, c);
		BigInteger bd = multiply(b, d);
		BigInteger abcd = multiply(a.add(b), c.add(d));

		return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
	}

	public static void main(String[] args) {
		System.out.println(1234 * 5678);
		System.out.println(KaratsubaMultiply.multiply(1234, 5678));
		System.out.println(KaratsubaMultiply.multiply(new BigInteger("1234"), new BigInteger("5678")).toString());
		System.out
				.println(KaratsubaMultiply
						.multiply(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),
								new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"))
						.toString());
	}
}
