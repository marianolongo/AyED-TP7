public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> h1 = new BinaryTree<Integer>(7,new BinaryTree<Integer>(15),new BinaryTree<Integer>(17));
        BinaryTree<Integer> h2 = new BinaryTree<Integer>(9);
        BinaryTree<Integer> h3 = new BinaryTree<Integer>(12);

        BinaryTree<Integer> b1 = new BinaryTree<Integer>(3,h1,h2);
        BinaryTree<Integer> b5 = new BinaryTree<Integer>(3,h1,h3);


        BinaryTree<Integer> d1 = new BinaryTree<>(19);
        BinaryTree<Integer> d2 = new BinaryTree<>(21);

        BinaryTree<Integer> b2 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<Integer>(13));
        BinaryTree<Integer> b3 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(11),new BinaryTree<>());
        BinaryTree<Integer> b4 = new BinaryTree<Integer>(5,new BinaryTree<Integer>(13,d1,d2),new BinaryTree<Integer>(13));

        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(1,b1,b2);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>(1,b5,b3);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<Integer>(100, new BinaryTree<Integer>(50,new BinaryTree<Integer>(25), new BinaryTree<>(200)),new BinaryTree<Integer>(40,new BinaryTree<Integer>(15), new BinaryTree<>(10)));


             /*
             binaryTree

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

             ------------------------------------
          binaryTree2
                      1
                   /     \
                  /       \
                 /         \
                3           5
               / \         /
              /   \       /
             /     \     /
            7       12  11
           / \
          /   \
         /     \
        15     17
    */

//        binaryTree.writeTree(); // Agrega el arbol al disco
//
//        System.out.println("Agarra el arbol del disco:");
//        binaryTree.readTree();
//        System.out.println();

        System.out.println("Weight:");
        System.out.println(binaryTree.weight());
        System.out.println();

        System.out.println("Leaves:");
        System.out.println( binaryTree.leaves());
        System.out.println();

        System.out.println("Contains number 7:");
        System.out.println(binaryTree.contains(7));
        System.out.println();

        System.out.println("Number of elements in level 3:");
        System.out.println(binaryTree.elementsInLevel(3));
        System.out.println();

        System.out.println("Height:");
        System.out.println(binaryTree.heightOfTree());
        System.out.println();

        System.out.println("Sum of all elements:");
        System.out.println(binaryTree.sum());
        System.out.println();

        System.out.println("Sum of all elements % 3:");
        System.out.println(binaryTree.sumIfMultipleOf3());
        System.out.println();

        System.out.println("binarytree1 equals binarytree2");
        System.out.println(binaryTree.myEquals(binaryTree2));
        System.out.println();

        System.out.println("binarytree1 isomorphic binarytree2:");
        System.out.println(binaryTree.isomorphic(binaryTree2));
        System.out.println();

        System.out.println("Resembling:"); //binaryTree semejante a binaryTree2
        System.out.println(binaryTree.resembling(binaryTree2));
        System.out.println();

        System.out.println("isComplete:");
        System.out.println(binaryTree.isComplete());
        System.out.println();

        System.out.println("isFull:");
        System.out.println(binaryTree.isFull());
        System.out.println();

        System.out.println("Stable:");
        System.out.println(binaryTree.stable());
        System.out.println();

        System.out.println("Occurs:");
        System.out.println(binaryTree.treeOccurs(b2)); //b2 es rama de binaryTree, asi que deberia dar true.
        System.out.println();

        System.out.println("Front:");
        binaryTree.front();
        System.out.println();

        System.out.println("ArrayList of Front:");
        System.out.println(binaryTree.listOfLeaves());
        System.out.println();


        System.out.println("Preorder:");
        binaryTree.preorder();
        System.out.println();

        System.out.println("Preorder:");
        binaryTree.preorder();
        System.out.println();


        System.out.println("ByLevels:");
        binaryTree.byLevels();
        System.out.println();

        System.out.println("Preorder:");
        binaryTree.preorder();
        System.out.println();

        System.out.println("Inorder:");
        binaryTree.inorder();
        System.out.println();

        System.out.println("Postorder:");
        binaryTree.postorder();

    }
}
