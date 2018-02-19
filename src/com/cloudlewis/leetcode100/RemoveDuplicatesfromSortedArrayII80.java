package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.Util;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author xiao
 *
 */

// sorted array, same conpcet, having one pointer keep actual place
public class RemoveDuplicatesfromSortedArrayII80 {
	public int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII80 t = new RemoveDuplicatesfromSortedArrayII80();
		int[] arr = new int[] { 1, 1, 1, 2, 2, 2, 3 };
		System.out.println(t.removeDuplicates(arr));
		Util.printArray(arr);
	}
}
