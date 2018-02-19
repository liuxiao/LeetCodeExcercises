package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author xiao
 *
 */

// asking what would be the return value if not found

// @formatter:off
// solution 1. get all permutation of words O(n^2), generate a map; then use
// strstr to search with KMP O(m*n) for each pattern. in total will be O(n^2 + n
// * m * n)

// solution 2. brute force?

// solution 3, find all occurance of the words in String, result in a array of
// index; word1[0,3,7] match, word2[1,4,8] match; then find word1[i] + word1.len
// = word2[j]; searching will be O(m*n) * n


// https://discuss.leetcode.com/topic/6617/an-o-n-solution-with-detailed-explanation

// solution 4. use a hashmap to find all occurance of the string first, with their location
// IMPORTANT assumption here is no words can interening each other; otherwise, can only go with #1 or #2, or using window
// @formatter:on

// !! REVIEW< similar question

!!

public class SubstringwithConcatenationofAllWords30 {
	public List<Integer> findSubstring(String s, String[] words) {
		// should solve not found or string problem; since not defined, skip
		int slen = s.length();
		int wlen = words[0].length();
		List<Integer> rs = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> tmp = new HashMap<>();
		for (String str : words) {
			if (map.containsKey(str))
				map.put(str, map.get(str) + 1);
			else
				map.put(str, 1);
		}
		// make a copy of map
		tmp.putAll(map);
		int start = 0 ,count = words.length, cur = 0;
		while (cur + wlen < slen) {
			String str = s.substring(cur, cur + wlen);
			if (map.containsKey(str) && map.get(str) > 0) {
				count--;
				map.put(str, map.get(str) - 1);
				cur += wlen; // this has to make sure no intervine of the
								// character
			} else if (map.containsKey(str) && map.get(str) <= 0){
				count ++;
				String head = s.substring(start, start + wlen);
				while( !head.equalsIgnoreCase(str)) {
					count++;
					map.put(head, map.get(head) + 1);
					start += wlen;
					head = s.substring(start, start + wlen);
				}
				map.put(head, map.get(head) + 1);
				count++;
				//cur += wlen;
			}
			else { // not equal, then move one step
				count = tmp.size();
				map.clear();
				map.putAll(tmp);
				cur++;
				start = cur;
			}
			// there will be element with negative value, need value to be exact 0
			// it should be the solution already
			if (count == 0) {
				rs.add(start);
				String head = s.substring(start, start + wlen);
				map.put(head, map.get(head) + 1);
				count++;
				start += wlen;
			}
		}
		return rs;
	}

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords30 t = new SubstringwithConcatenationofAllWords30();
		System.out.println(t.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(t.findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
		System.out.println(t.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
	}
}
