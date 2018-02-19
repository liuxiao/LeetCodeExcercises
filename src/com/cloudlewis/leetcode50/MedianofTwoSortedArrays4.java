package com.cloudlewis.leetcode50;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 *
 * 
 */

// *********REVISIT Boundry section very tricky!!!

// solution 1. making a bigger array of size m + n, scanning through both, inserted into new one O(m+n)
// then get elment (m+n)/2; require extra O(m+n) space
//

// solution 2. median is equal to find the pivot point so that len(left) = len(right)
// if there are m elements, there will be m+1 ways of cutting; so when taking pivot, this should reflect
// 0,1,....i-1 | i,i+1.....m-1 for nums1
// 0,1,....j-1 | j,j+1.....j-1 for nums2
// so that two conditions need to meet
// 1) i-1 + j -1 = (m -1 - i) + (n-1 - j) i.e. left length = right length
// when even: i + j = m + n - i - j --------- j = (m+n)/2 - i
// when odd : i + j = m + n -i - j + 1, leaving the one should be picked on right , j = (m+n+1)/2 -i
//
// 2) nums1[i-1] < nums2[j] && num2[j-1] < nums1[i]
//
// assume m > n
// use binary search find i in m where meet 2), that j = (m+n+1)/2 - i
//
// Time complexity is O(log(min(m,n))), space is O(1)

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m; // to get pivot, use length, instead of length - 1
        while (left <= right) {
            int i = left + (right - left) / 2; // b
            int j = (m + n + 1) / 2 - i;
            if (i > 0 && nums1[i - 1] > nums2[j])
                right = i - 1;
            else if (i < m && nums1[i] < nums2[j - 1])
                left = i + 1;
            else {// (nums1[i-1] < nums2[j] && nums2[j-1] < nums1[i]) { // find it
                int max_left;
                if (i == 0)
                    max_left = nums2[j - 1];
                else if (j == 0)
                    max_left = nums1[i - 1];
                else
                    max_left = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) // odd
                    return max_left;

                int min_right;
                if (i == m)
                    min_right = nums2[j];
                else if (j == n)
                    min_right = nums1[i];
                else
                    min_right = Math.min(nums1[i], nums2[j]);

                return (double) (max_left + min_right) / 2;

            }

        }
        return 0; // should never reach
    }

    // solution 1. with extra space requirement
    public double findMedianSortedArraysWithSpace(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j])
                    arr[k++] = nums1[i++];
                else
                    arr[k++] = nums2[j++];
            } else if (i < m)
                arr[k++] = nums1[i++];
            else // j<n
                arr[k++] = nums2[j++];
        }
        if ((m + n) % 2 == 0) {
            return (double) (arr[(m + n) / 2] + arr[(m + n) / 2 - 1]) / 2;
        } else
            return arr[(m + n) / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5, 8 };
        int[] nums2 = { 2, 6,7 };
        MedianofTwoSortedArrays4 test = new MedianofTwoSortedArrays4();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
