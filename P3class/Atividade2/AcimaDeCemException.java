package Atividade2;

public class AcimaDeCemException extends Exception {

    public AcimaDeCemException() {
        System.out.println("Com esse valor a soma ultrapassa 100!\n ");
    }

    public AcimaDeCemException(String message) {
        System.out.println(message);
        System.out.println("testing");
    }

}
