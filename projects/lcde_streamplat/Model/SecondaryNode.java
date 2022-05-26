package projects.lcde_streamplat.Model;

//Node Secundário
public class SecondaryNode {
    private SecondaryNode prev;
    private Movie data;
    private SecondaryNode next;
    
    public SecondaryNode(Movie data) {
        this.data = data;
    }

    public SecondaryNode getPrev() {
        return prev;
    }

    public void setPrev(SecondaryNode prev) {
        this.prev = prev;
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

    public SecondaryNode getNext() {
        return next;
    }

    public void setNext(SecondaryNode next) {
        this.next = next;
    }
    
}