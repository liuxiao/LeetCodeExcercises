package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode50.NextPermutation31;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * @formatter:off
 * 1 : "123" 
 * 2 : "132" 
 * 3 : "213" 
 * 4 : "231" 
 * 5 : "312" 
 * 6 : "321" 
 * @formatter:on
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author xiao
 *
 */

// solution 1. get all permutations, in increasing order, and stop when we hit
// kth

// solution 2. make a initial minimum integer, and keep calling next
// permutation();

// solution 3. find the pattern of kth looks like and construct
// https://leetcode.com/problems/permutation-sequence/#/solutions


public class PermutationSequence60 {

	// solution 3
	public String getPermutation(int n, int k) {
		int[] factorial = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			factorial[i] = sum;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}
		
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i =1; i<=9 ;i++)
			numbers.add(i);
		
		k--; //first always unchange
		
		for (int i=1; i<=n; i++) {
			int idx = k/factorial[n-1]; //factorial -> number of digits
			sb.append(numbers.get(idx));
			numbers.remove(idx);
			k -= (idx * factorial[n-1]);
		}
		return sb.toString();
	}

	// tou lan solution #2
	public String getTouLanPermutation(int n, int k) {
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++)
			nums[i - 1] = i;
		NextPermutation31 np = new NextPermutation31();
		while (k > 1) {
			np.nextPermutation(nums);
			k--;
		}
		StringBuilder str = new StringBuilder();
		for (int i : nums)
			str.append(i);
		return str.toString();
	}

	public static void main(String[] args) {
		PermutationSequence60 t = new PermutationSequence60();
		System.out.println(t.getTouLanPermutation(3, 5));
		System.out.println(t.getPermutation(3, 5));
	}

}
