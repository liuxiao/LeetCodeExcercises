package com.cloudlewis.leetcode100;

import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * @author xiao
 *
 */

// can we only switch the value ? or we have to re-point the node!!
// easy to switch value, but we should do swap node

// preorder / postorder does not work
// can try inorder traverse, and we need another node to store wrong node and
// its parent

public class RecoverBinarySearchTree99 {
	
	public void recoverTreeWithMoris(TreeNode root) {
        // using constant space, assume recursive will take stack spaces
        // using Moris tree traversal
        
        TreeNode node1 =null, node2 =null; // wrong nodes
        TreeNode curr = root, temp = null, pred = null; // pred is used to stored previous, curren should always greater than p
        
        
        while(curr != null) { // moris traversal, and the order should be asc for inorderT
            if (curr.left == null) {
                // CHECK
                if (pred != null && curr.val < pred.val) { // wrong node
	                if (node1 == null)
	                    node1 = pred;
	                node2 = curr;
	            }
                pred = curr;
                curr = curr.right;        
            }
            else {
                temp = curr.left;
                while(temp.right != null && temp.right != curr)
                    temp = temp.right;
                // temp points the rightmost in the curr.left subtree
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    if (pred != null && curr.val < pred.val) { // wrong node
		                if (node1 == null)
		                    node1 = pred;
		                node2 = curr;
		            }
                    pred = curr;
                    curr = curr.right;
                }
            }
        }
                
        if (node1 != null && node2 != null) {
	        // pred should be the wrong one
	        int tmp = node1.val;
	        node1.val = node2.val;
	        node2.val = tmp;
        }
    }
	
	
	public void recoverTree(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode pre = new TreeNode(Integer.MIN_VALUE); // !!! this is a hack, what is the value is MIN_VALUE?
		TreeNode wrongNode = null;
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left; // go all the way left
			}
			root = s.pop(); //
			if (wrongNode == null && root.val <= pre.val) // wrong node
				wrongNode = root;
			else if (wrongNode != null && root.val <= pre.val) {
				int tmp = wrongNode.val;
				wrongNode.val = root.val;
				root.val = tmp;
				break;
			}
			pre = root;
			root = root.right;
		}

	}

	public void test() {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		root.left = n1;
		recoverTree(root);
		Util.printTreeNodePreOrder(root);
	}

	public static void main(String[] args) {
		RecoverBinarySearchTree99 t = new RecoverBinarySearchTree99();
		t.test();
	}
}
