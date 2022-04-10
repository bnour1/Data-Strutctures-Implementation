package lde.atividade4.questao4;

/*
4 - Considere uma lista linear duplamente encadeada (vazia ou não) cujos nós devem
armazenar objetos da classe Pessoa (Atributos: RG, nome, idade, gênero (M/F), peso e altura).
Considere ainda a existência de duas outras listas duplamente encadeadas que estão
inicialmente vazias e que devem ser preenchidas da seguinte forma: a primeira, com os dados
das pessoas do gênero masculino encontradas na lista principal; a segunda, com os dados das
pessoas do gênero feminino encontradas na lista principal. Implemente um método que irá
percorrer a lista principal e quebrá-la em duas, fazendo o preenchimento das duas outras listas,
segundo o critério acima especificado.
OBS1: A lista geral não está ordenada, porém as listas geradas pelo método a ser implementado
devem estar ordenadas por RG.
OBS2: O campo que identifica unicamente uma pessoa é o RG. A lista original pode conter mais
de uma ocorrência da mesma pessoa (mesmo RG), porém as duas novas listas geradas não
podem conter pessoas com mesmo RG (ou seja, uma pessoa não pode aparece mais de uma
vez nas listas geradas).
OBS3: Ao final da execução do método, a lista original deve estar vazia.
OBS4: O método implementado deve receber como parâmetro as duas listas vazia a serem
preenchidas.
*/

public class MetodosQuestao4 {

    protected Node ultimo;
    protected Node primeiro;
    protected int qtd;

    public boolean isEmpty() {

        if (this.primeiro == null && qtd == 0 && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    // Logica para a questão 4 
    public void separarPorGenero(MetodosQuestao4 womanList, MetodosQuestao4 manList){
        Pessoa pessoaInserir;
        String rg, nome;
        int idade;
        char genero;
        double peso, altura;
        Node aux = this.primeiro;
        while(aux != null){
            // Variaveis que só tão ai pra ficar legivel kkkkkkkkk
            pessoaInserir = aux.getInfo();
            rg = pessoaInserir.getRg();
            nome = pessoaInserir.getNome();
            idade = pessoaInserir.getIdade();
            genero = pessoaInserir.getGenero();
            peso = pessoaInserir.getPeso();
            altura = pessoaInserir.getAltura();
            pessoaInserir = new Pessoa(rg, nome, idade, genero, peso, altura);
            if(aux.getInfo().getGenero() == 'F'){
                pessoaInserir = new Pessoa(rg, nome, idade, genero, peso, altura);
                womanList.inserirOrdenadoSR(aux.getInfo());
            }else{
                pessoaInserir = new Pessoa(rg, nome, idade, genero, peso, altura);
                manList.inserirOrdenadoSR(aux.getInfo());
            }
            aux = aux.getProx();
        }

        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }

    // metodo de inserção ordenada sem repetição :)
    public void inserirOrdenadoSR(Pessoa c) {
        Node novo = new Node(c);
        if (this.isEmpty() == true) { // inserção na lista vazia
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        } else if (c.compareTo(this.primeiro.getInfo()) < 0) { // inserção antes do primeiro
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            this.qtd++;
        } else if (c.compareTo(this.ultimo.getInfo()) > 0) { // inserção após o último
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
        } else {
            Node aux = this.primeiro;
            int result;
            while (aux != null) {
                result = c.compareTo(aux.getInfo());

                if (result == 0) {
                    return;
                } else if (result < 0) {
                    novo.setAnt(aux.getAnt());
                    novo.setProx(aux);
                    aux.getAnt().setProx(novo);
                    aux.setAnt(novo);
                    this.qtd++;
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    // Metodo de inserção Ordenada com repetição :)
    public void inserirOrdenado(Pessoa c) {
        Node novo = new Node(c);
        if (this.isEmpty() == true) { // inserção na lista vazia
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        } else if (c.compareTo(this.primeiro.getInfo()) <= 0) { // inserção antes do primeiro
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            this.qtd++;
        } else if (c.compareTo(this.ultimo.getInfo()) > 0) { // inserção após o último
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
        } else {
            Node aux = this.primeiro;
            int result;
            while (aux != null) {
                result = c.compareTo(aux.getInfo());

                if (result <= 0) {
                    novo.setAnt(aux.getAnt());
                    novo.setProx(aux);
                    aux.getAnt().setProx(novo);
                    aux.setAnt(novo);
                    this.qtd++;
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    // Metodo pra exibir qlqr lista :D
    public void exibirLista() {

        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Não existem clientes cadastrados!");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

}