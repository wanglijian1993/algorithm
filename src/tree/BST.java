package tree;

public class BST<E> extends BinaryTree<E>  {

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

    private Node<E> createNode(E value,Node p){
        Node<E> node=new Node<E>(value);
        node.parent=p;
        return node;
    }


    public E remove(E e1) {

        Node<E> node=Node(e1);
         if(node==null)
             return null;
          //有二个Child
          if(node.hasTwoChild()){

              Node<E> temp=node.left;

          }

//        return 0;
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
