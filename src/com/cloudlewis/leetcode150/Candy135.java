package com.cloudlewis.leetcode150;

/**
 * 
 * @formatter:off
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. 
 * Children with a higher rating get more candies than their neighbors. 
 * 
 * What is the minimum candies you must give?
 * 
 * @formatter:on
 * @author xiao
 *
 */

// asking what if equal rating? -- it does not say equal, same candy or can be
// less?
// taking question with 1 candy
// DFS? or DP?, should start with one?
// can we just asssign a value? and then making sure smallest is 1 with two pass
// done in O(n)

// Solution 1.
// seems can be also solved with stack; like historgram and tapping water
// question!! second thought, we don't need a stack, because we only need to
// count; with this method, i don't need dp, because all we need is previous
// (highest)

// Solution 2.
// scan two times, once from left, on increment; once form right, to reduce the gap

public class Candy135 {
	public int candy(int[] ratings) {
		int len = ratings.length;
		if (len < 1)
			return len;
		int[] candy = new int[len];
		for (int i=0;i<len;i++)
			candy[i] = 1;
		for (int i=1; i< len;i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i -1] + 1;
		}
		
		for (int i=len-1; i>0; i--) {
			if (ratings[i] < ratings[i-1])
				candy[i-1] = Math.max(candy[i] + 1, candy[i-1]);
		}
		
		int sum = 0;
		for (int i=0;i<len;i++)
			sum+=candy[i];
		return sum;
	}
	
	
	// this might not be the right answer
	public int candyWrong(int[] ratings) {
		int len = ratings.length;
		if (len == 0)
			return 0;
		int prev = 1, sum = 1;
		int i = 1;
		while (i < len) {
			if (ratings[i] > ratings[i - 1]) {
				sum += prev + 1;
				prev++;
				i++;
			} else if (ratings[i] == ratings[i - 1]) {
				sum++;
				prev = 1; // only give one
				i++;
			} else {
				// going down, we want to count how many, and then adjust
				// previous
				int down = 0;
				while(i < len && ratings[i] < ratings[i-1]) { // this will match at least once, so i will ++
					down++;
					i++;
				}
				int count = (1 + down) * down /2;
				if (down >= prev)
					sum += (down - prev + 1) + count;
				else
					sum+=count; 
			}

		}
		return sum;
	}
}
