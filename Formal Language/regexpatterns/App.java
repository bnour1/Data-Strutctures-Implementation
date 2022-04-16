package regexpatterns;

import java.util.regex.*;
public class App {

	static String rtest;

	
	public static void main(String[] args) {
		System.out.println("Começam com aa");
		System.out.println("Teste 1: "+questao1TestTrue());
		System.out.println("Teste 2: "+questao1TestFalse());

		System.out.println("Não começam com aa");
		System.out.println("Teste 1: "+questao2TestTrue());
		System.out.println("Teste 2: "+questao2TestFalse());

		System.out.println("Terminam com bbb");
		System.out.println("Teste 1: "+questao3TestTrue());
		System.out.println("Teste 2: "+questao3TestFalse());

		System.out.println("Não terminam com bbb");
		System.out.println("Teste 1: "+questao4TestTrue());
		System.out.println("Teste 2: "+questao4TestFalse());

		System.out.println("Contém subcadeia aabbb");
		System.out.println("Teste 1: "+questao5TestTrue());
		System.out.println("Teste 2: "+questao5TestFalse());

		System.out.println("Possui comprimento maior ou igual a 3");
		System.out.println("Teste 1: "+questao6TestTrue());
		System.out.println("Teste 2: "+questao6TestFalse());

		System.out.println("Possuem comprimento menor ou igual a 3");
		System.out.println("Teste 1: "+questao7TestTrue());
		System.out.println("Teste 2: "+questao7TestFalse());

		System.out.println("Possuem comprimento diferente de 3");
		System.out.println("Teste 1: "+questao8TestTrue());
		System.out.println("Teste 2: "+questao8TestFalse());

		System.out.println("Possuem comprimento par");
		System.out.println("Teste 1: "+questao9TestTrue());
		System.out.println("Teste 2: "+questao9TestFalse());

		System.out.println("Possuem comprimento impar");
		System.out.println("Teste 1: "+questao10TestTrue());
		System.out.println("Teste 2: "+questao10TestFalse());

		System.out.println("Possuem comprimento multiplo de 4");
		System.out.println("Teste 1: "+questao11TestTrue());
		System.out.println("Teste 2: "+questao11TestFalse());

		System.out.println("Possuem quantidade par de caracteres a");
		System.out.println("Teste 1: "+questao12TestTrue());
		System.out.println("Teste 2: "+questao12TestFalse());

		System.out.println("Possuem quantidade impar de caracteres b");
		System.out.println("Teste 1: "+questao13TestTrue());
		System.out.println("Teste 2: "+questao13TestFalse());

		


	}

	public static boolean questao1TestTrue(){
		rtest = "[a]{2}[ab]*";
		return Pattern.matches(rtest, "aaabababababaaa"); //Verdadeiro, começa com aa
	}
	public static boolean questao1TestFalse(){
		rtest = "[a]{2}[b]*";
		return Pattern.matches(rtest, "bbababababaa"); // Falso, não inicia com aa
	}

	public static boolean questao2TestTrue(){
		rtest = "[b]{1}[ab]*";
		return Pattern.matches(rtest, "baa"); // Verdadeiro, não começa com aa 
	}

	static boolean questao2TestFalse(){
		rtest = "[b]{1}[ab]*";
		return Pattern.matches(rtest, "aa"); // Falso, começa com aa
	}

	static boolean questao3TestTrue(){
		rtest = "[ab]*[b]{3}";
		return Pattern.matches(rtest, "ababababaaabbb"); // Verdadeiro, termina com bbb
	}

	static boolean questao3TestFalse(){
		rtest = "[ab]*[b]{3}";

		return Pattern.matches(rtest, "aabaaabababaaaa"); // Falso, termina com aaa
	}

	static boolean questao4TestTrue(){
		rtest = "[ab]*[^bbb]";
		return Pattern.matches(rtest, "babababababaabababa"); // Verdadeiro, não termina com bbb
	}

	static boolean questao4TestFalse(){
		rtest = "[ab]*[^bbb]";
		return Pattern.matches(rtest, "bababababababbb"); // Verdadeiro, não termina com bbb
	}

	static boolean questao5TestTrue(){
		rtest = "[ab]*aabbb{1}[ab]*";
		return Pattern.matches(rtest, "babbaaabbbaaa"); // verdadeiro, possue aabbb no meio da string
	}

	static boolean questao5TestFalse(){
		rtest = "[ab]*aabbb{1}[ab]*";
		return Pattern.matches(rtest, "baababbbabbabbbaa"); // falso, nao possui a sequencia aabbb
	}

	static boolean questao6TestTrue(){
		rtest = "[ab]{3,}";
		return Pattern.matches(rtest, "abaaba"); // Verdadeiro, possui comprimento maior que 3
	}

	static boolean questao6TestFalse(){
		rtest = "[ab]{3,}";
		return Pattern.matches(rtest, "ab"); // Falso, seu comprimento é menor que 3
	}

	static boolean questao7TestTrue(){
		rtest = "[ab]{0,3}";
		return Pattern.matches(rtest, "ba"); // Verdadeiro, possui comprimento inferior a 3
	}

	static boolean questao7TestFalse(){
		rtest = "[ab]{0,3}";
		return Pattern.matches(rtest, "abaaba"); // Falso, possui comprimento superior a 3
	}

	static boolean questao8TestTrue(){
		rtest = "[ab]{0,2}|[ab]{4,}";
		return Pattern.matches(rtest, "baaaab"); // Verdadeiro, possui comprimento diferente de 3
	}

	static boolean questao8TestFalse(){
		rtest = "[ab]{0,2}|[ab]{4,}";
		return Pattern.matches(rtest, "baa"); // Falso, possui comprimento igual a 3
	}

	
	static boolean questao9TestTrue(){
		rtest = "(?:[ab]{2})*";
		return Pattern.matches(rtest, "abaaba"); // Verdadeiro, possui comprimento 6 (numero par)
	}

	static boolean questao9TestFalse(){
		rtest = "(?:[ab]{2})*";
		return Pattern.matches(rtest, "b"); // Falso, possui comprimento igual a 3 (impar)
	}

	static boolean questao10TestTrue(){
		rtest = "^[ab]([ab]{2})*$";
		return Pattern.matches(rtest, "baaabab"); // Verdadeiro, possui comprimento 7 (numero impar)
	}

	static boolean questao10TestFalse(){
		rtest = "^[ab]([ab]{2})*$";
		return Pattern.matches(rtest, "aabb"); // Falso, possui comprimento igual a 4 (par)
	}

	static boolean questao11TestTrue(){
		rtest = "(?:[ab]{4})*";
		return Pattern.matches(rtest, "baabababababbabbbaba"); // Verdadeiro, possui comprimento 20 (numero multiplo de 4)
	}

	static boolean questao11TestFalse(){
		rtest = "(?:[ab]{4})*";
		return Pattern.matches(rtest, "babaaa"); // Falso, possui comprimento igual a 6 (numero não multiplo de 4)
	}

	static boolean questao12TestTrue(){
		rtest = "b*(ab*ab*)*";
		return Pattern.matches(rtest, "abaaa"); // Verdadeiro, possui 4 ocorrencias de "a" (par)
	}

	static boolean questao12TestFalse(){
		rtest = "b*(ab*ab*)*";
		return Pattern.matches(rtest, "baaba"); // Falso, possui 3 ocorrencias de "a" (impar)
	}

	static boolean questao13TestTrue(){
		rtest = "a*(ba*ba*)*ba*";
		return Pattern.matches(rtest, "abaaabaaab"); // Verdadeiro, possui 3 ocorrencias de "b" (impar)
	}

	static boolean questao13TestFalse(){
		rtest = "a*(ba*ba*)*ba*";
		return Pattern.matches(rtest, "babbbaaa"); // Falso, possui 4 ocorrencias de "b" (par)
	}


}

