import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static boolean ValidateWord(String word) {   	
    	
        System.out.println("-> Palavra sendo verificada: " + word);

        Stack<Character> inputStack = new Stack();

        char[] symbols = word.toCharArray();
        for (Character checkSymbol : symbols) {

            if (checkSymbol == '(' || checkSymbol == '{' || checkSymbol == '[' || checkSymbol == '<') {

                inputStack.push(checkSymbol);
            } else if (checkSymbol == ')' || checkSymbol == ']' || checkSymbol == '}' || checkSymbol == '>') {

                try {

                    char matchSymbol = inputStack.pop();

                    if (checkSymbol == ')' && matchSymbol == '(') {
                        continue;
                    } else if (checkSymbol == '}' && matchSymbol == '{') {
                        continue;
                    } else if (checkSymbol == ']' && matchSymbol == '[') {
                        continue;
                    } else if (checkSymbol == '>' && matchSymbol == '<') {
                        continue;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean userContinue = true;
        char[] permitidas = {'[',']','{','}','(',')','<','>'};
        
	        //DESCOMENTAR PARA RODAR ARQUIVO DO PRO
	        String[] inputs = {"[](){}", "[)]{}", "[(]){}<>", "(((((([]))))))", "{{[[()]()]}}", "{[[([)]]]}", "<{(())}>", "{<[]()[[]]<>>}"};
	        for (String palavra : inputs) {System.out.println(ValidateWord(palavra)?"Resultado: Valido":"Resultado: Invalido");}

        while (userContinue) {
        	String entradaTemp = "";
            System.out.println("Digite uma senten�a: <{[( )]}>");
            String sentence = scanner.nextLine();
            String[] userInput = { sentence };
            boolean verificaString = false;
            
            for (String word : userInput) {            	
            	char[] caracteres = word.toCharArray();
            	for(char ch : caracteres) {
            		for(int i=0; i<permitidas.length;i++) {
            			if(permitidas[i] == ch) {
            				verificaString = true;
            				break;
            			}
            			verificaString = false;
            		}
            		if(!verificaString) {
            			userContinue = false;
            			break;
            		}
            	}
            	if(userContinue) {
                    System.out.println(ValidateWord(word) ? "V�lido" : "Inv�lido");            		
            	} else {
            		System.out.println("Caracter inv�lido detectado, encerrando tentativa");
            	}
            }

            System.out.println("Deseja Continuar? (Y/N)");
            entradaTemp = scanner.nextLine().toUpperCase().trim();
            if(entradaTemp.equals("Y")) {
            	userContinue = true;
            } else {
            	userContinue = false;
            }
        }
    }
}
