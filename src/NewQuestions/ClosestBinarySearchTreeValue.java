package NewQuestions;

public class ClosestBinarySearchTreeValue {

	class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	/*Given a non-empty binary search tree and a target value, 
	 * find the value in the BST that is closest to the target.
	   Note:

		Given target value is a floating point.
		You are guaranteed to have only one unique value in the BST that is 
		closest to the target.
	 */
	
	public int closestValue(TreeNode root, double target) {
        double closest = Math.abs(root.val - target);
        int value = root.val;
        TreeNode current = root;
        while (current != null) {
            if (closest > Math.abs(current.val-target)) {
                closest = Math.abs(current.val-target);
                value = current.val;
            }
            if (current.val < target)
                current = current.right;
            else current = current.left;
        }
        return value; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
