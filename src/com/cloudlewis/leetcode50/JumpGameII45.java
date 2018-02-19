package com.cloudlewis.leetcode50;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * 
 * @author xiao
 *
 */

//  0 1 2 3 4  -- len 5
// [2,3,1,1,4]

// ****** REVISIT

public class JumpGameII45 {
	public int jump(int[] nums) {
		if (nums.length < 2) return 0;
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		jumpAny(nums, 0, 0, min);
		return min[0];
	}
	
	
	// this is a wrong implementation, because we can go less than nums[cur]
	@SuppressWarnings("unused")
	private void jump(int[] nums, int cur, int step, int[] min) {
		if (nums[cur]  + cur >= nums.length - 1) { // 3 + 1 >= 5 -1(4)
			if (step + 1 < min[0])
				min[0] = step + 1;
		}
		else {
			// !!!! TRICKY !! if current step is 0, then no need to take
			if (nums[cur] >0 )
				jump(nums, cur + nums[cur], step + 1, min);
			jump(nums, cur + 1, step + 1, min);
		}
	}
	
	private void jumpAny(int[] nums, int cur, int step, int[] min) {
		if (step >= min[0]) //  MISSED !!! IMPORTANT, otherwise, too slow
			return;
		if (nums[cur]  + cur >= nums.length - 1) { // 3 + 1 >= 5 -1(4)
			if (step + 1 < min[0])
				min[0] = step + 1;
		}
		else {
			if (nums[cur] > 1 )
				for (int i = 1; i <= nums[cur]; i++) //  MISSED !!! IMPORTANT
					jumpAny(nums, cur + i, step + 1, min);
			//jumpAny(nums, cur + 1, step + 1, min);
		}
	}
	
	public int jumpInterative(int[] A) {
        int len = A.length;
        if (len <= 1) return 0;
        // alg works when lenth >= 2
        // after reading other's solution
        // try to recap
        int reachedSofar = 0;
        int step = 0;
        int canReach = 0;
        for (int i=0;i<len;i++) {
            if (i > reachedSofar) { // index greater than max we reached
                if (reachedSofar < len && canReach <= reachedSofar) // boundary check
                    return -1; // cannot proceed further
                // -> canRach > reachedSofar
                reachedSofar = canReach;
                step++;
            }
            canReach = Math.max(canReach, i + A[i]);
        }
        return step;
    }
	
	public static void main(String[] args) {
		JumpGameII45 t = new JumpGameII45();
		//System.out.println(t.jump(new int[]{0}));
		//System.out.println(t.jump(new int[]{2}));
		//System.out.println(t.jump(new int[]{2,3}));
		//System.out.println(t.jump(new int[]{2,3,1,1,4}));
		//System.out.println(t.jump(new int[]{2,3,0,1,4})); //2
		//System.out.println(t.jump(new int[]{4,1,1,3,1,1,1})); //2
		//System.out.println(t.jump(new int[]{1,2,1,1,1})); //3
		System.out.println(t.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
	}
}

