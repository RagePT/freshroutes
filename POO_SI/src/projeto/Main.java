/**
 * 
 */
package projeto;

import java.util.Scanner;
public class Main {
	 // Scanner é utilizado para ler a entrada do utilizador a partir do console
	static Scanner sc = new Scanner(System.in);
	/**
     * Método principal onde a execução do programa começa
     */
	public static void main(String[] args) {
		
		// Inicializa um objeto da classe Gestor
		Gestor Gestor = new Gestor(); 
		
		 // Variável para armazenar a resposta do usuário
		String resposta;
		
		// Loop para exibir o menu até que o utilizador escolha sair
		do {
			// Exibe o menu de opções
		System.out.println("Deseja:\n1. Criar perfil\n2. Fazer Login\n3. Exit");
		// Lê a resposta do usuário
		resposta = sc.nextLine();
		
		// Executa diferentes ações dependendo da escolha do usuário
			switch(resposta) {
			
			case "1":
				// Chama o método para criar um perfil
				Gestor.CriarPerfil();
			break;
			case "2":
				// Chama o método para fazer login
				Gestor.Login();
			break;
			// Sai do switch e volta ao menu
			case "3":
			break;
			case "4":
				 // Chama um método para criar variaveis teste
				Gestor.dev();
			break;
			default:
				// Exibe uma mensagem para uma opção inválida
				System.out.println("Opção Inválida");
			break;
			}	
			// Continua o loop até que a resposta seja "3" (sair)
		}while (!(resposta.equals("3")));
	}

}