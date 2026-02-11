
public class Node {
    protected String item; // stores the grocery item
    protected Node next;   // stores the next Node in the Linked List

    // No-param default constructor
    public Node() {
        this.item = null;
        this.next = null;
    }

    // 1-param constructor
    public Node(String item) {
        this.item = item;
        this.next = null;
    }

    // 2-param constructor
    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }
}