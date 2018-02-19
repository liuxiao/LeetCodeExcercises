package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.Util;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 * 
 * @author xiao
 * 
 *         2, 3, 4, 1
 * 
 *         4, 3, 2, 2
 */

// @formatter:off
//                 i
// case   [1,2,3,4,5]
// pass 1: 1,2,3,5,4 -- swap when break ascending order, no reverse
//
// case   [1,5,4,3,2]
// pass 1: 2,5,4,3,1 ---swap, because in ascending order every element is greater than i
//                   ---therefore, after swap, i is still the samllest
// pass 2: 2,1,3,4,5 ---reverse, from swapped location + 1 to swapped location
//
//           i
// case   [1,3,5,4,2]
// pase 1: 1,3,5,4,2 ---stop at i, where the chain break
//                   ---from back and find greater than i, swapped
// pase 2: 1,4,5,3,2 ---reverse from swapped location + 1 (i+1) to "the end", last elem is the min
// @formatter:on

public class NextPermutation31 {
	public void nextPermutation(int[] nums) {
		int len = nums.length, i = len - 2, j = len - 1;
		for (; i >= 0; i--)
			if (nums[i] < nums[i + 1]) // from len -1
				break;
		// if i == 0, then reverse entire string, done
		if (i >= 0) { // previous search guarantee is it asc order
			while (j >= 0 && nums[j] <= nums[i])
				j--;
			swap(nums, i, j);
		}
		reverse(nums, i + 1, len - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int m, int n) {
		int tmp = nums[m];
		nums[m] = nums[n];
		nums[n] = tmp;
	}

	public static void main(String[] args) {
		NextPermutation31 t = new NextPermutation31();

		int[] a = { 1, 2, 3 }; // 1,3,2
		t.nextPermutation(a);
		Util.printArray(a);
		
		int[] e = { 1, 3, 2 }; // 2,1,3
		t.nextPermutation(e);
		Util.printArray(e);

		int[] b = { 2, 1, 3 }; // 2,3,1
		t.nextPermutation(b);
		Util.printArray(b);
		
		int[] d = { 1,3,5,4,2 }; // 1,4,2,3,5
		t.nextPermutation(d);
		Util.printArray(d);

		int[] c = { 3, 2, 1 }; // 1,2,3
		t.nextPermutation(c);
		Util.printArray(c);
	}
}
