package com.cloudlewis.leetcode200;

/**
 * @formatter:off
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *   1 -> A
 *   2 -> B
 *   3 -> C
 *   ...
 *   26 -> Z
 *   27 -> AA
 *   28 -> AB
 *   
 * @formatter:on
 * @author xialiliu
 *
 */

// take a 10x number for comparison, then very easy!!
public class ExcelSheetColumnTitle168 {
	public String convertToTitle(int n) {
		StringBuilder str = new StringBuilder();
		while (n > 0) {
			n--;
			str.insert(0, (char) (n % 26 + 'A'));
			n /= 26;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle168 t = new ExcelSheetColumnTitle168();
		System.out.println(t.convertToTitle(26));
	}
}
