package NewQuestions;

import java.util.*;

public class BinaryTreeConsecutiveSequence {

	static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// Iteration
	public int getConsecutiveLength(TreeNode root){
		if(root == null) 
			return 0;
		
		List<TreeNode> nodes = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		
		nodes.add(root);
		counts.add(1);
		
		int maxLen = 0;
		
		while(!nodes.isEmpty()){
			TreeNode node = nodes.remove(0);
			int count = counts.remove(0);
			
			if(node.left != null){
				nodes.add(node.left);
				
				if(node.left.val == (node.val+1))
					counts.add(count+1);
				else
					counts.add(1);
			}
			
			if(node.right != null){
				nodes.add(node.right);
				
				if(node.right.val == (node.val+1))
					counts.add(count+1);
				else
					counts.add(1);
			}
			
			maxLen = Math.max(maxLen, count);
			
		}
		return maxLen;
		
	}
	
	
	// Recursion
	public int getLength(TreeNode root){
		return maxLength(root,null,0);
	}
	
	public int maxLength(TreeNode cur, TreeNode parent, int len){
		if(cur == null) return len;
		
		len = parent != null && cur.val == parent.val+1? len+1 : 1;
		
		return Math.max(len, Math.max(maxLength(cur.left,cur,len), maxLength(cur.right,cur,len)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		
		System.out.println(new BinaryTreeConsecutiveSequence().getConsecutiveLength(root));
		System.out.println(new BinaryTreeConsecutiveSequence().getLength(root));
		
		
		TreeNode root2 = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.right.left = new TreeNode(2);
		root2.right.left.left = new TreeNode(1);
		
		System.out.println(new BinaryTreeConsecutiveSequence().getConsecutiveLength(root2));
		System.out.println(new BinaryTreeConsecutiveSequence().getLength(root2));
	}

}
