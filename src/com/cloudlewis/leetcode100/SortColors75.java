package com.cloudlewis.leetcode100;

/**
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author xiao
 *
 */

// sorting problem? stupid, using O(nlogN), quick sort
// if only three, we could use pointers to swap?
// !!!! FOLLOW UP WAY IS GOOD!
// https://discuss.leetcode.com/topic/6968/four-different-solutions

public class SortColors75 {
	
	// two pass O(m+n) space
	void sortColors1(int A[], int n) {
	    int num0 = 0, num1 = 0, num2 = 0;
	    
	    for(int i = 0; i < n; i++) {
	        if (A[i] == 0) ++num0;
	        else if (A[i] == 1) ++num1;
	        else if (A[i] == 2) ++num2;
	    }
	    
	    for(int i = 0; i < num0; ++i) A[i] = 0;
	    for(int i = 0; i < num1; ++i) A[num0+i] = 1;
	    for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
	}

	// one pass in place solution
	void sortColors2(int A[], int n) {
	    int n0 = -1, n1 = -1, n2 = -1;
	    for (int i = 0; i < n; ++i) {
	        if (A[i] == 0) 
	        {
	            A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
	        }
	        else if (A[i] == 1) 
	        {
	            A[++n2] = 2; A[++n1] = 1;
	        }
	        else if (A[i] == 2) 
	        {
	            A[++n2] = 2;
	        }
	    }
	}

	// one pass in place solution
	void sortColors3(int A[], int n) {
	    int j = 0, k = n - 1;
	    for (int i = 0; i <= k; ++i){
	        if (A[i] == 0 && i != j)
	            swap(A, i--, j++);
	        else if (A[i] == 2 && i != k)
	            swap(A, i--, k--);
	    }
	}

	// one pass in place solution
	void sortColors4(int A[], int n) {
	    int j = 0, k = n-1;
	    for (int i=0; i <= k; i++) {
	        if (A[i] == 0)
	            swap(A, i, j++);
	        else if (A[i] == 2)
	            swap(A, i--, k--);
	    }
	}
	
	private void swap(int[] a, int i , int j) {
		int tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;
	}
}
