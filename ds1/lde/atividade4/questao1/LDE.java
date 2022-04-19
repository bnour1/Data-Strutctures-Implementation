package ds1.lde.atividade4.questao1;

public class LDE {

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

    public LDE intersection(LDE lista2) {
        LDE lista = new LDE();
        if (lista2.isEmpty() || isEmpty()) {
            System.out.println("Uma das listas está vazia");
            return null;
        } else {
            Node runList1 = this.primeiro;
            Node runList2 = lista2.primeiro;
            while (runList1 != null) {
                while (runList2 != null) {
                    if (runList2.getInfo().compareTo(runList1.getInfo()) == 0) {
                        lista2.inserirOrdenado(runList1.getInfo());
                    }
                    runList2 = runList2.getProx();
                }
                runList1 = runList1.getProx();
                runList2 = lista2.primeiro;
            }
            return lista;
        }
    }

    public Node searchNode(Node procurado) {
        Node aux = this.primeiro;
        while (aux != null) {
            if (aux.getInfo().compareTo(procurado.getInfo()) == 0) {
                return aux;
            }

            aux = aux.getProx();
        }
        return null;
    }

    public LDE diferenca(LDE lista2) {
        LDE lista = new LDE();
        if (lista2.isEmpty() || isEmpty()) {
            System.out.println("Uma das listas está vazia");
            return null;
        } else {
            Node runList1 = this.primeiro;

            while (runList1 != null) {
                if (lista2.searchNode(runList1) == null) {
                    lista.inserirOrdenadoSR(runList1.getInfo());
                }

                runList1 = runList1.getProx();

            }

            return lista;
        }
    }

    public LDE uniao(LDE lista2) {
        LDE lista = new LDE();
        if (lista2.isEmpty() || isEmpty()) {
            System.out.println("Uma das listas está vazia");
            return null;
        } else {
            Node runList1 = this.primeiro;
            Node runList2 = lista2.primeiro;
            while (runList1 != null && runList2 != null) {
                lista.inserirOrdenadoSR(runList1.getInfo());
                runList1 = runList1.getProx();
            }

            while (runList2 != null) {
                lista.inserirOrdenadoSR(runList2.getInfo());
                runList2 = runList2.getProx();
            }

            return lista;

        }

    }

    public void inserirOrdenadoSR(User c) {
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

    public void inserirOrdenado(User c) {
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