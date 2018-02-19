package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * @formatter:off
 * For example, words: ["This", "is", "an", "example", "of", "text", "justification."] 
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 *
 * @formatter:on
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * @author xiao
 *
 */

// no mentioning if words length > line
// idea is to put space in between, but not at the end of the line

public class TextJustification68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> rs = new ArrayList<String>();
		int i = 0, len = words.length;
		while (i < len) {
			int count = 0, start = i;
			while (i < len && count + words[i].length() <= maxWidth) {
				count += words[i].length();
				i++;
				if (i < len && count + words[i].length() <= maxWidth)
					count++;
			} // last statement makes sure no append space at back
			int wordcount = (i - start); // i stop when it cannot fill
			if (wordcount > 1) { // if == 1, no need to append
				int[] extraspace = new int[wordcount-1];
				// when count == maxWidth, nothing need to do, else fill space
				if (count < maxWidth){
					for (int f = 0; f < maxWidth - count; f++)
						extraspace[f%(wordcount - 1)] ++; // append a space
				}
				// construct the line
				StringBuilder str = new StringBuilder();
				for (int f =0; f< wordcount; f++) {
					str.append(words[f + start]);
					if (f < extraspace.length)
						for (int p=0; p <extraspace[f] + 1; p++)
							str.append(" ");
				}
				rs.add(str.toString()); // one line done
			}
			else {
				rs.add(words[start]);
			}	
			// when out here, i is still a non-fit string, will handle next iteration
		}
		return rs;
		
	}
	
	public static void main(String [] args) {
		TextJustification68 t = new TextJustification68();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(t.fullJustify(words, 16));
		
	}
}
