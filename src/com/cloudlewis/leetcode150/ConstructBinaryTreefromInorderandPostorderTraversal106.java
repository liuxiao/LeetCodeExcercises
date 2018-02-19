package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * 
 * @author xiao
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> po = new ArrayList<>();
        int len = inorder.length;
        if (len == 0) return null;
        for (int i=0;i<len;i++){
            in.add(inorder[i]);
            po.add(postorder[i]);
            inmap.put(inorder[i],i);
        }
        return cTree(in, po, inmap, 0);
    }
    
    public TreeNode cTree(List<Integer> in, List<Integer> po, Map<Integer, Integer>map, int offset) {
        int len = in.size();
        TreeNode root = new TreeNode(po.get(len -1)); // get last elem
        int loc = map.get(root.val) - offset;
        if (loc == 0) 
            root.left = null;
        else
            root.left = cTree(in.subList(0, loc), po.subList(0, loc), map, offset);
            
        if (loc >= len -1)
            root.right = null;
        else
            root.right = cTree(in.subList(loc + 1, len), po.subList(loc, len -1), map, offset + loc + 1);
        return root;
    }

	public static void main(String[] args) {
		Util.printTreeNodeInOrder(Util.generateBST());
		Util.printTreeNodePostOrder(Util.generateBST());
	}
}
