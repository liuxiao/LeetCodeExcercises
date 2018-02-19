package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @formatter:off
 * For example,
 * Given
 * 
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 * 
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *            
 * @formatter:on
 * @author xiao
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */

// !!! REVISIT

// solution 1. pre-order traverse, put them into arraylist and link

// solution 2. SMART! iterative

public class FlattenBinaryTreetoLinkedList114 {
	private TreeNode prev = null;

	public void flattenInterative(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
            	//Find current node's prenode that links to current node's right subtree
                TreeNode pt = root.left;
                while (pt.right != null) pt = pt.right;
                pt.right = root.right;
                //Use current node's left subtree to replace its right subtree(original right 
                //subtree is already linked by current node's prenoder
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
	
	public void flatten(TreeNode root) {
	    if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
}
