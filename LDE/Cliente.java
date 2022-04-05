package LDE;

public class Cliente implements Comparable<Cliente>{

    private String cpf;
    private String nome;
    private String fone;
    private String email;

    public Cliente(String c) {
        this.cpf = c;
    }

    public Cliente(String c, String n, String f, String e) {
        this.cpf = c;
        this.nome = n;
        this.fone = f;
        this.email = e;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", email=" + email + ", fone=" + fone + ", nome=" + nome + "]";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int compareTo(Cliente c){
        return this.cpf.compareTo(c.getCpf());
    }

}