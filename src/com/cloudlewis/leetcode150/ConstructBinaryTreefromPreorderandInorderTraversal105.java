package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author xiao
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) { // can use binary search
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	public TreeNode buildTreeWithHash(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> ino = new HashMap<Integer, Integer>();
		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> in = new ArrayList<Integer>();
		int len = inorder.length;
		if (len == 0)
			return null;
		for (int i = 0; i < len; i++) {
			ino.put(inorder[i], i); // cache the number with its location
			pre.add(preorder[i]);
			in.add(inorder[i]);
		}
		return constructTree(pre, in, ino, 0);
	}

	public TreeNode constructTree(List<Integer> preorder, List<Integer> inorder, Map<Integer, Integer> ino,
			int mapoffset) {
		int len = preorder.size(); // size of two lists should be the same
		// first node of preorder should always be the root
		TreeNode root = new TreeNode(preorder.get(0));
		int loc = ino.get(root.val) - mapoffset;// find the root within map to
												// get location
		// left to loc should be on the left of root, loc to right should be on
		// the right of the root
		if (loc == 0)
			root.left = null;
		else
			root.left = constructTree(preorder.subList(1, loc + 1), inorder.subList(0, loc), ino, mapoffset);
		if (len <= loc + 1)
			root.right = null;
		else // !BECAREFUL -> offset is incremental
			root.right = constructTree(preorder.subList(loc + 1, len), inorder.subList(loc + 1, len), ino,
					mapoffset + loc + 1);
		return root;
	}

	public static void main(String[] args) {
		Util.printTreeNodePreOrder(Util.generateBST());
		Util.printTreeNodeInOrder(Util.generateBST());
	}
}
