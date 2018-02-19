package com.cloudlewis.leetcode250;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ? k ? array's length.
 * 
 * @author xiao
 *
 */

// Solution 1. can use sort O(N logN), space O(1)
// Solution 2. use min heap O(N logK), space O(k)
// Solution 3. selection algorithm

// !!! REVISIT

public class KthLargestElementinanArray215 {
	public int findKthLargestFromLarge(int[] nums, int k) {
		int len = nums.length;
		if (len == 1)
			return nums[0];
		// partition returns the position, k is the order, use k-1
		return findKthLargest(nums, 0, len - 1, k - 1);
	}

//	public int findKthLargest(int[] nums, int left, int right, int k) {
//		if (left <= right) { // !!! MISSED this equal sign !
//			int p = partition(nums, left, right);
//			if (p == k)
//				return nums[k];
//			else if (p > k) // left
//				return findKthLargest(nums, left, p - 1, k);
//			else // on right
//				return findKthLargest(nums, p + 1, right, k - p);
//		}
//		return 0;
//	}

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}

	public int findKthLargest(int[] nums, int start, int end, int k) {
		if (start > end)
			return Integer.MAX_VALUE;

		int pivot = nums[end];// Take A[end] as the pivot,
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]

		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	}

	private int partition(int[] nums, int left, int right) {
		int pivot = left;
		int i = left, j = right;
		while (i <= j) {
			while (i <= j && nums[i] >= nums[pivot])
				i++;
			while (i <= j && nums[j] < nums[pivot])
				j--;
			if (i > j)
				break;
			swap(nums, i, j);
		}
		swap(nums, j, pivot);
		return j;
	}

	// reverse partition subroutine, in descending order
	// !!! OLD Implementation, failed on corner cases!!!!!
	@SuppressWarnings("unused")
	private int partition1(int[] nums, int left, int right) {
		int pivot = left;
		int i = left, j = right;
		// !!! MISSED this equal, without equal, will fail with {2,1} case
		// because loop will not get in at allen we do left + 1
		while (i <= j) {
			while (nums[i] >= nums[pivot] && i < right)
				i++;
			while (nums[pivot] > nums[j] && j > left)
				j--;
			// !!! MISSED equal here! this handles two element same
			if (i <= j) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}
		swap(nums, pivot, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		KthLargestElementinanArray215 t = new KthLargestElementinanArray215();
		System.out.println(t.findKthLargest(new int[] { 7, 6, 5, 4, 3, 2, 1 }, 5)); // 3
		System.out.println(t.findKthLargest(new int[] { 3, 1, 2, 4 }, 2)); // 3
		System.out.println(t.findKthLargest(new int[] { 1 }, 1)); // 1
		System.out.println(t.findKthLargest(new int[] { -1, 2, 0 }, 2)); // 0
		System.out.println(t.findKthLargest(new int[] { 99, 99 }, 1)); // 99
		System.out.println(t.findKthLargest(new int[] { 2, 1 }, 1)); // 2
		System.out.println(t.findKthLargest(new int[] { 7, 6, 5, 4, 3, 2, 1 }, 2)); // 6
		System.out.println(t.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
		System.out.println(t.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 4)); // 3
	}
}
