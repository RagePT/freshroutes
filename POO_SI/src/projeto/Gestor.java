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
	    String resposta = sc.nextLine();
	    String user = "";
	    String usertemp;
	    String pass;
	    String tempnum;
	    boolean valid;
	    int num;
	    switch (resposta) {
	        case "1":
	            System.out.println("Qual é o Username?");
	            usertemp = sc.nextLine();
	            boolean userExists = false;
	            for (int i = 0; i < Users.size(); i++) {
	                if (Users.get(i).getUsername().equals(usertemp)) {
	                    System.out.println("Utilizador já existe!");
	                    userExists = true;
	                    break;
	                }
	            }
	            if (!userExists) {
	                user = usertemp;
	                System.out.println("Qual é a password?");
	                pass = sc.nextLine();
	                
	                do {
	                System.out.println("Qual é o numero de telemovel?");
	                tempnum = sc.nextLine();
	                valid = true;
	                for (int i=0; i<tempnum.length(); i++) {
	                		if (!(Character.isDigit(tempnum.charAt(i)))) {
	                			System.out.println("O numero de telemóvel deve ser composto por numeros inteiros.");
	                			valid = false;
	                			break;
	                		}
	                	
	                	}
	                }while(!valid);
	                num = Integer.parseInt(tempnum);
           
	                Admin adminuser = new Admin(user, pass, num);
	                Users.add(adminuser);
	            }
	            break;
	        case "2":
	            System.out.println("Qual é o Username?");
	            usertemp = sc.nextLine();
	            userExists = false;
	            for (int i = 0; i < Users.size(); i++) {
	                if (Users.get(i).getUsername().equals(usertemp)) {
	                    System.out.println("Utilizador já existe!");
	                    userExists = true;
	                    break;
	                }
	            }
	            if (!userExists) {
	                user = usertemp;
	                System.out.println("Qual é a password?");
	                pass = sc.nextLine();
	                do {
	                System.out.println("Qual é o numero de telemovel?");
	                tempnum = sc.nextLine();
	                valid = true;
	                for (int i=0; i<tempnum.length(); i++) {
	                		if (!(Character.isDigit(tempnum.charAt(i)))) {
	                			valid = false;
	                			System.out.println("O numero de telemóvel deve ser composto por numeros inteiros.");
	                			break;
	                		}
	                	
	                	}
	                }while(!valid);
	                num = Integer.parseInt(tempnum);
	                System.out.println("Qual é a sua idade?");
	                int age = sc.nextInt();
	                sc.nextLine();
	                String def;
	                do {
	                    System.out.println("Tem alguma deficiencia?(S/N)");
	                    def = sc.nextLine();
	                } while (!def.equals("S") && !def.equals("N"));
	                boolean deficiencia = def.equals("S");
	                Admin useruser = new User(user, pass, num, age, deficiencia);
	                Users.add(useruser);
	            }
	            break;
	        default:
	            System.out.println("Opção inválida.");
	            break;
	    }
	}
/**
 * metodo login de user
 * @return estado do login
 */
	public void Login() { 
		System.out.println("Qual o username?"); 
		String user = sc.nextLine();
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
			String pass = sc.nextLine();
			if (pass.equals(Users.get(location).getPass())) {
				System.out.println("Login Efetuado com sucesso.");
				
				String fullusertype = Users.get(location).getClass().getName();
				int classStart = fullusertype.indexOf(".") + 1;
				String usertype = fullusertype.substring(classStart,fullusertype.length());
				String resposta = "";
				
				if (usertype.equals("Admin")) {
					do {
						System.out.println("Previlegios: Admin\nDeseja:\n1. Criar Rota\n2. Apagar Rota\n3. Ver Rotas\n4. Ver Perfis Criados\n5. Log Out");
						resposta = sc.nextLine();
						switch(resposta) {
						
						case "1":
							String numrota;
							do {
								System.out.println("Por favor indique o num. da Rota");
								numrota = sc.nextLine();
								if (numrota.contains(" ")) {
									System.out.println("O num. de rota não pode conter espaços.");
								}
							}while(numrota.contains(" ")) ;
							System.out.println("Qual é o nome da paragem de inicio da rota?");
							String inicio = sc.nextLine();
							System.out.println("Qual e o nome da paragem de fim da rota?");
							String fim = sc.nextLine();
														
							RotasAdminA novarota = new RotasAdminA(numrota,inicio,fim);
							Rotas.add(novarota);
							
							break;
						case "2":
							//apagar rota
							break;
						case "3":
							// ver rotas
							break;
						case "4":
							System.out.println("Existem "+(Users.size()-1)+" contas registadas.\nInformação sobre as contas:");
							for (int i = 0; i < Users.size(); i++) {
								System.out.println(Users.get(i).toString());								
							}
							break;					
						default:
							break;

						}
					
					}while(!(resposta.equals("5")));
					
					
				} else {
					do {
						System.out.println("Previlegios: User\nDeseja:\n1. Pesquisar Rotas \n2. Criar uma Viagem\n3. Log Out");
						resposta = sc.nextLine();
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