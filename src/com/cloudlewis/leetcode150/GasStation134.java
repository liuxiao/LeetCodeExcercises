package com.cloudlewis.leetcode150;

/**
 * 
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 * 
 * @author xiao
 *
 */

// cost[i] is to next station i + 1, because it is circle, then cost[len -1]
// will be cost to original point

public class GasStation134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int num = gas.length;
		for (int i=0; i < num; i ++) { // try all stations
			boolean notreach = false;
			int currst = i, curgas = 0;
			while(currst < num) {
				curgas += gas[currst] - cost[currst];
				if (curgas < 0) {// not reaching
					notreach = true;
					break;
				}
				currst++;
			}
			if (notreach) // no need to proceed to next check
				continue;
			currst = 0;
			while(currst < i){
				curgas += gas[currst] - cost[currst];
				if (curgas < 0) // not reaching
					break;
				currst++;
			}
			if (curgas >= 0) // !!! MISSED equal here
				return i;
		}
		return -1;
	}
}
