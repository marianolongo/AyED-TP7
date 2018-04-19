public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> h1 = new BinaryTree<Integer>(7,new BinaryTree<Integer>(15),new BinaryTree<Integer>(17));
        BinaryTree<Integer> h2 = new BinaryTree<Integer>(9);

        BinaryTree<Integer> b1 = new BinaryTree<Integer>(3,h1,h2);
        BinaryTree<Integer> b2 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<Integer>(13));
        BinaryTree<Integer> b3 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<Integer>(24242));

        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(1,b1,b2);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>(1,b1,b3);


        System.out.println(binaryTree.myEquals(binaryTree2));

        /*
                                  1
                               /     \
                              /       \
                             /         \
                            3           5
                           / \         / \
                          /   \       /   \
                         /     \     /     \
                        7       9   11      13
                       / \
                      /   \
                     /     \
                    15     17
         */    }
}
