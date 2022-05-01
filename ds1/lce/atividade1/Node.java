package ds1.lce.atividade1;

public class Node {

    private Node next;
    private Book info;
    private Node prev;
    
    public Node(Book info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Book getInfo() {
        return info;
    }

    public void setInfo(Book info) {
        this.info = info;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    
    
}
