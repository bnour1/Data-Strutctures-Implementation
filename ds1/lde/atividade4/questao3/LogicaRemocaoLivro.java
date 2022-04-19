package ds1.lde.atividade4.questao3;
/*
3 - Considere uma lista linear duplamente encadeada cujos nós armazenam objetos da classe
Livro. Considere ainda que a referida lista ESTÁ ORDENADA e PODE CONTER elementos
repetidos. Implemente uma função para remover um dado Livro da lista. A função deverá receber
como parâmetro o Livro a ser removido. A função deverá retornar quantas ocorrências do Livro
foram removidas da lista.
*/

import ds1.lde.atividade4.questao1.*;

public class LogicaRemocaoLivro extends LDE {

        public int remover(LDE lista, String id) { // Logica usada para a questão 3 (LIVROS) da atividade4
        User temp = new User(id);
        Node prev;
        Node next;
        int loopTimes = 0;

        if (isEmpty()) {
            System.out.println("Prateleira vazia");
        } else {
            Node aux = this.primeiro;
            int resultCompareTo = aux.getInfo().compareTo(temp);
            while (aux != null) {

                if (resultCompareTo > 0) {
                    return loopTimes;
                } else if (resultCompareTo == 0) {
                    while (resultCompareTo == 0) {
                        next = aux.getProx();
                        prev = aux.getAnt();
                        next.setAnt(prev);
                        prev.setProx(next);
                        this.qtd--;
                        aux = prev;
                        loopTimes++;
                        aux = aux.getProx();
                        resultCompareTo = aux.getInfo().compareTo(temp);
                    }
                    return loopTimes;
                } else {
                    aux = aux.getProx();
                }
            }

        }

        return loopTimes;
    }

}
