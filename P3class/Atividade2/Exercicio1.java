package Atividade2;

/*
•Crie
um programa que receba n números e some esses números enquanto a soma não for
superior a 100. O programa deverá imprimir o valor somado (antes de atingir o
número maior que 100) e deverá informar quantos números foram somados e qual a
média. Faça seu programa utilizando as seguintes regras:
*/

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String vetInput, vetIndexInput;
        int num, index;
        char exitLoop;
        int[] vetor = new int[10];

        do {

            System.out.println("informe o inteiro que deseja inserir no vetor");
            vetInput = in.nextLine();

            System.out.println("Infrome o index para a inserção do vetor");
            vetIndexInput = in.nextLine();

            try {
                num = Integer.parseInt(vetInput);
                index = Integer.parseInt(vetIndexInput);
                System.out.println(num + "" + index);
                vetor[index] = num;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(
                        "O index informado não pode ser alcançado \n tente novamente com um valor entre 0 - 9");
            } catch (NumberFormatException e) {
                System.out.println("O valor inserido deve ser um inteiro \n tente novamente inserindo um inteiro");
            }

            System.out.println("Deseja inserir mais? \n S/N");
            exitLoop = in.next().charAt(0);
            in.nextLine();
            Character.toLowerCase(exitLoop);

        } while (exitLoop != 'n');

        in.close();

    }
}