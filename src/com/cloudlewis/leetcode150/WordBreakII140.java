package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author xiao
 *
 */

//!! REVISIT

//asking if all words can only be used once?

//Use a HashMap to keep the brunch, so it will now having issue on TimeLimit

// Similar to Palindrome I & II question
// if asking min/max/yesorno, can use DP, if need to exhaust the actual result,
// has to go DFS

// !!! First attempt failed because reused the word?

public class WordBreakII140 {
	private List<List<String>> rs = new ArrayList<>();
	private List<String> path = new ArrayList<>();
	
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, new HashMap<String, List<String>>(), wordDict);
	}

	private List<String> dfs(String s, Map<String, List<String>> map, List<String> wordDict) {
		if(map.containsKey(s))
			return map.get(s);
		List<String> arr = new ArrayList<>();
		if (s.isEmpty()){
			arr.add("");
			return arr;
		}
		
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> list = (dfs(s.substring(word.length()), map, wordDict));
				for (String ss: list)
					arr.add(word + (ss.isEmpty()? "" : " ") + ss);
			}
		}
		map.put(s, arr);
		return arr;
	}

	public List<String> wordBreakOnString(String s, List<String> wordDict) {
		// int len = s.length(); // non-empty as given by question
		wordb(s, 0, wordDict);
		// reconstruct result
		path.clear(); // resue
		for (List<String> l : rs) {
			StringBuilder builder = new StringBuilder();
			for (String str : l) {
				builder.append(str).append(" ");
			}
			builder.deleteCharAt(builder.length() - 1); // extra space
			path.add(builder.toString());
		}
		return path;
	}

	private void wordb(String s, int loc, List<String> wordDict) {
		if (loc != 0 && path.isEmpty()) // previous no match, no need to proceed
			return;
		int len = s.length();
		for (int i = loc; i < len; i++) { // no equal, stop on last character
			for (int j = i + 1; j <= len; j++) { // start from single char
				if (wordDict.contains(s.substring(i, j))) {
					path.add(s.substring(i, j));
					if (j == len) {
						rs.add(new ArrayList<>(path));
					} else {
						//wordb(s, i, wordDict); // !!! THIS IS WRONG, should continue on J
						wordb(s, j, wordDict);
					}
					path.remove(path.size() - 1);
				}
				
			}
		}
	}
	
	public static void main(String []args) {
		WordBreakII140 t = new WordBreakII140();
		List<String> dict = new ArrayList<>();
		dict.add("cat"); 
		dict.add("cats"); 
		dict.add("and"); 
		dict.add("sand");
		dict.add("dog");
		System.out.println(t.wordBreak("catsanddog", dict));
	}
}
