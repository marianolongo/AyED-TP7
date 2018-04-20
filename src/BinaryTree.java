public class BinaryTree<T> {

    private class DoubleNode<T> {
        T elem;
        DoubleNode<T> right, left;

        public DoubleNode(T o) {
            elem = o;
        }

        public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
            elem = o;
            this.right = right;
            this.left = left;
        }
    }

    private DoubleNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T root) {
        this.root = new DoubleNode<T>(root);
    }

    public BinaryTree(T root, BinaryTree<T> tleft, BinaryTree<T> tright) {
        this.root = new DoubleNode<T>(root, tleft.root, tright.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.elem;
    }

    public BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.left;
        return t;
    }

    public BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.right;
        return t;

    }

    public int weight() {
        if (isEmpty()) {
            return 0;
        }
        return 1 + getLeft().weight() + getRight().weight();
    }

    public int leaves() {
        if (getLeft() == null && getRight() == null) {
            return 1;
        }
        return getRight().leaves() + getLeft().leaves();
    }

    public int contains(T elem) {
        if (isEmpty()) {
            return 0;
        }
        if (root.elem == elem) {
            return 1 + getLeft().contains(elem) + getRight().contains(elem);
        }
        return getLeft().contains(elem) + getRight().contains(elem);
    }

    public int elementsInLevel(int level) {
        if (level == 1) {
            if (root != null) {
                return 1;
            } else
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

    public int sum() {
        if (root.elem instanceof Integer) throw new RuntimeException("T is not Integer");
        if (isEmpty()) return 0;
        return getLeft().sum() + getRight().sum();
    }

    public int sumIfMultipleOf3() {
        if (root.elem instanceof Integer) throw new RuntimeException("T is not Integer");
        if (isEmpty() || (Integer) root.elem % 3 != 0) return 0;
        return getLeft().sum() + getRight().sum();
    }

    public boolean myEquals(BinaryTree<T> tree) {
        return equalsNode(this.root, tree.root);
    }

    private boolean equalsNode(DoubleNode<T> node1, DoubleNode<T> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.elem != node2.elem) return false;

        return equalsNode(node1.left, node2.left) && equalsNode(node1.right, node2.right);

    }

    public boolean isomorphic(BinaryTree<T> tree) {
        if(this.myEquals(tree)){
            return true;
        }
        return privateIsomorphic(this.root, tree.root);
    }

    private boolean privateIsomorphic(DoubleNode<T> node1, DoubleNode<T> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return privateIsomorphic(node1.left, node2.left) && privateIsomorphic(node1.right, node2.right);
    }

//    public boolean resembling(BinaryTree<T> tree){
//
//    }

    public boolean isComplete(){
        return privateIsComplete(root.left,root.right);
    }

    private boolean privateIsComplete(DoubleNode<T> left, DoubleNode<T> right) {
        if (right == null && left == null) return true;
        if (right == null || left == null) return false;
        return privateIsComplete(right.left,right.right) && privateIsComplete(left.right,left.left);
    }

    public boolean isFull(){
        boolean result = false;
        for (int i = 0; i < this.heightOfTree(); i++) {
            if(elementsInLevel(i + 1) == Math.pow(2,i)){
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }
}
