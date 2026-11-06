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
    List<Integer> ans = new ArrayList<>();
    int max = 0;
    int count = 0;
    Integer prev = null;

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && prev == root.val) {
            count++;
        } else {
            count = 1;
        }

        if (count > max) {
            max = count;
            ans.clear();
            ans.add(root.val);
        } else if (count == max) {
            ans.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
}
