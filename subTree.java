/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
        	return true;
        }
        if (T1 == null || T2 == null) {
        	return T1 == T2;
        }
        if (isEqual(T1, T2)){
        	return true;
        }
        if (isSubtree(T1.left, T2)) {
        	return true;
        }
        if (isSubtree(T1.right, T2)) {
        	return true;
        }
        return false;
        
    }

    private boolean isEqual(TreeNode root1, TreeNode root2) {
    	if (root1 == null && root2 == null) {
    		return true;
    	}
    	if (root1 == null || root2 == null) {
    		return root1 == root2;
    	}
    	if (root1.val != root2.val) {
    		return false;
    	}
    	return isEqual(root1.left, root2.left) && isEqual(root2.right, root2.right);
    }
}