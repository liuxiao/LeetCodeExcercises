package com.cloudlewis.leetcode.basic;

import java.util.Random;

import com.cloudlewis.leetcode.common.Util;

public class QuickSort {
	private static Random rand = new Random();

	public static void sort(int[] nums) {
		if (nums.length < 2)
			return;
		sort(nums, 0, nums.length - 1);
	}

	private static void sort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int i = partition(nums, left, right); // find partition
		if (left < i - 1)
			sort(nums, left, i - 1);
		// need to pick i here; because partition guarantee <i exceed pivot
		if (right > i)
			sort(nums, i, right);
		// one of them must contains i, because we found nums[pivot], not
		// nums[i]
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[(left + (right - left) / 2)];
		int i = left, j = right;
		while (i <= j) {
			// !! NEED equal here, because need to identify even when i==j, is i
			// belongs to left partition or right partition
			while (nums[i] < pivot)
				i++;
			while (pivot < nums[j])
				j--;
			if (i <= j) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				// after swap, num[i] is definitely smaller, otherwise, there
				// will be no swap, hence, we could increase counter, because
				// there is no need to compare it one more time; if loop
				// stopped, we don't know about num[i], because it got
				// increased, we only know i-1 is smaller than pivot
				i++;
				j--;
			}
		}
		return i;
		// i >= j, crossed, up to index i, all left smaller than pivot, all
		// right greater than pivot;
	}

	public static void sortInStanfordAlgorithm(int[] nums) {
		sortInStanfordAlgorithm(nums, 0, nums.length - 1);
	}

	private static void sortInStanfordAlgorithm(int[] nums, int left, int right) {
		if (left < right) {
			int p = partitionInStanfordAlg(nums, left, right);
			sortInStanfordAlgorithm(nums, left, p - 1);
			sortInStanfordAlgorithm(nums, p + 1, right);
		}
	}

	private static int partitionInStanfordAlg(int[] nums, int left, int right) {
		// pick pivot
		int pivot = nums[left];
		int i = left + 1;
		for (int j = left + 1; j <= right; j++) { // leave out the first
			if (pivot > nums[j]) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				i++;
			}
		}
		nums[left] = nums[i - 1];
		nums[i - 1] = pivot;
		return i - 1;
	}

	@SuppressWarnings("unused")
	private static int pickPivotRandom(int left, int right) {
		return rand.nextInt(right - left + 1) + left;
	}

	public static void test() {
		int[] a = { 1, 3, 2, 4, 5, 6, 9 };
		int[] b = { 3, 4, 5, 5, 8, 9, 5, 0 };
		int[] c = { 0, 0, 0, 0, 1, 3 };
		int[] d = { 1, 2, 3, 4, 5, 6 };
		int[] e = { 5, 4, 3, 2, 1 };
		sortInStanfordAlgorithm(a);
		sortInStanfordAlgorithm(b);
		sortInStanfordAlgorithm(c);
		sortInStanfordAlgorithm(d);
		sortInStanfordAlgorithm(e);
		Util.printArray(a);
		Util.printArray(b);
		Util.printArray(c);
		Util.printArray(d);
		Util.printArray(e);
	}

	public static void main(String[] args) {
		QuickSort.test();
	}
}
