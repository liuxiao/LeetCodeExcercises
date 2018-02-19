package com.cloudlewis.leetcode200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author xiao
 *
 */

// Solution 1. brute force, take every 10 characters for every chracter as start O(n^2)
// optimization can be window like?, find pattern in 10, and shift more than 1 location?

// Solution 2. given we already have to use O(n) space, can use another HashSet

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		Set<String> seen = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i++) { // this boundry section!! we are taking substring, not index
			String str = s.substring(i, i + 10);
			if (seen.contains(str) && !list.contains(str))
				list.add(str);
			seen.add(str);
		}
		return list;
    }
    
    public static void main(String [] args) {
    	RepeatedDNASequences187 t = new RepeatedDNASequences187();
    	System.out.println(t.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
