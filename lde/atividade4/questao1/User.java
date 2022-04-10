package lde.atividade4.questao1;

public class User implements Comparable<User> {

    private String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int compareTo(User c) {
        return this.id.compareTo(c.getId());
    }

}