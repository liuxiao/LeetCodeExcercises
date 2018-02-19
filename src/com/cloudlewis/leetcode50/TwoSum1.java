package com.cloudlewis.leetcode50;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 **/

// asking for space and runtime requirement
// asking for number range; negative? should not matter
// asking for if return value should be in sorted order i.e. [1,0] is valid?

// solution 1. sort array nlog(n) and then scan from both ends O(n) = nlog(n); quick sort

// solution 2. scan once fill in array with max size of target; scan second time to find the target; O(n) depdns on the size of target

// solution 3. O(n^2)

// solution 4. use hashmap two pass; first pass fill in; second pass find the target - element; space, runtime O(n)

// solution 5. use hashmap one pass; find target - element, if not exist, put in; otherwise find the one

public class TwoSum1 {
    
    public int[] twoSum(int[] nums, int target) {
           if (nums.length < 2)
               return null;
           Map<Integer, Integer> map = new HashMap<Integer, Integer>();
           for (int i=0; i < nums.length; i++){
               if (map.containsKey(target - nums[i])) // find solution
                   return new int[] {map.get(target - nums[i]), i};
               map.put(nums[i], i);
           }
           return null; // should never reach if there is a solution
    }

}
