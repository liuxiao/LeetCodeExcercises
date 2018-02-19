package com.cloudlewis.leetcode.tests;

import com.cloudlewis.leetcode200.ExcelSheetColumnNumber171;
import com.cloudlewis.leetcode200.ExcelSheetColumnTitle168;

// @formatter:off
public class Test168N171 {
	
	// we should just think about the problem as a 26-based number problem
	public static String numToCharacterTitle(int num) {
		StringBuilder str = new StringBuilder();
		while(num > 0) {
			// num will be 1 - 26 maps to A - Z; but if Z, num = 26;
			// 26 % 26 = 0, which we want as 25, so we decrement num by 1;
			num--;
			str.insert(0, (char)('A' + num % 26)); // don't forget the insert 0
			num /= 26;
		}
		return str.toString();
	}
	
	// also map how we deal with octal 10base number, we look at first, and multiple base + next
	public static int titleToNumber(String title) {
		int len = title.length();
		int base = 0;
		for (int i=0; i< len; i++)
			base = base * 26 + title.charAt(i) - 'A' + 1;
		return base;
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle168 t = new ExcelSheetColumnTitle168();
		System.out.println(Test168N171.numToCharacterTitle(1234).equals(t.convertToTitle(1234)));
		System.out.println(Test168N171.numToCharacterTitle(26).equals(t.convertToTitle(26)));
		System.out.println(Test168N171.numToCharacterTitle(243).equals(t.convertToTitle(243)));
		
		ExcelSheetColumnNumber171 tt = new ExcelSheetColumnNumber171();
		System.out.println(Test168N171.titleToNumber("ACCD") == (tt.titleToNumber("ACCD")));
		System.out.println(Test168N171.titleToNumber("Z") == (tt.titleToNumber("Z")));
		System.out.println(Test168N171.titleToNumber("DEF") == (tt.titleToNumber("DEF")));
	}
}
