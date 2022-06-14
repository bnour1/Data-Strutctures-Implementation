package homework.binaryTree.atividade_2;

public class Produto implements Comparable<Produto> {
    private String codigo;
    private String descricao;
    private double preco;
    private int inventario;

    public Produto(String codigo, String descricao, double preco, int inventario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.inventario = inventario;
    }

    public Produto(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setInventory(int inventario) {
        this.inventario = inventario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getInventario() {
        return inventario;
    }

    @Override
    public int compareTo(Produto o) {
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", inventario=" + inventario + ", preco="
                + preco + "]";
    }

}
