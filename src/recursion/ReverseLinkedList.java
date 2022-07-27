package recursion;

public class ReverseLinkedList {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        System.out.print("Original Linked List: ");
        displayList(n1);
        Node reverseList = reverseList(n1);
        System.out.print("\nReversed Linked List: ");
        displayList(reverseList);
    }

    private static void displayList(Node list) {
        while(list != null) {
            System.out.print(list.getValue()+" ");
            list = list.getNext();
        }
    }

    private static Node reverseList(Node list) {
        //return reverseListIterative(list);
        return reverseListRecursive(list);
    }

    private static Node reverseListIterative(Node list) {
        Node previous = null, current = list, next = null;
        //start with only 2 elements: 1->2->null
        while(current != null) {
            next = current.next;
            current.next = previous; //key point is this : making the first node's next element as null
            previous = current; // then take it out as a previous element
            current = next;
        }
        return previous;
    }

    private static Node reverseListRecursive(Node node) {
        if(node == null || node.next == null) {
            return node;
        }
        Node reverseList = reverseListRecursive(node.next);
        node.next.next = node; //here node is not node.next but actual node element based on it node.next is passed recursively
        node.next = null;
        return reverseList;
    }
}
