package leetcode;

import java.util.*;

import javax.swing.tree.TreeNode;

public class FlattenBinaryTree {

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
        
        Stack<TreeNode> tree = new Stack<TreeNode>();
        tree.push(root);
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        while(tree != null){
            TreeNode temp = tree.pop();
            list.add(temp);
            
            if(temp.right != null)
                tree.add(root.right);
            if(temp.left != null)
                tree.add(root.left);
        }
        
        for(TreeNode i:list)
        	System.out.println(i);
    }
	
	public static void main(String[] args) {
		

	}

}
