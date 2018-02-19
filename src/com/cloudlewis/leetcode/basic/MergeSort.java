package com.cloudlewis.leetcode.basic;

import com.cloudlewis.leetcode.common.Util;

public class MergeSort {
	public static void sort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}

	private static void mergeSort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		merge(nums, left, mid, right);
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int l = 0, r = 0;
		int m = mid - left + 1, n = right - mid;
		while (l < m && r < n) {
			if (nums[left + l] <= nums[mid + 1 + r]) {
				tmp[l + r] = nums[left + l];
				l++;
			} else {
				tmp[l + r] = nums[mid + 1 + r];
				r++;
			}
		}
		while (l < m) {
			tmp[l + r] = nums[l + left];
			l++;
		}
		while (r < n) {
			tmp[l + r] = nums[r + mid + 1];
			r++;
		}
		// copy tmp back
		for (int i = 0; i < tmp.length; i++)
			nums[left + i] = tmp[i];
	}

	public static void main(String[] args) {
		int[] input1 = new int[] { 1, 2, 4, 7, 3, 3, 9, 3, 3, 4 };
		MergeSort.sort(input1);
		Util.printArray(input1);
		int[] input2 = new int[] { 1, 1, 1, 1, 2, 4, 7, 3, 3, 9, 3, 3, 4 };
		MergeSort.sort(input2);
		Util.printArray(input2);
	}
}
