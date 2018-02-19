package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author xiao
 *
 */

// backing tracing

public class RestoreIPAddresses93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> rs = new ArrayList<String>();
		List<String> path = new ArrayList<>();
		restore(s, 0, rs, path);
		return rs;
	}

	private void restore(String s, int from, List<String> rs, List<String> path) {
		if (path.size() > 4 || from > s.length()) // not possible
			return;
		else if (path.size() == 4) {
			if (from == s.length()) {
				StringBuilder str = new StringBuilder();
				str.append(path.get(0)).append(".").append(path.get(1)).append(".").append(path.get(2)).append(".").append(path.get(3));
				rs.add(str.toString());
			}
			else {
				return; // didn't use all strings
			}
		}
		
		for (int i=from; i<from +3 && i < s.length(); i++) {
			String sec = s.substring(from, i + 1);
			int num = Integer.parseInt(sec);
			if (num > 255 || (num > 0 && sec.startsWith("0") || (num == 0 && sec.length() != 1))) // !!!! TRICKY POINT, forget .010 case
				break; // break because this is max already
			List<String> newp = new ArrayList<>();
			newp.addAll(path);
			newp.add(sec);
			restore(s, i+ 1, rs, newp);
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses93 t = new RestoreIPAddresses93();
		System.out.println(t.restoreIpAddresses("25525511135"));
	}
}
