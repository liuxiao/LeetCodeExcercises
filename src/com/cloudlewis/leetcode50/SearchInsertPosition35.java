package com.cloudlewis.leetcode50;

/**
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * @formatter:off
 * [1,3,5,6], 5 → 2 
 * [1,3,5,6], 2 → 1 
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @formatter:on
 * @author xiao
 *
 */

// assume no duplicates?

// solution 1. O(n), scan until next element is greater, while previous is
// smaller; or return exact value

// solution 2. O(logn), typicall binary search stop when i=j (i<=j); here we do
// i<j,, or special handling within (i=j) case

public class SearchInsertPosition35 {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int l = 0, r = len - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	public static void main(String[] args) {
		SearchInsertPosition35 t = new SearchInsertPosition35();
		int[] a = { 1, 3, 5, 6 }; // , 5 → 2
		//int b = { 1, 3, 5, 6 }; // , 2 → 1
		//int c = { 1, 3, 5, 6 };// , 7 → 4
		//int d = { 1, 3, 5, 6 };// , 0 → 0
		System.out.println(t.searchInsert(a, 5));
		System.out.println(t.searchInsert(a, 2));
		System.out.println(t.searchInsert(a, 7));
		System.out.println(t.searchInsert(a, 0));
		
	}
}
