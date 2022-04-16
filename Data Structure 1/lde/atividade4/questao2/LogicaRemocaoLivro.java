package atividade4.questao2;

import datastructure1.lde.atividade4.questao1.*;

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
