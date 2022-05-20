package lcde_streamplat.Model;

// Objeto Node Principal com metodos obrigatorios
public class MainNode {

    private MainNode prev;
    private Genre data;
    private MainNode next;
    
    public MainNode(Genre data) {
        this.data = data;
    }

    public MainNode getPrev() {
        return prev;
    }

    public void setPrev(MainNode prev) {
        this.prev = prev;
    }

    public Genre getData() {
        return data;
    }

    public void setData(Genre data) {
        this.data = data;
    }

    public MainNode getNext() {
        return next;
    }

    public void setNext(MainNode next) {
        this.next = next;
    }
}
