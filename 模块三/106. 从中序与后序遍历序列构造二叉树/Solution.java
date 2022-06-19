/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l2 > r2 || l1 > r1 || l1 > inorder.length || l2 > postorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        int mid = 0;
        while(inorder[mid] != postorder[r2]) mid++;
        // l1 到 mid-1是左子树，mid+1到r1是右子树
        int leftSize = mid - l1;
        root.left = build(l1, mid - 1, l2, l2 + leftSize - 1);
        root.right = build(mid + 1, r1, l2 + leftSize, r2 - 1);
        return root;
    }
}