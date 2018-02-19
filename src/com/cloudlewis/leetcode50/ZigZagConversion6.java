package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author xiao
 *
 */
//@formatter:off
// solution 1. start from the beginning; sample every "numRows" character from the string
// 0           6              12
//   1      5    7         11     13
//    2   4        8    10           14
//      3             9                 15
//@formatter:on
// for loop the first index to find the start number
// for loop with distance 2n to sample the string; every time decrease by 2
// need special handling of first row and last row, because they have fixed distance of 2n-1

// solution 2. reqire O(n) space, but easy to implement; put them into list and then concat at the end

public class ZigZagConversion6 {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		// if (numRows == 2) need to take care of
			
		int len = s.length();
		int gap = (numRows - 1) * 2;
		StringBuilder str = new StringBuilder();
		for (int n = 0; n < numRows; n++) { // start from 1
			if (n==0 || n == numRows -1) { // special handling for fixed distance
				for (int i=n; i <len; i+= gap)
					str.append(s.charAt(i));
			}
			else {
				int fdis = gap - n  * 2; 
				for (int i=n; i< len; i+= gap) { // TRICKY! WRONG EARLIER, cannot use i+fdis < len, might lose i condition at last
					str.append(s.charAt(i));
					if (i + fdis < len)
						str.append(s.charAt(i + fdis));					
				}		
			}
		}
		return str.toString();
	}
	
	public String covertWithSpace(String s, int numRows) {
		if (numRows == 1)
			return s;
		
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i=0; i<numRows; i++)
			list.add(new StringBuilder());
		int len = s.length();
		int j = 0;
		boolean down = true;
		for (int i=0 ;i <len; i ++) {
			list.get(j).append(s.charAt(i));
			if (down)
				j++;
			else
				j--;
			if (j == numRows) {
				down = false;
				j = numRows -2;
			}
			else if (j < 0){
				down =true;
				j = 1;
			}
			
		}
		StringBuilder st = new StringBuilder();
		for (int i=0;i<numRows; i++)
			st.append(list.get(i).toString());
		return st.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion6 t = new ZigZagConversion6();
		System.out.println("PAHNAPLSIIGYIR");
		System.out.println(t.convert("PAYPALISHIRING", 3));
	}
}
