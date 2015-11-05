package Locked;

public class BinaryTreeUpsideDown {

	class TreeNode {
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
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
