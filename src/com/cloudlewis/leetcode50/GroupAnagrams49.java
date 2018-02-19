package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @formatter:off
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 *
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 *
 * @formatter:on
 * @author xiao
 *
 */
public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> rs = new ArrayList<>();
		if (strs.length == 0)
			return rs;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] str = s.toCharArray();
			Arrays.sort(str);
			String key = String.valueOf(str);
			if (map.containsKey(key))
				map.get(key).add(s);
			else {
				List<String> n = new ArrayList<String>();
				n.add(s);
				map.put(key, n);
			}
		}
		rs.addAll(map.values());
		return rs;
	}
	
	public static void main(String[] args) {
		GroupAnagrams49 t= new GroupAnagrams49();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(t.groupAnagrams(strs));
	}
}
