package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.basic.MorrisTraverse;
import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * 
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @formatter:on
 * @author xiao
 *
 */

// use Moris traversal
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        TreeNode curr = root;
        while( curr != null) {
        	if (curr.left == null) {
        		rs.add(curr.val);
        		curr = curr.right;
        	}
        	else {
        		TreeNode pre = curr.left; // 
        		while(pre.right != null && pre.right != curr)
        			pre = pre.right;
        		if (pre.right == curr) { // remove the link
        			pre.right = null;
        			curr = curr.right;
        		}
        		else {
        			rs.add(curr.val);
        			pre.right = curr;
        			curr = curr.left;
        		}
        		
        	}
        }
        return rs;
    }
    
    public static void main(String [] args) {
    	BinaryTreePreorderTraversal144 t = new BinaryTreePreorderTraversal144();
    	System.out.println(t.preorderTraversal(Util.generateBST()));
    	List<TreeNode> list = MorrisTraverse.preOrderTraverse(Util.generateBST());
    	for (TreeNode n : list)
    		System.out.println(n.val + " " );
    }
}
