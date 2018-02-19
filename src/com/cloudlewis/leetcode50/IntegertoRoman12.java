package com.cloudlewis.leetcode50;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author xiao
 *
 */

// Asking what to represent 0?
// I, II, III, IV, V, VI, VII, VIII, IX, X
// L(50), C(100), D(500), M(1000)

public class IntegertoRoman12 {
	public String intToRoman(int num) {
		StringBuilder str = new StringBuilder();
		while (num / 1000 > 0) {
			str.append("M");
			num -= 1000;
		}
		// 0 - 999
		if (num >= 900) {
			str.append("CM");
			num -= 900;
		}
		else if (num >= 500) {
			str.append("D");
			num -=500;
			while (num >= 100) {
				str.append("C");
				num -=100;
			}
				
		}
		else if (num >= 400) {
			str.append("CD");
			num -= 400;
		}
		else if (num >= 100) {
			while (num >= 100) {
				str.append("C");
				num -=100;
			}
		}
		// 0-90
		
		if (num >=90) {
			str.append("XC");
			num -= 90;
		}
		else if (num >=50){
			str.append("L");
			num -= 50;
			while (num >=10) {
				str.append("X");
				num -=10;
			}
		}
		else if (num >= 40) {
			str.append("XL");
			num -=40;
		}
		else if (num >= 10) {
			while(num >= 10){
				str.append("X");
				num -=10;
			}
		}
		// 0-9
		if (num == 9)
			str.append("IX");
		else if (num == 8)
			str.append("VIII");
		else if (num == 7)
			str.append("VII");
		else if (num == 6)
			str.append("VI");
		else if (num == 5)
			str.append("V");
		else if (num == 4)
			str.append("IV");
		else if (num == 3)
			str.append("III");
		else if (num == 2)
			str.append("II");
		else if (num == 1)
			str.append("I");
		return str.toString();
	}
	
	public static void main(String [] args) {
		IntegertoRoman12 t = new IntegertoRoman12();
		System.out.println(t.intToRoman(1954)); //MCMLIV
		System.out.println(t.intToRoman(1990));	//MCMXC
		System.out.println(t.intToRoman(2014)); //MMXIV
		System.out.println(t.intToRoman(60)); //LX
	}
}
