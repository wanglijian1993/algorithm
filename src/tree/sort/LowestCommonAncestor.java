package tree.sort;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root==p||root==q){
            return root;
        }

        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);
         //leftNode!=null rightNode!=null 为根节点
        if(leftNode!=null&&rightNode!=null){
            return root;
        }

        //没在树种
        if(leftNode==null&&rightNode==null){
            return null;
        }
        if(leftNode!=null){
            return leftNode;
        }
        // 情况 3 ： p, q 只有1个在root 为根的树中
        return leftNode == null ? rightNode : leftNode;

    }


    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

}
