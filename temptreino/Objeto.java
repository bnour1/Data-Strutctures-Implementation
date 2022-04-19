package temptreino;

public class Objeto implements Comparable<Objeto>{
    private int id;
    private String type;

    public Objeto(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Objeto o) {
        if (this.id < o.getId()) {
            return -1;
        } else if (this.id > o.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Objeto [id=" + id + ", type=" + type + "]";
    }
}
