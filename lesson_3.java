public class lesson_3 {
    Node head;
    Node tail;

    public static class Node {
        static int value;
        public Node prev;
        public Node next;
        public Node previous;
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = next;
                next.previous = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null){
                if (node.value > node.next.value){
                    Node before = node.prev;
                    Node after = node.next.next;
                    Node next = node.next;
                    node.next = after;
                    node.prev = next;
                    next.next = node;
                    next.prev = before;
                    if (before != null){
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.prev = node;
                    } else {
                        tail = node;
                    }
                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }

    public void add(int value){
        Node node = new Node();
        Node.value = value;
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }

    public Node find(int value) {
        Node currentNode = head;
        while(currentNode != null) {
            if (Node.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
}


