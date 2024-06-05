/**
 * 
 */
package projeto;


import java.util.ArrayList;
import extras.Checks;
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
	    int num = -1;
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
						if (!Checks.SeInteger(tempnum)) {
							System.out.println("O numero de telemóvel deve ser composto por numeros inteiros positivos.");
						} else num = Integer.parseInt(tempnum);
					} while (!Checks.SeInteger(tempnum) || num < 0);
           
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
						if (!Checks.SeInteger(tempnum)) {
							System.out.println("O numero de telemóvel deve ser composto por numeros inteiros positivos.");
						} else num = Integer.parseInt(tempnum);
					} while (!Checks.SeInteger(tempnum) || num < 0);
	                int age = -1;
					String tempage;
					do {
						System.out.println("Qual é a sua idade?");
						tempage = sc.nextLine();
						if (!Checks.SeInteger(tempage)) {
							System.out.println("A idade deve ser um numero inteiro positivo");
						} else age = Integer.parseInt(tempage);
					} while (!Checks.SeInteger(tempage) || age < 0);
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
				
				if (usertype.equals("Admin")) { //UI admin
					do {
						System.out.println("Previlegios: Admin\nDeseja:\n1. Criar Rota\n2. Apagar Rota\n3. Editar Rotas\n4. Criar Paragem\n5. Ver Rotas\n6. Ver Perfis Criados\n7. Log Out");
						resposta = sc.nextLine();
						switch(resposta) {
						
						case "1": // CRIAR ROTAS
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
							System.out.println("Rota "+ numrota +" criada com sucesso!");
							break;
						case "2": // Apagar rotas
							if (Rotas.size() != 0) {
								System.out.println("Que rota deseja apagar?");
								for (int i = 0; i<Rotas.size();i++) {
									System.out.println(i+". "+ Rotas.get(i).toString());
								}
								String tempdel; 
								int rotdel = -1;
								do {
									tempdel = sc.nextLine();
									if (!Checks.SeInteger(tempdel)) {
										System.out.println("Por favor insira um numero inteiro dentro do limite.");
									} else rotdel = Integer.parseInt(tempdel);
								} while (!Checks.SeInteger(tempdel) || rotdel < 0 || rotdel > Rotas.size());

								Rotas.remove(rotdel);
								System.out.println("Rota removida com sucesso!");
							} else System.out.println("Não existem rotas criadas!");
							

							break;






						case "3": // EDITAR ROTAS
							if (Rotas.size() > 0){
								System.out.println("Que rota deseja editar? Existem "+ Rotas.size()+ " rotas disponiveis (1-"+Rotas.size()+")");
								String temprotedit;
								int rotedit = 0;
								do {
									temprotedit = sc.nextLine();
									if (!Checks.SeInteger(temprotedit)) {
										System.out.println("Por favor escreva um número inteiro");
									} else rotedit = (Integer.parseInt(temprotedit)-1);
										
								}while(!(Checks.SeInteger(temprotedit)) || rotedit > Rotas.size() || rotedit < 0);
								String resp;
								do {
									System.out.println("O que deseja editar na rota "+Rotas.get(rotedit).getNumRota()+"?\n1. Adicionar Paragem a rota\n2. Apagar Paragem da rota\n3. Ver Paragens associadas a rota\n4. Voltar atrás");
									resp = sc.nextLine();
									switch(resp) {
										case "1": // Adicionar paragem a rota
											int tempo = 0;
											String temptempo;
											do {
												System.out.println("Qual o intervalo de tempo que o autocarro demora entre a ultima e a paragem atual?");
												temptempo = sc.nextLine();
												if (!Checks.SeInteger(temptempo)) {
													System.out.println("Por favor escreva um numero inteiro positivo");
												} else tempo = (Integer.parseInt(temptempo));
											} while(!(Checks.SeInteger(temptempo)));
											System.out.println("Qual é a paragem que quer associar a rota? Existem as seguintes paragens:");
											if (Paragens.size() != 0) {
												for (int i = 0; i<Paragens.size();i++) {
													System.out.println(i+". "+Paragens.get(i).toString());
												}
												String temprotasel;
												int rotasel = -1;
												do {
													temprotasel= sc.nextLine();
													if (!Checks.SeInteger(temprotasel) ) {
														System.out.println("Por favor coloque um numero inteiro, dentro do limite");
													}else rotasel = Integer.parseInt(temprotasel);
												} while (!(Checks.SeInteger(temprotasel)) || rotasel < 0 || rotasel > Paragens.size()); 
			
												Rotas.get(rotedit).addParagem(tempo, Rotas.get(rotedit), Paragens.get(rotasel));
												System.out.println("Paragem adicionada á rota "+ Rotas.get(rotedit).getNumRota()+" com sucesso!");

											} else System.out.println("Não existem paragens registadas!");


										break;
										case "2": // Apagar paragem da rota
											if (Rotas.get(rotedit).sizeParagens() != 0) {
												String tempsel;
												int sel = -1;
												System.out.println("Existem as seguintes paragens associadas á rota "+ Rotas.get(rotedit).getNumRota());
												for (int i = 0; i<Rotas.get(rotedit).sizeParagens() ; i++) {
													System.out.println(i+". "+Rotas.get(rotedit).getParagens(i).toString());
												}
												do {
													tempsel = sc.nextLine();
													if (!Checks.SeInteger(tempsel)) {
														System.out.println("Por favor insira um numero inteiro");
													} else sel = Integer.parseInt(tempsel);
												} while (!Checks.SeInteger(tempsel) || sel > Rotas.get(rotedit).sizeParagens() || sel < 0 );
												
												Rotas.get(rotedit).delParagem(sel);
												System.out.println("Paragem removida com sucesso!");

											} else System.out.println("Esta rota não tem paragens associadas!");
										
										break;
										case "3": // Lista de paragens associadas a rota
											if (Rotas.get(rotedit).sizeParagens() != 0) {
												System.out.println("Existem as seguintes paragens associadas á rota "+ Rotas.get(rotedit).getNumRota()+ ".");
												for (int i = 0; i<Rotas.get(rotedit).sizeParagens(); i++) {
													System.out.println(Rotas.get(rotedit).getParagens(i).toString());
												}
											} else System.out.println("Não existem paragens associadas a esta rota!");
										
										
										
										break;
										default:
											System.out.println("Resposta inválida.");
										break;
									}
								}while(!resp.equals("4"));
							} else System.out.println("Não existem rotas criadas!");
							
							
							
							break;

						case "4": // CRIAR PARAGENS
										System.out.println("Qual o nome da Rua?");
										String NomeRua = sc.nextLine();
										System.out.println("Qual o nome da Paragem?");
										String NomeStop = sc.nextLine();
										System.out.println("Qual o nome da Zona?");
										String Zona = sc.nextLine();
										Paragens novaParagem = new Paragens(NomeRua, NomeStop, Zona);
										Paragens.add(novaParagem);
										System.out.println("Paragem "+NomeStop+" criada com sucesso!");
						break;

						case "5":	// VER ROTAS
							if (Rotas.size() != 0) {
								System.out.println("Rotas existentes: " + (Rotas.size()));
								for(int i= 0; i< Rotas.size(); i++) {
								}
							} else System.out.println("Não existem rotas criadas!");
							break;

						case "6": // VER CONTAS
							System.out.println("Existem "+(Users.size())+" contas registadas.\nInformação sobre as contas:");
							for (int i = 0; i < Users.size(); i++) {
								System.out.println(Users.get(i).toString());								
							}
							break;		

						default:
							System.out.println("Opção inválida");
						break;

						}
					
					}while(!(resposta.equals("7")));
					
					
				} else { //UI User
					do {
						System.out.println("Previlegios: User\nDeseja:\n1. Pesquisar Rotas \n2. Criar uma Viagem\n3. Dar Feedback\n4. Log Out");
						resposta = sc.nextLine();
						switch(resposta) {
					
						case "1":
							//pesquisar rotas
							break;
						case "2":
							//criar viagem
							break;
						case "3": // ADICIONAR FEEDBACK
							if(!(Paragens.size() == 0) || !(Rotas.size() == 0)) {
									int opii = 0;
								do {
									System.out.println("Quer dar feedback a uma:\n1. Paragem\n2. Rota\n3. Voltar");
									String opxao = sc.nextLine();
									if (!Checks.SeInteger(opxao)){
										System.out.println("Insira um numero inteiro.");
									} else {
										opii = Integer.parseInt(resposta);
										switch (opii) {
											case 1:
												if(Paragens.size() != 0) {
												System.out.println("Qual é a paragem que quer associar o seu feedback");
												for (int i = 0;i<Paragens.size();i++){
													System.out.println(Paragens.get(i).toString());
												}
												int ipcao = 0;
												do {
													String zopcao = sc.nextLine();
													if (!Checks.SeInteger(zopcao)) {
														System.out.println("Insira um numero inteiro dentro do limite");
													}else ipcao = Integer.parseInt(zopcao);
												} while (ipcao < 0 && ipcao > Paragens.size());
												//Paragens.get(ipcao)















												
											} else System.out.println("Não existem paragens criadas!");

											break;
											case 2:
												
												System.out.println("Qual é a Rota que quer associar ao seu feedback");

											break;
											default:
											break;
										}
									}
								}while(!(opii == 3));	


							} else System.out.println("Não existe nada para dar feedback");
							

						break;
						default:
						break;
					}
				}while(!(resposta.equals("4")));
			}
				
				
				
				
				
				
			}else {
				System.out.println("Password incorreta");
				
			}
		}
	}
}