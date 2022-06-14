package homework.abstract_data.avaliacao_1.questao_1;

public class SistemaSenhas {
    private FilaComLimite<Integer> controle;
    private int num;

    public SistemaSenhas() {
        controle = new FilaComLimite<Integer>(20);;
    }

    public void GerarSenha(){
        if(controle.isFull()){
            System.out.println("A fila está cheia, volte em outro momento");
            return;
        }else{
            num++;
            controle.enqueue(num);
        }
    }

    public void ChamarSenha(){
        if(controle.isEmpty()){
            System.out.println("Não hà clientes na fila de espera");
        }else{
            num--;
            controle.dequeue ();
        }
    }
    
}
