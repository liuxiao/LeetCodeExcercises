package com.cloudlewis.leetcode250;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * @author xiao
 *
 */

/*
 * Solution 1. feel like we could just calculate the sum of both and then delete
 * the overlap ordering of the coornidate might be different from images....
 * cautious OR the question guarantee the ordering? the way it present the
 * points?
 * 
 */
public class RectangleArea223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int tarea = (C-A) * (D-B) + (G-E) * (H - F);
		// cal overlap
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		
		int overlap = 0;
		if (top > bottom && right > left)
			overlap = (top - bottom) * (right - left);
		
		return tarea - overlap;
	}
	
	public static void main(String [] args) {
		RectangleArea223 t = new RectangleArea223();
		System.out.println(t.computeArea(-3	, 0, 3, 4, 0, -1, 9, 2));
	}
}
