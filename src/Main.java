public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> h1 = new BinaryTree<Integer>(7,new BinaryTree<Integer>(15),new BinaryTree<Integer>(17));
        BinaryTree<Integer> h2 = new BinaryTree<Integer>(9);

        BinaryTree<Integer> b1 = new BinaryTree<Integer>(3,h1,h2);
        BinaryTree<Integer> d1 = new BinaryTree<>(19);
        BinaryTree<Integer> d2 = new BinaryTree<>(21);

        BinaryTree<Integer> b2 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<Integer>(13));
        BinaryTree<Integer> b3 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<Integer>(null));
        BinaryTree<Integer> b4 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(13,d1,d2),new BinaryTree<Integer>(13));

        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(1,b1,b2);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>(1,b1,b4);


        System.out.println(binaryTree.isomorphic(binaryTree2));

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
         */
    }
}
