package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * @formatter:off
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *  
 * @formatter:on  
 * @author xiao
 *
 */
public class UniqueBinarySearchTreesII95 {
	public List<TreeNode> generateTrees(int n) {
		return gen(1, n);
	}

	private List<TreeNode> gen(int start, int end) {
		List<TreeNode> rs = new ArrayList<TreeNode>();
		if (start > end)
			return rs;
		else if (start == end) {
			TreeNode n = new TreeNode(start);
			rs.add(n);
			return rs;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> l = gen(start, i - 1);
			List<TreeNode> r = gen(i + 1, end);
			if (l.size() > 0 && r.size() > 0) {
				for (int m = 0; m < l.size(); m++) {
					for (int n = 0; n < r.size(); n++) {
						TreeNode node = new TreeNode(i);
						node.left = l.get(m);
						node.right = r.get(n);
						rs.add(node);
					}
				}
			} else if (l.size() > 0) {
				for (int m = 0; m < l.size(); m++) {
					TreeNode node = new TreeNode(i);
					node.left = l.get(m);
					rs.add(node);
				}
			} else {

				for (int n = 0; n < r.size(); n++) {
					TreeNode node = new TreeNode(i);
					node.right = r.get(n);
					rs.add(node);
				}
			}
		}
		return rs;
	}


	public static void main(String[] args) {
		UniqueBinarySearchTreesII95 t = new UniqueBinarySearchTreesII95();
		Util.printListTreeNodePreOrder(t.generateTrees(3));
	}

}
