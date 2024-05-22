/**
 * 
 */
package projeto;

import java.util.Scanner;
public class Main {

	/**
	 * 
	 */
	public static void main(String[] args) {
		
		Gestor Gestor = new Gestor(); //inicializa o gestor
		Scanner sc = new Scanner(System.in);
		String resposta;
		do {
		System.out.println("Deseja:\n1. Criar perfil\n2. Fazer Login\n3. Exit");
		resposta = sc.next();

			switch(resposta) {
			
			case "1":
				Gestor.CriarPerfil();
				System.out.println(Gestor.sizeUsers()); // Teste
				System.out.println(Gestor.getUsers(0).getPass()); // teste
			break;
			case "2":
				boolean loggedin = Gestor.Login();
				if (loggedin == true) {
					System.out.println("ya.");
				}else break;
			case "3":
			break;
			default:
				System.out.println("Opção Inválida");
			}	
		}while (!(resposta.equals("3")));
	}

}
