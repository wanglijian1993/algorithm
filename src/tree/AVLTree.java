package tree;

public class AVLTree<E> extends BST<E>{


    public AVLTree(Comparable<E> comparable) {
        super(comparable);
    }

    protected void afterAdd(Node<E> node) {

        while ((node=node.parent)!=null){
            if(isBalance(node)){
                //更新高度
               updateHeight(node);
            }else{
                //计算平衡
               reBalance((AvlNode<E>) node);
            }

        }

    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return null;
    }

    private boolean isBalance(Node avlNode){

        return Math.abs(((AvlNode)avlNode).balanceFactor())<=1;

    }

    private void updateHeight(Node avlNode){
        ((AvlNode)avlNode).updateHeight();
    }

    private void reBalance(AvlNode<E> grande){

        AvlNode<E> parent=grande.tallerChild(grande);
        AvlNode<E> node=parent.tallerChild(parent);

       if(parent.isLeftChild()){

           if(node.isLeftChild()){
              //LL
               rotateRight(grande,parent,node);
           }else{
               //LR
               rotateLeft(grande,parent,node);
               rotateRight(grande,parent,node);
           }

       }else{
          //right=parent
          if(node.isRightChild()){
              //RR
              rotateLeft(grande,parent,node);

          } else{
              //RL
              rotateRight(grande,parent,node);
              rotateLeft(grande,parent,node);

          }
       }
    }

    private void rotateLeft(AvlNode<E> g,AvlNode<E> p,AvlNode<E> n){
        g.right=p.left;
        p.right=g;
        p.parent=g.parent;
        if(g.parent.left==g){
            g.parent.left=p;
        }else{
            g.parent.right=p;
        }
        g.parent=p;
        n.parent=g;
        updateHeight(p);
        updateHeight(g);
    }

    private void rotateRight(AvlNode<E> g, AvlNode<E> p ,AvlNode n){

       g.left=p.right;
       p.right=g;
       p.parent=g.parent;
       if(g.parent.left==g){
           g.parent.left=p;
       }else{
           g.parent.right=p;
       }
       g.parent=p;
       n.parent=g;
       updateHeight(p);
       updateHeight(g);

    }





    class AvlNode<E> extends Node<E>{


       protected int height=1;


        protected void updateHeight(){
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>)right).height;
             height=Math.max(leftHeight,rightHeight)+1;
        }

        private int balanceFactor(){
            return ((AvlNode)left).height-((AvlNode)right).height;
        }

        private AvlNode<E> tallerChild(AvlNode<E> avlNode){
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>)right).height;
            if(leftHeight>rightHeight){
                return (AvlNode<E>) left;
            }else{
                return (AvlNode<E>) right;
            }
        }


    }

}
