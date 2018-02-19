package com.cloudlewis.leetcode250;

/**
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * 
 * @author xiao
 *
 */
// non-negative number, includes 0 and 1
// A prime number is a whole number greater than 1, whose only two whole-number
// factors are 1 and itself. The first few prime numbers are 2, 3, 5, 7, 11, 13,
// 17, 19, 23, and 29.

// Solution 1. brute force?
// brute force has time limit problem
public class CountPrimes204 {
	public int countPrimesDP(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
	
	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
		if (n < 5)
			return 2;
		int count = 2; // include 2, 3
		for (int i=5; i< n; i++) {
			if (i % 2 == 0) // skip entire even number
				continue;
			if (isPrime(i))
				count++;
		}
		return count;
	}
	
	// this won't be called by even number, no need to check 2
	private boolean isPrime(int i) {
		int half = i/2 + 1; // ceil up
		for (int k=3; k<=half; k++)
			if (i % k == 0)
				return false;
		return true;
	}
	
	public static void main(String [] args) {
		CountPrimes204 t = new CountPrimes204();
		System.out.println(t.countPrimes(0));
	}
}
