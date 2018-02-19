package com.cloudlewis.leetcode100;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author xiao
 *
 */

// simple question, trick is the 0 in front 

public class AddBinary67 {
	public String addBinary(String a, String b) {
		int lena = a.length(), lenb = b.length();
		int [] sum = new int[Math.max(lena, lenb) + 1];
		int i=lena - 1, j = lenb -1, idx = Math.max(lena, lenb);
		while( i>=0 || j >=0) {
			int s;
			if (i >= 0 && j>=0) {
				s = sum[idx]  + a.charAt(i) - '0' + b.charAt(j) - '0';
				j--;
				i--;
			}
			else if (i>=0) {
				s = sum[idx] + a.charAt(i) - '0';
				i--;
			}
			else {
				s = sum[idx] + b.charAt(j) - '0';
				j--;
			}
			sum[idx] = s % 2;
			sum[idx - 1] = s /2;
			idx--;
		}
		StringBuilder s = new StringBuilder();
		int p = 0;
		while (p < sum.length -1 && sum[p] == 0)
			p++;
			
		for (; p< sum.length; p++)
			s.append(sum[p]);
		
		return s.toString();
	}
	
	public static void main(String [] args)  {
		AddBinary67 t = new AddBinary67();
		System.out.println(t.addBinary("0", "0"));
		System.out.println(t.addBinary("11", "1"));
		System.out.println(t.addBinary("11", "1001"));
	}
	
}
