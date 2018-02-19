package com.cloudlewis.leetcode100;

import java.util.Stack;

/**
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * @formatter:off
 * For example, 
 * path = "/home/", => "/home" 
 * path = "/a/./b/../../c/", => "/c"
 * 
 * 
 * Corner Cases: 
 * Did you consider the case where path = "/../"? 
 * In this case, you should return "/". 
 * 
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/". 
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @formatter:on
 * @author xiao
 *
 */

// asking can i always assume it is correct?
// this question , intuition way is to use a stack
// also assume i cannot use java String utility?

public class SimplifyPath71 {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		int len = path.length();
		int i = 0, start = 0;
		while (i < len) {
			if (path.charAt(i) == '/') {
				while (i < len && path.charAt(i) == '/')
					i++;
				start = i;
			}

			while (i < len && path.charAt(i) != '/')
				i++; // stop on /
			// this should be a complete word
			String str = path.substring(start, i);
			if (str.equals(".") || str.isEmpty()) {
				continue;
			} else if (str.equals("..")) {
				if (!s.isEmpty())
					s.pop();
			} else {
				s.push(str);
			}
		}
		if (s.isEmpty()) // edge case
			s.push("");
		// poping and construct a result
		StringBuilder rs = new StringBuilder();
		while (!s.isEmpty()) {
			rs.insert(0, s.pop());
			rs.insert(0, "/");
		}
		return rs.toString();
	}

	public static void main(String[] args) {
		SimplifyPath71 t = new SimplifyPath71();
		System.out.println(t.simplifyPath("/a/./b/../../c/"));
		System.out.println(t.simplifyPath("/."));
		System.out.println(t.simplifyPath("/home/"));
		System.out.println(t.simplifyPath("/home//foo/"));
		System.out.println(t.simplifyPath("/"));
		System.out.println(t.simplifyPath("/../"));
	}
}
