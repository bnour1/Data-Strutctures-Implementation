package homework.abstract_data.atividade_1;

import java.util.Scanner;
import java.util.Stack;
import homework.abstract_data.atividade_1.my_stack.*;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word;
        char op;

        do {
            System.out.println("1 - Verificador de palidromo");
            System.out.println("2 - Conversor para binário");
            System.out.println("0 - Sair");
            System.out.println("Insira a opção desejada");
            op = in.next().charAt(0);
            op = Character.toLowerCase(op);

            switch (op) {
                case '1':
                    System.out.println("***VERIFICADOR DE PALINDROMO***");
                    System.out.println("Insira a palavra: ");
                    word = in.nextLine();

                    if (isValid(word)) {
                        System.out.println("Utilizando stack criado em sala");
                        if (isPalindrome(word)) {
                            System.out.println("A palavra é um palindromo");
                        } else {
                            System.out.println("A palavra não é um palindromo");
                        }
                        System.out.println("Utilizando stack do java");
                        if (isPalindromeJavaStack(word)) {
                            System.out.println("A palavra é um palindromo");
                        } else {
                            System.out.println("A palavra não é um palindromo");
                        }
                    } else {
                        System.out.println("Oops, a palavra não pode conter digitos");
                    }
                    break;
                case '2':
                    System.out.println("***CONVERSOR PARA BINARIO***");
                    System.out.println("insira o numero: ");
                    int num = in.nextInt();
                    String binario = converterBinario(num);
                    System.out.println("O numero " + num + " em binário é: " + binario);
                    break;
                default:
                    System.out.println("Opção não existe");
                    break;
            }
        } while (op != 0);
    }

    static boolean isValid(String word) {
        char[] wordCharArray = word.toCharArray();

        for (int i = 0; i < wordCharArray.length; i++) {
            if (Character.isDigit(wordCharArray[i])) {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindrome(String word) {
        MyStack<Character> myStack = new MyStack<Character>();
        word = word.replaceAll(" ", "");
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            myStack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (myStack.top() != (word.charAt(i))) {
                return false;
            }
            myStack.pop();
        }
        return true;
    }

    static boolean isPalindromeJavaStack(String word) {
        Stack<Character> Javastack = new Stack<Character>();

        word = word.replaceAll(" ", "");
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            Javastack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (Javastack.peek() != (word.charAt(i))) {
                return false;
            }
            Javastack.pop();
        }
        return true;
    }

    static String converterBinario(int num) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        String binario;
        if(num == 0){binario = "0";}else if(num < 0){binario = "-";}else{binario = "";}

        while(num != 0){
            myStack.push(num % 2);
            num /= 2;
        }
        while(!myStack.isEmpty()){
            binario += Integer.toString(Math.abs(myStack.top()));
            myStack.pop();
        }
        return binario;
    }

    static String converterBinarioJavaStack(int num) {
        Stack<Integer> Stack = new Stack<Integer>();
        String binario;
        if(num == 0){binario = "0";}else if(num < 0){binario = "-";}else{binario = "";}

        while(num != 0){
            Stack.push(num % 2);
            num /= 2;
        }
        while(!Stack.isEmpty()){
            binario += Integer.toString(Math.abs(myStack.peek()));
            Stack.pop();
        }
        return binario;
    }
}
