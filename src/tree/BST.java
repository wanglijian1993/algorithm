package tree;

public abstract class BST<E> extends BinaryTree<E>  {

   private Comparable<E> comparable;

    public BST(Comparable<E> comparable) {
        this.comparable = comparable;
    }



    public void add(Node<E> e1) {
        if(e1==null)
            return;
         //创建第一个节点
        if(root==null){
            root=createNode(e1.value,null);
            return;
        }
        //找到node所在的位置
        Node<E> node=root;
        Node<E> parent;
        int cmp=0;
        do {
            cmp=compare(node.value,e1.value);
            if(cmp==0)
                return;
            parent=node;
            if(cmp>1){
                node=node.left;
            }else{
                node=node.right;
            }
        }while (node!=null);
        Node<E> newNode = createNode(e1.value, parent);
        if(cmp>1){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        size++;

    }
    protected abstract void afterAdd(Node<E> node);

    protected abstract Node<E> createNode(E element, Node<E> parent);

//    private Node<E> createNode(E value,Node p){
//        Node<E> node=new Node<E>(value);
//        node.parent=p;
//        return node;
//    }


    public void remove(E e1) {

        Node<E> node=Node(e1);
         if(node==null)
             return;
          //有二个Child
          if(node.hasTwoChild()){
              Node<E> predecessor = predecessor(node);
              node.value=predecessor.value;
              // 删除后继节点
              node=predecessor;
          }
          //删除node节点 (node的度必须是0,1)
         Node<E> nChild=node.left==null?node.right:node.left;

          if(nChild!=null){
              Node<E> nParent=node.parent;
              if(nParent==null)
              {
                 //parent root接点
                 root=node;
              }
              else if(nParent.left==node){
                  nParent.left=nChild;
              }else if(nParent.right==node){
                  nParent.right=nChild;
              }

          }else if(node.parent==null){
             //note就是root节点
              root=null;
          }else{
              if (node == node.parent.left) {
                  node.parent.left = null;
              } else { // node == node.parent.right
                  node.parent.right = null;
              }


          }

    }



    public Node<E> contains(E e1) {
      return Node(e1);
    }

    private Node<E> Node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.value);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
    }



    private int compare(E node1,E node2){

        return ((Comparable<E>)node1).compareTo(node2);

    }

}
