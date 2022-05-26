package homework.lcde;

public class Node {

    private Node next;
    private Integer info;
    private Node prev;


    
    public Node(Integer n) {
        this.info = n;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Integer getInfo() {
        return info;
    }
    public void setInfo(Integer info) {
        this.info = info;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
 

    
    
}
