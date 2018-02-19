package com.cloudlewis.leetcode50;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author xiao
 *
 */

// scanning string

public class RomantoInteger13 {
	public int romanToInt(String s) {
		int len = s.length();
		int rs = 0;
		for (int i = len -1; i >=0; i--) {
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				rs += (rs >= 5) ? -1 : 1;
				break;
			case 'V':
				rs += 5;
				break;
			case 'X':
				rs += (rs >= 50) ? -10 : 10;
				break;
			case 'L':
				rs += 50;
				break;
			case 'C':
				rs += (rs >= 500) ? -100 : 100;
				break;
			case 'D':
				rs += 500;
				break;
			case 'M':
				rs += 1000;
				break;
			default:
				break;
			}
		}
		return rs;
	}
	
	public static void main(String [] args) {
		RomantoInteger13 t = new RomantoInteger13();
		System.out.println(t.romanToInt("MCMLIV"));
		System.out.println(t.romanToInt("MCMXC"));
		System.out.println(t.romanToInt("MMXIV"));
		System.out.println(t.romanToInt("LX"));
	}
}
