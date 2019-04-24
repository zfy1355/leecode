package org.gd.code;

/**
 * 定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 */
public class BinaryTreemaxDepth104 {

    /**
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return max(root,1);
    }

    public static int max(TreeNode root, int n){
        if(root.left == null && root.right == null) {
            return n;
        }else if(root.left != null && root.right == null){
            return max(root.left,++n);
        }else if(root.right != null && root.left == null){
            return max(root.right,++n);
        }else{
            n++;
            int left = max(root.left,n);
            int right = max(root.right,n);
            return left>right?left:right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(maxDepth2(treeNode));
    }

    /**
     * 精简
     * @param root
     * @return
     */
    static int maxDepth2(TreeNode root) {
        if(root==null) return 0;
        else
        {
            int left=maxDepth(root.left);//每次都需要重新建立，保持上一次的值
            int right=maxDepth(root.right);//每次都需要重新建立，保持上一次的值
            return 1+(left>right?left:right);
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
