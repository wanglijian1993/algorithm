package tree;

import com.sun.jmx.remote.internal.ArrayQueue;
import tree.interfaces.IBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements IBinaryTree {

    protected int size;
    protected Node<E> root;


    @Override
    public int size() {
        return size;
    }

    @Override
    public int isEmpty() {
        return size>0?1:0;
    }

    @Override
    public int preorder() {
        preorder(root);
        return 1;
    }

    private void preorder(Node<E> node){
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }


    @Override
    public int inorder() {
        inorder(root);
        return 1;
    }

    private void inorder(Node<E> node){
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    @Override
    public int postOrder() {
        postOrder(root);
        return 1;
    }

    private void postOrder(Node<E> node){
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    @Override
    public int levelOrder() {

        levelOrder(root);
        return 1;
    }
      //后继节点
      protected Node<E> succsesor(Node<E> e1){
        Node<E> node=e1.right;
        if(node!=null){

            while (node.left!=null){
                node=node.left;
            }
            return node;

        }else{

            while (node.parent!=null&&node.parent.right==node){
                node=node.parent;
            }

        }
        return node.parent;

      }
      //前驱结点
      protected Node<E> predecessor(Node<E> e1){
        Node<E> node=e1.left;
        //如果left不为null直接获取当前left的右节点直至为null
         if(node!=null){
            while (node.right!=null){
                    node=node.right;
            }
            return node;
        }else
        //如果left为null直接获取父节点node!=node.paret.left
        {
            while (node.parent!=null&&node==node.parent.left){
                node=node.parent;
            }
        }
          return node.parent;

      }

    private void levelOrder(Node<E> node){
        if(node==null)
            return;

        Queue<Node<E>> queue=new LinkedList<Node<E>>();
        queue.offer(node);
        while (node!=null){
            Node<E> poll = queue.poll();
            System.out.println(poll.value);
            if(node.left!=null){
               queue.offer(node.left);
            }
            if(node.right!=null){
              queue.offer(node.right);
            }

        }

    }

    @Override
    public void clear() {
        root=null;
        size=0;

    }


    public class Node<E> {

        public Node parent;
        public Node left;
        public Node right;
        public E value;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        public Node(Node parent, Node left, Node right, E value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }
        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }
        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }
        protected boolean hasTwoChild(){
            if(this.left!=null&&this.right!=null){
                return true;
            }
            return false;
        }

        /**
         * left 1
         * right 2
         * nonchild 0
         * @return
         */
        protected int hasChild(){
            if(this.left!=null){
                return 1;
            }else if(this.right!=null){
                return 2;
            }
            return 0;
        }

        /**
         * left 1
         * right 2
         * @return
         */
        protected int direction(){

            if(this==parent.left){
                return 1;
            }
            return 2;
        }
    }
}
