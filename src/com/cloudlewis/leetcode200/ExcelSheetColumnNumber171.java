package com.cloudlewis.leetcode200;

/**
 * @formatter:off
 * Related to question Excel Sheet Column Title
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *   A -> 1
 *   B -> 2
 *   C -> 3
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28
 *   
 * @formatter:on
 * @author xiao
 *
 */

// !! REVISIT

public class ExcelSheetColumnNumber171 {
	public int titleToNumber(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		int value = 0;
		for (int i = 0; i < s.length(); i++)
			value = value * 26 + s.charAt(i) - 'A' + 1;
		return value;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber171 t = new ExcelSheetColumnNumber171();
		System.out.println(t.titleToNumber("AB"));

		// let's do some test
		ExcelSheetColumnTitle168 tt = new ExcelSheetColumnTitle168();
		String num = tt.convertToTitle(1256);
		System.out.println(num);
		System.out.println(t.titleToNumber(num));
	}
}
