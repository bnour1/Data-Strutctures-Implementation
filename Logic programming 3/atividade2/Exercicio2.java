package Atividade2;

import java.util.Scanner;

/*
•Crie
um programa que receba n números e some esses números enquanto a soma não for
superior a 100. O programa deverá imprimir o valor somado (antes de atingir o
número maior que 100) e deverá informar quantos números foram somados e qual a
média. Faça seu programa utilizando as seguintes regras:

•a.
Utilize os tratamentos de exceção para lidar com a entrada de dados.

•b.
Quando a soma for superior a 100, o programa deverá gerar uma exceção criada
pelo programador (veja transparência da aula pra ver como fazer), com nome AcimaDeCemException.

•c.
Lance essa exceção, com o uso de throws
*/

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numberIn;
        char exitLoopIn;
        int soma = 0, number = 0, loopTimes = 0, checkException = 0;
        double media = 0;

        do {

            try {
                System.out.println("Informe um valor a ser adicionado na soma");
                numberIn = in.nextLine();
                number = Integer.parseInt(numberIn);
            } catch (Exception e) {
                System.out.println("O valor informado precisa ser um numero \n tente novamente");
            }

            try {
                checkException = soma + number;

                if (checkException > 100) {
                    throw new AcimaDeCemException();
                } else {
                    soma = soma + number;
                    System.out.println("Valor da soma atual é: " + soma);
                    loopTimes++;
                }
            } catch (AcimaDeCemException e) {
                System.out.println("Diminua a soma atual ou finalize o programa para obter a média");
            }

            System.out.println("Deseja informar mais valores? [S/N]");
            exitLoopIn = in.next().charAt(0);
            in.nextLine();
            Character.toLowerCase(exitLoopIn);

        } while (exitLoopIn != 'n');

        media = soma / loopTimes;

        System.out.println("A media dos valores inseridos é: " + media);
    }

}
