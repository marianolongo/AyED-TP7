public class BinaryTree<T> {

    private class DoubleNode<T>{
        T elem;
        DoubleNode <T> right, left;
        public DoubleNode(T o){
            elem = o;
        }

        public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
            elem = o;
            this.right = right;
            this.left = left;
        }
    }
    private DoubleNode<T> root;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(T root){
        this.root = new DoubleNode <T>(root);
    }
    public BinaryTree(T root, BinaryTree<T> tleft, BinaryTree<T> tright){
        this.root = new DoubleNode<T>(root,tleft.root, tright.root);
    }
    public boolean isEmpty(){
        return root == null;
    }

    public T getRoot(){
        return root.elem;
    }

    public BinaryTree<T> getLeft(){
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.left;
        return t;
    }

    public BinaryTree<T> getRight(){
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.right;
        return t;

    }

    public int weight(BinaryTree<T> tree){
        if(tree.isEmpty()){
            return 0;
        }
        return 1 + weight(tree.getLeft()) + weight(tree.getRight());
    }

    public int leaves(BinaryTree<T> tree){
        if (tree.getLeft() == null && tree.getLeft() == null){
            return 1;
        }
        return  leaves(tree.getRight()) + leaves(tree.getLeft());
    }

    public int contains(BinaryTree<T> tree,T elem){
        if(tree.isEmpty()){
            return 0;
        }
        if(tree.root.elem == elem){
            return 1 + contains(tree.getLeft(),elem) +contains(tree.getRight(),elem);
        }
        return contains(tree.getLeft(),elem) +contains(tree.getRight(),elem);
    }

    public int elementsInLevel(int level) {
        if (isEmpty())
            return 0;
        if (level == 1)
            return 1;
        return getLeft().elementsInLevel(level - 1) + getRight().elementsInLevel(level - 1);
    }

    public int heightOfTree(BinaryTree<T> tree) {
        if (tree.root == null) {
            return 0;
        }
        int hLeftSub = heightOfTree(tree.getLeft());
        int hRightSub = heightOfTree(tree.getRight());
        return Math.max(hLeftSub, hRightSub) + 1;
    }
}
