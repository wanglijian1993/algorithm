package tree;

import javax.swing.tree.TreeNode;

public class 恢复二叉搜索树 {

    public static void main(String[] args) {

    }

    private static TreeNode first;
    private static TreeNode second;
    private static TreeNode prev;

    public static void recoverTree(TreeNode root) {
        findWrongNode(root);
        int tempValue=first.val;
        first.val=second.val;
        second.val=tempValue;

    }


    public static void findWrongNode(TreeNode node){
        if(node==null){
            return;
        }
        findWrongNode(node.left);
        if(prev!=null&&prev.val>node.val){
            second=node;

            if(first!=null){
                return;
            }
            first=prev;
        }
        prev=node;
        findWrongNode(node.right);
    }



      public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
