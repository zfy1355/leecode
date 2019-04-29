package org.gd.code;
 import static org.gd.code.BinaryTreemaxDepth104.TreeNode;
 import static org.gd.code.BinaryTreemaxDepth104.max;

/**
 * 给定一个非空二叉树，返回其最大路径和。

 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

 示例 1:

 输入: [1,2,3]

 1
 / \
 2   3

 输出: 6
 示例 2:

 输入: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7

 输出: 42
 */
public class MaxPathSum124 {

    int result = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if( root == null )
            return 0;
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        result = Math.max(result, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
        if( root == null )
            return 0;
        else {
            dfs(root);
            return result;
        }
     }
}
