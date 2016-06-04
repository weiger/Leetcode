package Locked;
import java.util.*;

public class BinaryTreeUpsideDown {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * Given a binary tree where all the right nodes are either leaf nodes 
	 * with a sibling (a left node that shares the same parent node) or empty, 
	 * flip it upside down and turn it into a tree where the original right nodes 
	 * turned into left leaf nodes. Return the new root.
	 */
	
	public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode parent = null, parentRight = null;
        TreeNode node = null;
        
        while(root != null){
            TreeNode left = root.left;
            root.left = parentRight;
            parentRight = root.right;
            root.right = parent;
            parent = root;
            
            node = root;
            root = left;
        }
        return node;
    }
	
	public static void levelOrder(TreeNode root){
		if(root == null)
			return ;
		
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,0,res);
		
		System.out.println(res);
	}
	
	public static void dfs(TreeNode root, int level, List<List<Integer>> res){
		if(root == null) return ;
		
		if(res.size() < level+1)
			res.add(new ArrayList<>());
		
		res.get(level).add(root.val);
		
		dfs(root.left, level+1,res);
		dfs(root.right,level+1,res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        
        TreeNode node1 = upsideDownBinaryTree(a);
        levelOrder(node1);
	}

}
