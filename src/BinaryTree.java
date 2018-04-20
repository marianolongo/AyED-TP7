import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if (root.left == null && root.right == null) {
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
        if (isEmpty()) return 0;
        return (Integer)root.elem + getLeft().sum() + getRight().sum();
    }

    public int sumIfMultipleOf3() {
        if (isEmpty())return 0;
        if((Integer) root.elem % 3 == 0) return (Integer)root.elem + getLeft().sumIfMultipleOf3() + getRight().sumIfMultipleOf3();
        return getLeft().sumIfMultipleOf3() + getRight().sumIfMultipleOf3();
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

    public boolean stable(){
        if (isEmpty()) return true;
        if (root.right == null && root.left == null) return true;
        if ((Integer) root.elem > (Integer) root.right.elem && (Integer) root.elem > (Integer) root.left.elem) return true;
        if ((Integer) root.elem < (Integer) root.right.elem || (Integer) root.elem < (Integer) root.left.elem) return false;
        return getLeft().stable() && getRight().stable();
    }

//    private boolean privateStable(DoubleNode<T> root){
//        if ((Integer) root.elem > (Integer) root.right.elem && (Integer) root.elem > (Integer) root.left.elem) return true;
//        if ((Integer) root.elem < (Integer) root.right.elem || (Integer) root.elem < (Integer) root.left.elem) return false;
//        return privateStable(root.left) && privateStable(root.right);
//    }

   // public boolean treeOccurs(BinaryTree<T> tree){

    //}

    public void front() {
        if (root.left == null && root.right == null) System.out.println(root.elem);
        getRight().front();
        getLeft().front();
    }


    public void writeTree(){
        try {
            ObjectOutputStream outPutTree = new ObjectOutputStream(new FileOutputStream("myObjects.txt"));
            outPutTree.writeObject(this);
            outPutTree.close();
        }
        catch (Exception e){
            System.out.println("Write File Not Found");
        }
    }

    public BinaryTree readTree(){
        try {
            ObjectInputStream inPutTree = new ObjectInputStream(new FileInputStream("myObjects.txt"));
            BinaryTree arBin= (BinaryTree) inPutTree.readObject();
            return arBin;
        }
        catch (Exception e){
            System.out.println("Read File Not Found");
        }
        throw new RuntimeException("There was no tree in the selected file");

        }

    public void byLevels(){
        if(isEmpty()){
            return;
        }
        QueueUs<DoubleNode> queue = new QueueUs<DoubleNode>();
        queue.enque(root);

        while (queue.getSize() > 0){

            DoubleNode current = queue.deque();
            System.out.print(current.elem + " ");

            if (current.left != null)
                queue.enque(current.left);

            if (current.right != null)
                queue.enque(current.right);
        }
    }

    public void postorder() { // Left, Right, Root
        if(isEmpty()) {
            return;
        }
        Stack<DoubleNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            DoubleNode node = stack.peek();

            if(node.left == null && node.right == null) {
                DoubleNode pop = stack.pop();
                System.out.print(pop.elem + " ");;
            }
            else {
                if(node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                if(node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }

    }

    public void inorder() { //Left, Root, Right
        if (isEmpty()) {
            return;
        }
        Stack<DoubleNode> stack = new Stack<DoubleNode>();
        DoubleNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.elem + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public void preorder(){ // Root, Left, Right
        if(isEmpty()){
            return;
        }
        Stack<DoubleNode> stack = new Stack<DoubleNode>();
        stack.push(root);

        while (!stack.empty()) {
            DoubleNode node = stack.peek();
            System.out.print(node.elem + " ");
            stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }
}
