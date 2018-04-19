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

    public int weight(){
        if(isEmpty()){
            return 0;
        }
        return 1 + getLeft().weight() + getRight().weight();
    }

    public int leaves(){
        if (getLeft() == null && getRight() == null){
            return 1;
        }
        return  getRight().leaves() + getLeft().leaves();
    }

    public int contains(T elem){
        if(isEmpty()){
            return 0;
        }
        if(root.elem == elem){
            return 1 + getLeft().contains(elem) +getRight().contains(elem);
        }
        return getLeft().contains(elem) + getRight().contains(elem);
    }

    public int elementsInLevel(int level) {
        if (level == 1){
            if (root.elem != null) {
                return 1;
            }else
                return 0;
        }

        return getLeft().elementsInLevel(level - 1) + getRight().elementsInLevel(level - 1);
    }

    public int heightOfTree() {
        if (root == null) {
            return 0;
        }
        int hLeftSub = getLeft().heightOfTree();
        int hRightSub = getRight().heightOfTree();
        return Math.max(hLeftSub, hRightSub) + 1;
    }
}
