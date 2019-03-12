package org.gd.code;
/*
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
 */

import java.util.LinkedList;

public class KthSmallest230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> list = new LinkedList();
        while(true){
            if(root != null){
                list.addLast(root);
                root = root.left;
            }else{
                if(--k == 0){
                    return list.getLast().val;
                }else{
                    root = list.getLast().right;
                    list.removeLast();
                }
            }
        }
    }

    private int index=0;
    public int kthSmallest2(TreeNode root, int k) {
        int res = 0;
        if(root == null)
            return res;
        res = kthSmallest(root.left,k);
        if(index == k){
            return res;
        }
        if(++index == k){
            return root.val;
        }
        return kthSmallest(root.right,k);
    }

    private int result =0;
    public int kthSmallest3(TreeNode root, int k) {
        inOrderTraversal(root,k);
        return result;
    }

    private void inOrderTraversal(TreeNode root,int k){
        if(root == null)
            return;
        inOrderTraversal(root.left,k);
        if(++index == k)
            result = root.val;
        inOrderTraversal(root.right,k);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
