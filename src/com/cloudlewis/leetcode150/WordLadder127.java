package com.cloudlewis.leetcode150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @formatter:off
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 1. Only one letter can be changed at a time. 
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
 * 
 * For example,
 * 
 * Given: 
 * beginWord = "hit" 
 * endWord = "cog" 
 * wordList = ["hot","dot","dog","lot","log","cog"] 
 * As one shortest transformation is "hit"	-> "hot" -> "dot" -> "dog" -> "cog", 
 * return its length 5.
 * 
 * Note: 
 * Return 0 if there is no such transformation sequence. 
 * All words have the same length.
 * All words contain only lowercase alphabetic characters. 
 * You may assume no duplicates in the word list. 
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * @formatter:on
 * @author xiao
 *
 */

// Solution 1.
// feel like a DFS problem; permute the change, but key point is to make sure
// not going back keep an extra HashMap to maintain used word;
// maybe better to process the dictionary first, to have a map with 1 distance

public class WordLadder127 {
	
	// !!! NOT A WORKIGN SOLUTION
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// need to generate a map from beginWord, so need to add it into wordList, but not endWord
		wordList.add(beginWord);
		wordList.add(endWord);
		Map<String, List<String>> dict = createDict(wordList);
		Set<String> used = new HashSet<String>();
		used.add(beginWord);
		int count = 1;
		Queue<String> q = new ArrayDeque<>();
		Queue<String> tmp =  new ArrayDeque<>();
		q.add(beginWord);
		while(!q.isEmpty()) {
			String str = q.remove();
			if (str.equals(endWord))
				return count;
			used.add(str);
			List<String> candidates = dict.get(str);
			for (String c : candidates) {
				if (!used.contains(c))
					tmp.add(c);
			}
			if(q.isEmpty()) {
				count++;
				q.addAll(tmp);
				tmp.clear();
			}
			
		}
		
		return 0;
	}
	
	private Map<String, List<String>> createDict(List<String> wordList) {
		Map<String, List<String>> dict = new HashMap<>();
		for (int i=0; i<wordList.size();i++) {
			String key = wordList.get(i);
			List<String> vals = new ArrayList<>();
			for (int j =0; j<wordList.size(); j++) {
				if (i != j && isOneDistance(key, wordList.get(j)))
					vals.add(wordList.get(j));
			}
			dict.put(key, vals);
		}
		return dict;
	}
	
	private boolean isOneDistance(String s1, String s2) {
		int sum = 0;
		for (int i=0; i< s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				sum++;
			if (sum > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		WordLadder127 t = new WordLadder127();
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		System.out.println(t.ladderLength("hit", "cog", wordList));
		
		wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
		System.out.println(t.ladderLength("qa", "sq", wordList));
	}
}
