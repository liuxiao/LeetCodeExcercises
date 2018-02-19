package com.cloudlewis.leetcode.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Responding to Coursea Programming Assignment #2
 * 
 * This file contains all of the 100,000 integers between 1 and 100,000
 * (inclusive) in some order, with no integer repeated.
 * 
 * Your task is to compute the number of inversions in the file given, where the
 * ith row of the file indicates the ith entry of an array.
 * 
 * Because of the large size of this array, you should implement the fast
 * divide-and-conquer algorithm covered in the video lectures.
 * 
 * The numeric answer for the given input file should be typed in the space
 * below.
 * 
 * So if your answer is 1198233847, then just type 1198233847 in the space
 * provided without any space / commas / any other punctuation marks. You can
 * make up to 5 attempts, and we'll use the best one for grading.
 * 
 * @author xiao
 *
 */

/*
 * Solution (0). O(n ^ 2), scan and count Solution 1. O(nlogN)
 */
public class RecursiveArrayInversion {

	public long findNumOfInversion(int[] nums) {
		long[] count = new long[] { 0 };
		findNumOfInversionRecurssive(nums, 0, nums.length - 1, count);
		return count[0];
	}

	private void findNumOfInversionRecurssive(int[] nums, int left, int right, long[] count) {
		if (left >= right)
			return;
		int mid = left + (right -left)/2;
		findNumOfInversionRecurssive(nums, left, mid, count);
		findNumOfInversionRecurssive(nums, mid + 1, right, count);
		count[0] += mergeNCount(nums, left, mid, right);
	}

	private int mergeNCount(int[] nums, int left, int mid, int right) {
		int i = left, j = mid + 1, count = 0;
		
		int[] tmp = new int[right - left + 1];
		while (i <= mid && j <= right) {
			if (nums[i] <= nums[j]) {
				tmp[i + j - left - mid - 1] = nums[i];
				i++;
			} else {
				tmp[i + j - left - mid - 1] = nums[j];
				j++;
				count += (mid - i + 1); // how many left in array left
			}
		}
		while (i <= mid) {
			tmp[i + j - left - mid - 1] = nums[i];
			i++;
		}
		while (j <= right) {
			tmp[i + j - left - mid - 1] = nums[j];
			j++;
			count += (mid - i + 1); // how many left in array left
		}
		// copy back
		for (int k = 0; k < tmp.length; k++)
			nums[k + left] = tmp[k];
		return count;

	}

	public void testOnInputFile() {
		List<Integer> list = new ArrayList<>();
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("inversionarray.txt").getFile()));
			String str = null;
			while((str = br.readLine()) != null)
				list.add(Integer.parseInt(str));
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("read " + list.size() + " lines of data.");
		int[] nums = new int[list.size()];
		for (int i=0; i< list.size(); i++)
			nums[i] = list.get(i);
		System.out.println(findNumOfInversion(nums));
	}

	public static void main(String[] args) {
		// small validation
		RecursiveArrayInversion t = new RecursiveArrayInversion();
		System.out.println(t.findNumOfInversion(new int[] {1,5,7,9,2,4,6,3,0}));
		System.out.println(t.findNumOfInversion(new int[] {8, 4, 2, 1}));
		System.out.println(t.findNumOfInversion(new int[] {1, 20, 6, 4, 5}));
		t.testOnInputFile();
	}
}
