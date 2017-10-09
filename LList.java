public class LList {
    public Node first;

    public LList() {
        first = null;
    }

    public void enqueue(Node x) {
        Node T;
        if (first == null) {
            first = x;
        }  else {
            T = first;
            while(T.next != null ) {
                T = T.next;
            }
            T.next = x;
        }
    }

    public void dequeue() {
        if (first != null) {
            first = first.next;
        }
    }
}
