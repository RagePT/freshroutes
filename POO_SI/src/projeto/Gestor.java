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
    /**
     * Metodo para criar perfil
     */
	public void CriarPerfil() {
		System.out.println("Deseja criar perfil de:\n1. Administrador\n2. Utilizador");
		String resposta = sc.next();
		String user = "";
		String usertemp;
		String pass;
		int num;
		switch (resposta) {
		case "1":
			System.out.println("Qual é o Username?"); // A IMPLEMENTAR : NAO permitir 2 usernames iguais
			usertemp = sc.next();
			if (Users.size() == 0) {
				user = usertemp;
			} else {
				for (int i=0;i<Users.size();i++) {
					if (Users.get(i).getUsername().equals(usertemp)) {
						System.out.println("Utilizador já existe!");
					} else {
						user = usertemp;
					}
				}
					
			}
			if (user.equals("")) {
				break;
			}
			System.out.println("Qual é a password?");
			pass = sc.next();
			System.out.println("Qual é o numero de telemovel?");
			num = sc.nextInt();
			Admin adminuser = new Admin(user,pass,num);
			int size = Users.size();
			Users.add(size, adminuser);
			
		break;
		case "2":
			System.out.println("Qual é o Username?"); // A IMPLEMENTAR : NAO permitir 2 usernames iguais
			usertemp = sc.next();
			if (Users.size() == 0) {
				user = usertemp;
			} else {
				for (int i=0;i<Users.size();i++) {
					if (Users.get(i).getUsername().equals(usertemp)) {
						System.out.println("Utilizador já existe!");
					} else {
						user = usertemp;
					}
				}
					
			}
			if (user.equals("")) {
				break;
			}
			System.out.println("Qual é a password?");
			pass = sc.next();
			System.out.println("Qual é o numero de telemovel?");
			num = sc.nextInt();
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
			
			Admin useruser = new User(user,pass,num,age,deficiencia);
			int size1 = Users.size();
			Users.add(size1, useruser);
		break;
		default:
			System.out.println("Opção Inválida.");
		}
	}
/**
 * metodo login de user
 * @return estado do login
 */
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
				System.out.println("Login Efetuado com sucesso.");
				
				String fullusertype = Users.get(location).getClass().getName();
				int classStart = fullusertype.indexOf(".") + 1;
				String usertype = fullusertype.substring(classStart,fullusertype.length());
				String resposta = "";
				
				if (usertype.equals("Admin")) {
					do {
						System.out.println("Previlegios: Admin\nDeseja:\n1. Criar Rota\n2.Apagar Rota\n3.Ver Rotas\n4.Ver Perfis Criados\n5. Log Out");
						resposta = sc.next();
						switch(resposta) {
						
						case "1":
							//criar rota
							break;
						case "2":
							//apagar rota
							break;
						case "3":
							// ver rotas
							break;
						case "4":
							//ver perfis
							break;					
						default:
							break;

						}
					
					}while(!(resposta.equals("5")));
					
					
				} else {
					do {
						System.out.println("Previlegios: User\nDeseja:\n1. Pesquisar Rotas \n2. Criar uma Viagem\n3. Log Out");
						resposta = sc.next();
						switch(resposta) {
					
						case "1":
							//pesquisar rotas
							break;
						case "2":
							//criar viagem
							break;
						default:
							break;
					}
				}while(!(resposta.equals("3")));
			}
				
				
				
				
				
				
			}else {
				System.out.println("Password incorreta");
				
			}
		}
	}
}