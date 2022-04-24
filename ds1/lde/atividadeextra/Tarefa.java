package ds1.lde.atividadeextra;

public class Tarefa implements Comparable<Tarefa>{
    private int prioridade;
    private String descricao;

    public Tarefa(int prioridade, String descricao) {
        this.prioridade = prioridade;
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

    public void setId(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setType(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int compareTo(Tarefa o) {
        if (this.prioridade < o.getPrioridade()) {
            return -1;
        } else if (this.prioridade > o.getPrioridade()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Tarefa [descricao=" + descricao + ", prioridade=" + prioridade + "]";
    }

    
}
