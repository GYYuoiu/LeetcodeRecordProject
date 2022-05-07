package LFU;

public class DoubleLinkedList {
    int size;
    Node head, tail;

    DoubleLinkedList(){
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        size ++;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size --;
    }
    public Node getHead(){
        return head.next;
    }
    public Node getTail(){
        return tail.prev;
    }
}
