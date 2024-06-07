/**
 * 
 */
package projeto;

import java.util.Scanner;
public class Main {
	static Scanner sc = new Scanner(System.in);
	/**
	 * poo si apois
	 */
	public static void main(String[] args) {

		Gestor Gestor = new Gestor(); //inicializa o gestor 2
		
		String resposta;
		do {
		System.out.println("Deseja:\n1. Criar perfil\n2. Fazer Login\n3. Exit");
		resposta = sc.nextLine();

			switch(resposta) {
			
			case "1":
				Gestor.CriarPerfil();
			break;
			case "2":
				Gestor.Login();
			break;
			case "3":
			break;
			case "4":
				Gestor.dev();
			break;
			default:
				System.out.println("Opção Inválida");
			break;
			}	
		}while (!(resposta.equals("3")));
	}

}