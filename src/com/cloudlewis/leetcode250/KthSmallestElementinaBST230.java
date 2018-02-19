package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author xiao
 *
 */

// to optimize, keep number of children on the node?

public class KthSmallestElementinaBST230 {
    public int kthSmallest(TreeNode root, int k) {
        int countLeft = countNode(root.left);
        if (k <= countLeft)
        	return kthSmallest(root.left, k);
        else if (k > countLeft + 1)
        	return kthSmallest(root.right, k - countLeft - 1);
        
        return root.val;
    }
    
    private int countNode(TreeNode node) {
    	if (node == null)
    		return 0;
    	return (1 + countNode(node.left) + countNode(node.right));
    }
}
