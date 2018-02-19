package com.cloudlewis.leetcode.basic;

public class MatrixMultiply {
	
	// if m1 is x by y, then m2 must be y by x
	public static int[][] standardMultiple(int[][] m1, int[][] m2) {
		int m = m1.length, n = m1[0].length;
		int[][] rs = new int[m][m];
		for (int i=0;i<m;i++) {
			for (int j= 0;j<m;j++) {
				for (int k = 0; k < n; k++)
					rs[i][j] += m1[i][k] * m2[k][j];
				
			}
		}
		return rs;
	}
	
	public static void main(String[] args) {
		int [][] a = new int[][] {{1,0,-2}, {0,3,-1}};
		int [][] b = new int[][] {{0, 3},{-2, -1}, {0, 4}};
		int [][] rs = MatrixMultiply.standardMultiple(a, b);
		for(int i=0; i< rs.length; i++){
			for (int j=0; j<rs[0].length;j++)
				System.out.print(rs[i][j] + " ");
			System.out.println();
		}
		
	}
}
