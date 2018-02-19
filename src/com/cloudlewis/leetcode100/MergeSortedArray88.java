package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author xiao
 *
 */

// given put it in same array, we will need to look at back

public class MergeSortedArray88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0 && j >= 0) {
				if (nums1[i] > nums2[j]) {
					nums1[i + j + 1] = nums1[i];
					i--;
				}
				else {
					nums1[i + j + 1] = nums2[j];
					j--;
				}
			} else if (i >= 0) {
				nums1[i + j + 1] = nums1[i];
				i --;
			}
			else {
				nums1[i + j + 1] = nums2[j];
				j--;
			}
		}
	}
	
	public static void main(String [] args) {
		MergeSortedArray88 t = new MergeSortedArray88();
		int[] nums1 = new int[] {1,3,5,7,-1,-1,-1,-1};
		int[] nums2 = new int[] {0};
		t.merge(nums1, 4, nums2, 1);
		Util.printArray(nums1);
	}
}
