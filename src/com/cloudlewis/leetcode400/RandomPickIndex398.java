package com.cloudlewis.leetcode400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Note: The array size can be very large. Solution that uses too much extra
 * space will not pass the judge.
 * 
 * Example:
 * 
 * @formatter:off
 * int[] nums = new int[] {1,2,3,3,3}; 
 * Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning. 
 * solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * 
 * @formatter:on
 * @author xiao
 *
 */

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */

// ideally, we could do it by sort; but given N might be huge or stream.
// cannot sort it in memoery
// use reservior sampling
public class RandomPickIndex398 {
	private List<Integer> stream = new ArrayList<>();
	private Random rand = new Random();
	
	public RandomPickIndex398(int[] nums) {
		for (int i:nums)
			stream.add(i);
	}

	public int pick(int target) {
		Iterator<Integer> iter = stream.iterator();
		int cnt = 0;
		int index = 0;
		int output = -1;
		while(iter.hasNext()){
			// 1/num possibility to keep
			int num = iter.next(); 
			if (num == target) {
				cnt++;
				if (rand.nextInt(cnt) == 0) {
					output =  index;
				}
			}
			index++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		RandomPickIndex398 t = new RandomPickIndex398(new int[] {1,2,3,3,3});
		System.out.println(t.pick(3));
	}
}
