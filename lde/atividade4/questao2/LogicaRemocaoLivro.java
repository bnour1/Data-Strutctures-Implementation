package lde.atividade4.questao2;

/*
2 - Considere uma lista linear duplamente encadeada cujos nós armazenam objetos da classe
Livro. Considere ainda que a referida lista NÃO ESTÁ ORDENADA e PODE CONTER elementos
repetidos. Implemente uma função para remover um dado Livro da lista. A função deverá receber
como parâmetro o Livro a ser removido. A função deverá retornar quantas ocorrências do Livro
foram removidas da lista.
*/

import lde.atividade4.questao1.*;

public class LogicaRemocaoLivro extends LDE {

       public int remover(LDE lista, String id) { // Logica usada para a questão 2 (LIVROS) da atividade4
        User temp = new User(id);
        Node prev;
        Node next;
        int loopTimes = 0;

        if (isEmpty()) {
            System.out.println("Prateleira vazia");
        } else {
            Node aux = this.primeiro;
            while (aux != null) {
                if (aux.getInfo().compareTo(temp) == 0) {
                    next = aux.getProx();
                    prev = aux.getAnt();
                    next.setAnt(prev);
                    prev.setProx(next);
                    this.qtd--;
                    aux = prev;
                    loopTimes++;
                }
                aux = aux.getProx();
            }

        }

        return loopTimes;
    }

    

}
