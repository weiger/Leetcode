package leetcode;
import java.util.*;

import leetcode.FlattenBinaryTree.TreeNode;

public class BSTZigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		if(root == null)
			return res;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int level = 0;
		
		while(!queue.isEmpty()){
			int len = queue.size();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < len; i++){
				TreeNode node = queue.poll();
				list.add(node.val);				
				if(level == 0){
					list.add(node.val);
				}else if(level == 1){
					list.addFirst(node.val);
				}
			
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			if(level == 0){
				level = 1;
			}else{
				level = 0;
			}	
			res.add(list);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
