public class QueueUs<T> {

    private Node root;
    private Node last;
    private int size;

    public int getSize() {
        return size;
    }

    public QueueUs() {
        root = null;
        last = null;
        size = 0;
    }

    public void enque(T value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else if (last.equals(root)) {
            root.next = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    public T deque() {

        Node exRoot = root;
        root = exRoot.next;
        size--;
        return exRoot.getValue();
    }

    private class Node {
        private T value;
        private Node next;

        Node(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }
    }

}
