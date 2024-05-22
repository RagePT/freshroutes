/**
 * 
 */
package projeto;


import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 */
public class Gestor {
	
	Scanner sc = new Scanner(System.in);
	private ArrayList<Admin>Users;
	private ArrayList<RotasAdminA>Rotas;
	private ArrayList<Paragens>Paragens;
	
	public Gestor() {
	
		Users = new ArrayList<Admin>();
		Rotas = new ArrayList<RotasAdminA>();
		Paragens = new ArrayList<Paragens>();
		
	}
	
	/**
	 * @return the rotasFav
	 */
	public int sizeUsers() {
		return Users.size();
	}
	
	public Admin getUsers(int index) {
		return Users.get(index);
	}
	/**
	 * @return the rotasFav
	 */
	public int sizeRotas() {
		return Rotas.size();
	}
	
	public RotasAdminA getRotas(int index) {
		return Rotas.get(index);
	}
	/**
	 * @return the rotasFav
	 */
	public int sizeParagens() {
		return Paragens.size();
	}
	
	public Paragens getParagens(int index) {
		return Paragens.get(index);
	}

	public void CriarPerfil() {
		System.out.println("Deseja criar perfil de:\n1. Administrador\n2. Utilizador");
		String resposta = sc.next();
		switch (resposta) {
		case "1":
			System.out.println("Qual é o Username?"); // A IMPLEMENTAR : NAO permitir 2 usernames iguais
			String user = sc.next();
			System.out.println("Qual é a password?");
			String pass = sc.next();
			System.out.println("Qual é o numero de telemovel?");
			int num = sc.nextInt();
			
			Admin adminuser = new Admin(user,pass,num);
			int size = Users.size();
			Users.add(size, adminuser);
			
		break;
		case "2":
			System.out.println("Qual é o Username?");
			String user1 = sc.next();
			System.out.println("Qual é a password?");
			String pass1 = sc.next();
			System.out.println("Qual é o numero de telemovel?");
			int num1 = sc.nextInt();
			System.out.println("Qual é a sua idade?");
			int age = sc.nextInt();
			String def;
			do {
				System.out.println("Tem alguma deficiencia?(S/N)");
				def = sc.next();	
			}while(!def.equals("S") && !def.equals("N"));
			boolean deficiencia;
			if (def.equals("S")) {
				deficiencia = true;
			}else deficiencia = false;
			
			Admin useruser = new User(user1,pass1,num1,age,deficiencia);
			int size1 = Users.size();
			Users.add(size1, useruser);
		break;
		default:
			System.out.println("Opção Inválida.");
		}
	}

	public void Login() {
		System.out.println("Qual o username?");
		String user = sc.next();
		boolean found = false;
		int location = 0;
		int size = Users.size();
		for (int i=0; i<size; i++) {
			if (user.equals(Users.get(i).getUsername())) {
				found = true;
				location = i;
			}
		}
		if (found == false) {
			System.out.println("Username não encontrado");
		}else {
			System.out.println("Qual a palavra passe?");
			String pass = sc.next();
			if (pass.equals(Users.get(location).getPass())) {
				System.out.println("login feito!");
			}else System.out.println("Password incorreta");
		}
	}
}