package com.cloudlewis.leetcode.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.Util;

public class QuickSortPivotTest {

	public int sort(int[] nums) {
		if (nums.length < 2)
			return 0;
		return sort(nums, 0, nums.length - 1);
	}

	private int sort(int[] nums, int left, int right) {
		if (left >= right) 
			return 0;
		int totalComparison = right - left;
		int i = partition(nums, left, right); // find partition
		totalComparison += sort(nums, left, i - 1);
		totalComparison += sort(nums, i + 1, right);
		return totalComparison;
	}

	private int partition(int[] nums, int left, int right) {
		// int pivot = nums[(left + (right - left) / 2)];
		int pivot = medianOfThree(nums, left, right);
		// int pivot = right;
		swap(nums, pivot, left);
		int i = left + 1;
		for (int j = left + 1; j <= right; j++) {
			if (nums[j] < nums[pivot]) {
				swap(nums, j, i);
				i++;
			}
		}
		swap(nums, pivot, i - 1);
		return i - 1;
	}

	public void testOnInputFile() {
		List<Integer> list = new ArrayList<>();
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("quicksort.txt").getFile()));
			String str = null;
			while ((str = br.readLine()) != null)
				list.add(Integer.parseInt(str));
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			nums[i] = list.get(i);
		System.out.println("read " + nums.length + " lines of data.");

		System.out.println(sort(nums, 0, nums.length - 1));
	}

	public void test() {
		int[] a = { 1, 3, 2, 4, 5, 6, 9 };
		int[] b = { 3, 4, 5, 5, 8, 9, 5, 0 };
		int[] c = { 0, 0, 0, 0, 1, 3 };
		System.out.println(sort(a));
		System.out.println(sort(b));
		System.out.println(sort(c));
		Util.printArray(a);
		Util.printArray(b);
		Util.printArray(c);
	}

	protected void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	protected int medianOfThree(int[] array, int left, int right) {
		int first = array[left];
		int middle = array[left + (right - left) / 2];
		int last = array[right];
		if (last >= middle && middle >= first)
			return left + (right - left) / 2;
		else if (middle >= last && last >= first)
			return right;
		else
			return left;
	}

	public static void main(String[] args) {
		QuickSortPivotTest t = new QuickSortPivotTest();
		t.test();
		t.testOnInputFile();
	}
}
