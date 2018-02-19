package com.cloudlewis.leetcode200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * @formatter:off 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 * 
 * @formatter:on
 * @author xiao
 *
 */

// using stack to traverse the tree, easy
// problem is can we not using O(n) space
public class BinaryTreeRightSideView199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				TreeNode node = q.poll();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				size--;
				if (size == 0) // list element, most right
					list.add(node.val);
			}
		}
		return list;
	}
	

	public List<Integer> rightSideViewNoExtraSpace(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    private void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
	
	public static void main(String[] args) {
		BinaryTreeRightSideView199 t = new BinaryTreeRightSideView199();
		System.out.println(t.rightSideView(Util.generateBST()));
	}
}
