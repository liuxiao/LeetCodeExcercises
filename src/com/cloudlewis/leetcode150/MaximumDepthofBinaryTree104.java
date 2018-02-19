package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author xiao
 *
 */
public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if ( root == null)
        	return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    public static void main(String []args) {
    	MaximumDepthofBinaryTree104 t = new MaximumDepthofBinaryTree104();
    	System.out.println(t.maxDepth(Util.generateBST()));
    }
}
