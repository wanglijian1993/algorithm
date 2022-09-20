package tree.interfaces;

import tree.BinaryTree;

public interface IBinaryTree {

    int size();


    int isEmpty();

    int preorder();

    int inorder();

    int postOrder();

    int levelOrder();

    void clear();

}
