package com.cloudlewis.leetcode200;

/**
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author xialiliu
 *
 */

// what about 1.0 -- 1.0.0 ?
// we do not assume they all come with dot, may not even one
// assume they should be valid, and nothing start with "." at beginning
public class CompareVersionNumbers165 {
	public int compareVersionConcise(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2))
			return 0;
		// find next dot
		int dot1 = version1.indexOf(".");
		int dot2 = version2.indexOf(".");
		int num1, num2;
		if (dot1 != -1 && dot2 != -1) {
			num1 = Integer.parseInt(version1.substring(0, dot1));
			num2 = Integer.parseInt(version2.substring(0, dot2));
			if (num1 > num2)
				return 1;
			else if (num1 < num2)
				return -1;
			else
				return compareVersion(version1.substring(dot1 + 1), version2.substring(dot2 + 1));
		} else if (dot1 == -1 && dot2 == -1) {
			num1 = Integer.parseInt(version1);
			num2 = Integer.parseInt(version2);
			if (num1 > num2)
				return 1;
			else if (num1 < num2)
				return -1;
			else
				return 0; // should not happen
		} else if (dot1 == -1) {
			num1 = Integer.parseInt(version1);
			num2 = Integer.parseInt(version2.substring(0, dot2));
			if (num1 > num2)
				return 1;
			else if (num1 < num2)
				return -1;
			else
				return compareVersion("0", version2.substring(dot2 + 1));
		} else {
			num1 = Integer.parseInt(version1.substring(0, dot1));
			num2 = Integer.parseInt(version2);
			if (num1 > num2)
				return 1;
			else if (num1 < num2)
				return -1;
			else
				return compareVersion(version1.substring(dot1 + 1), "0");
		}

	}

	public static void main(String[] args) {
		CompareVersionNumbers165 t = new CompareVersionNumbers165();
		System.out.println(t.compareVersion("0.1", "1.1"));
		System.out.println(t.compareVersion("1.1", "1.2"));
		System.out.println(t.compareVersion("1.2", "13.37"));
	}
}
