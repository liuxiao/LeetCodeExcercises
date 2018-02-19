package com.cloudlewis.leetcode50;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 * 
 * 
 */

// question only asks for the length, not care about the actual value
// asking what could be the input of the script, does it contains special characters, should ASCII or fix size of array
// of 26
// for this question, use 255, as it can be pratical for most use cases

// adapt a two cursor design, store the value of all character in a mask; space O(n) worst case when there is no repeat
// at all
// runtime will be O(n) as we scan list only once

//***** catch is if we intialize the array to be all 0, then we cannot use 0 to determine contains value or not!
//***** catch Math.max(loc, mask[s.charAt(i-1)] + 1), if two same character, we need should not add one from loc, but use loc

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1)
            return s.length();
        int loc = 1, max = 1, len = s.length();
        int[] mask = new int[255]; // by java spec, all guaranteed to be 0
        for (int i = 1; i <= len; i++) {
            if (mask[s.charAt(i-1)] != 0) // contains the value
                loc = Math.max(loc, mask[s.charAt(i-1)] + 1) ; // move the cursor to the next
            mask[s.charAt(i-1)] = i; // mark regardless of conflict or not
            if (i - loc + 1 > max)
                max = i - loc + 1;
        }
        return max;
    }
}
