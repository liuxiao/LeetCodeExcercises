package com.cloudlewis.leetcode200;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author xiao
 *
 */

// !!! REVISIT

// feel like we need to keep track of the minus too, because it might turn
// things around
// also they are all int, can not be fractional, so as long as # of negative num
// is even, we should just take product of whole array
// if there is odd number, feel like we need to check negative number location

// Solution 1. scan from both end, till two pointers meet; only need to note
// down the first negative number hit; along the way, we keep the product when
// hit first negative, and compare which negative is bigger, which we keep

public class MaximumProductSubarray152 {

	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int maxherepre = nums[0];
		int minherepre = nums[0];
		int maxsofar = nums[0];
		int maxhere, minhere;

		for (int i = 1; i < nums.length; i++) {
			maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			maxsofar = Math.max(maxhere, maxsofar);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;
	}

	// this solution currently have problem handling zero; need generic solution
	public int maxProductSolution1(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int pleft = 1, pright = 1, ileft = 0, iright = nums.length - 1;
		int negaleft = -1, negaright = -1, numnega = 0;
		int negaPb4 = 1, negaAft = 1;
		while (ileft <= iright) {
			if (ileft != iright) {
				if (nums[ileft] < 0) {
					numnega++;
					if (negaleft == -1)
						negaleft = ileft;
				}
				if (nums[iright] < 0) {
					numnega++;
					if (negaright == -1)
						negaright = iright;
				}
				pleft *= nums[ileft];
				pright *= nums[iright];
				if (negaleft == -1)
					negaPb4 *= nums[ileft];
				if (negaright == -1)
					negaAft *= nums[iright];
			} else {
				if (nums[ileft] < 0) {
					numnega++;
					if (negaleft == -1)
						negaleft = ileft;
				}
				pleft *= nums[ileft];
				if (negaleft == -1)
					negaPb4 *= nums[ileft];
			}
			ileft++;
			iright--;
		}
		if (numnega % 2 == 0)
			return pleft * pright;
		else {
			if (negaPb4 > negaAft) {
				return pleft * pright / negaAft / nums[negaright];
			} else {
				return pleft * pright / negaPb4 / nums[negaleft];
			}
		}
	}

	public static void main(String[] args) {
		MaximumProductSubarray152 t = new MaximumProductSubarray152();
		System.out.println(t.maxProduct(new int[] { 2, 3, -2, 4 }));
	}
}
