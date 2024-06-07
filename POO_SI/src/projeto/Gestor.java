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
	
	GestorFeedback feedback = new GestorFeedback();
	Scanner sc = new Scanner(System.in);
	private ArrayList<Admin>Users;
	private ArrayList<RotasAdminA>Rotas;
	private ArrayList<Paragens>Paragens;
	private ArrayList<Feedback>feedbacktodos;
	
	public Gestor() {
	
		Users = new ArrayList<Admin>();
		Rotas = new ArrayList<RotasAdminA>();
		Paragens = new ArrayList<Paragens>();
		feedbacktodos = new ArrayList<Feedback>();
		
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
	                } while (!def.equalsIgnoreCase("S") && !def.equalsIgnoreCase("N"));
	                boolean deficiencia = def.equalsIgnoreCase("S");
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
								System.out.println("Que rota deseja editar? Existem "+ Rotas.size()+ " rotas disponiveis.");
								for (int i = 0; i<Rotas.size();i++) {
									System.out.println(i+". "+Rotas.get(i).toString());
								}
								String temprotedit;
								int rotedit = 0;
								do {
									temprotedit = sc.nextLine();
									if (!Checks.SeInteger(temprotedit)) {
										System.out.println("Por favor escreva um número inteiro");
									} else rotedit = Integer.parseInt(temprotedit);
										
								}while(!(Checks.SeInteger(temprotedit)) || rotedit > Rotas.size() || rotedit < 0);
								String resp;
								do {
									System.out.println("O que deseja editar na rota "+Rotas.get(rotedit).getNumRota()+"?\n1. Adicionar Paragem a rota\n2. Apagar Paragem da rota\n3. Ver Paragens associadas a rota\n4. Editar Informação da rota\n5. Voltar atrás");
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
										case "4": // Editar informação da rota
											String temp;
											System.out.println("Qual é o novo nome da paragem de inicio da rota?");
											temp = sc.nextLine();
											Rotas.get(rotedit).setInicio(temp);
											System.out.println("Qual é o novo nome da paragem de fim da rota?");
											temp = sc.nextLine();
											Rotas.get(rotedit).setFim(temp);
											System.out.println("Informação da rota "+Rotas.get(rotedit).getNumRota()+" editada com sucesso!");
										break;
										case "5":
										break;
										default:
											System.out.println("Resposta inválida.");
										break;
									}
								}while(!resp.equals("5"));
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
									System.out.println(Rotas.get(i).toString());
								}
							} else System.out.println("Não existem rotas criadas!");
							break;

						case "6": // VER CONTAS
							System.out.println("Existem "+(Users.size())+" contas registadas.\nInformação sobre as contas:");
							for (int i = 0; i < Users.size(); i++) {
								System.out.println(Users.get(i).toString());								
							}
							break;		
						
						case "7": // LOGOUT
							break;
						default:
							System.out.println("Opção inválida");
						break;

						}
					
					}while(!(resposta.equals("7")));
					
					
				} else { //UI User
					do {
						System.out.println("Previlegios: User\nDeseja:\n1. Pesquisar Rotas \n2. Guardar rota nos favoritos\n3. Dar Feedback\n4. Ver Feedback\n5. Ver Rotas Favoritas\n6. Log Out");
						resposta = sc.nextLine();
						switch(resposta) {
					
						case "1":
							//pesquisar rotas
							System.out.println("Qual é o ponto de partida?");
							String partida = sc.nextLine();
							System.out.println("Qual é o ponto de chegada?");
							String chegada = sc.nextLine();
							boolean foundd = false;
							for (int i = 0; i<(Rotas.size()-1); i++) {
								if (Rotas.get(i).getInicio().equalsIgnoreCase(partida) && Rotas.get(i).getFim().equalsIgnoreCase(chegada)) {
									System.out.println("Rota encontrada: "+ Rotas.get(i).getNumRota());
									foundd = true;
								} else if (Rotas.get(i).getInicio().equalsIgnoreCase(partida) || Rotas.get(i).getFim().equalsIgnoreCase(partida)) {
										if ((Rotas.get(i+1).getFim().equalsIgnoreCase(chegada)) || Rotas.get(i+1).getInicio().equalsIgnoreCase(chegada)) { //funciona mas n ta 100% verificacoes xpto
											System.out.println("Rotas encontradas: "+ Rotas.get(i+1).getNumRota() + " e "+ Rotas.get(i+1).getNumRota());
											foundd = true;
										}
								}
							}
							if (!foundd) {
								System.out.println("Não foi encontrada nenhuma rota com esses pontos.");
							}

							break;
						case "2": // GUARDAR ROTA NOS FAVORITOS - COPILOT

							if(Rotas.size() != 0) {
								System.out.println("Que rota deseja guardar nos favoritos?");
								for (int i = 0; i<Rotas.size();i++) {
									System.out.println(i+". "+ Rotas.get(i).toString());
								}
								String tempfav; 
								int rotfav = -1;
								do {
									tempfav = sc.nextLine();
									if (!Checks.SeInteger(tempfav)) {
										System.out.println("Por favor insira um numero inteiro dentro do limite.");
									} else rotfav = Integer.parseInt(tempfav);
								} while (!Checks.SeInteger(tempfav) || rotfav < 0 || rotfav > Rotas.size());
								Users.get(location).addFavoritos(Rotas.get(rotfav));
								System.out.println("Rota guardada com sucesso!");
							} else System.out.println("Não existem rotas criadas!");



							//guardar rota nos favoritos
							break;
						case "3": // ADICIONAR FEEDBACK

							if(!(Paragens.size() == 0) || !(Rotas.size() == 0)) {
									int opii = 0;
								do {
									System.out.println("Quer dar feedback a uma:\n1. Paragem\n2. Rota\n3. Voltar");
									String opxao = sc.nextLine();
									int ipcao = 0;
									if (!Checks.SeInteger(opxao)){
										System.out.println("Insira um numero inteiro.");
									} else {
										opii = Integer.parseInt(opxao);
										switch (opii) {
											case 1:
												ipcao = 0;
												if(Paragens.size() != 0) {
												do {
												System.out.println("Qual é a paragem que quer associar o seu feedback");
												for (int i = 0;i<Paragens.size();i++){
													System.out.println(i + ". "+ Paragens.get(i).toString());
												}
												
													String zopcao = sc.nextLine();
													if (!Checks.SeInteger(zopcao)) {
														System.out.println("Insira um numero inteiro dentro do limite");
													}else ipcao = Integer.parseInt(zopcao);
												} while (ipcao < 0 && ipcao > Paragens.size());

												Feedback tempfeed = feedback.insereFeedback();

												Paragens.get(ipcao).addFeedback(tempfeed);
												Users.get(location).addFeedback(tempfeed);
												feedbacktodos.add(tempfeed);

											} else System.out.println("Não existem paragens criadas!");

											break;
											case 2:
												ipcao = 0;
												if(Rotas.size() != 0) {
												do {
												System.out.println("Qual é a rota que quer associar o seu feedback");
												for (int i = 0;i<Rotas.size();i++){
													System.out.println(i + ". "+ Rotas.get(i).toString());
												}
												
												
													String zopcao = sc.nextLine();
													if (!Checks.SeInteger(zopcao)) {
														System.out.println("Insira um numero inteiro dentro do limite");
													}else ipcao = Integer.parseInt(zopcao);
												} while (ipcao < 0 && ipcao > Rotas.size());

												Feedback tempfeed = feedback.insereFeedback();

												Rotas.get(ipcao).addFeedback(tempfeed);
												Users.get(location).addFeedback(tempfeed);
												feedbacktodos.add(tempfeed);

												} else System.out.println("Não existem Rotas criadas!");
											break;
											default:
											break;
										}
									}

								}while(opii != 3);	

							} else System.out.println("Não existe nada para dar feedback");
							





						break;
						
						case "4": //VER FEEDBACK DE TODOS - COPILOT

							if(feedbacktodos.size() != 0) {
								System.out.println("Feedbacks existentes: " + (feedbacktodos.size()) + ":");
								for(int i= 0; i< feedbacktodos.size(); i++) {
									System.out.println(feedbacktodos.get(i).toString());
								}
							} else System.out.println("Não existem feedbacks criados!");
						break;
						
						
						case "5": //Ver Favoritos - COPILOT
						
							if(Users.get(location).sizeFavoritos() != 0) {
								System.out.println("Rotas Favoritas: " + (Users.get(location).sizeFavoritos()));
								for(int i= 0; i< Users.get(location).sizeFavoritos(); i++) {
									System.out.println(Users.get(location).getFavoritos(i).toString());
								}
							} else System.out.println("Não existem rotas favoritas!");

						break;

						default:
						break;
					}
				}while(!(resposta.equals("6")));
			}
				
				
				
				
				
				
			}else {
				System.out.println("Password incorreta");
				
			}
		}
	}

	public void dev() {
		Admin adminuser = new Admin("admin", "admin", 123456789);
		Users.add(adminuser);
		Admin useruser = new User("user", "user", 987654321, 20, false);
		Users.add(useruser);
		RotasAdminA novarota = new RotasAdminA("1","A","B");
		Rotas.add(novarota);
		Paragens novaParagem = new Paragens("Rua 1", "Paragem 1", "Zona 1");
		Paragens.add(novaParagem);
		Feedback feedback = new Feedback((byte) 5, (byte) 5, (byte) 5, (byte) 5, "Comentário", "Sugestão", "Reclamação");
		feedbacktodos.add(feedback);
		novaParagem.addFeedback(feedback);
		novarota.addFeedback(feedback);
		useruser.addFeedback(feedback);
		RotasAdminA novarota2 = new RotasAdminA("3","c","d");
		Rotas.add(novarota2);
		Paragens novaParagem2 = new Paragens("Rua 2", "Paragem 4", "Zona 7");
		Paragens.add(novaParagem2);
		RotasAdminA novarota3 = new RotasAdminA("4","d","e");
		Rotas.add(novarota3);
		Paragens novaParagem3 = new Paragens("Rua 7", "Paragem 53", "Zona 21");
		Paragens.add(novaParagem3);
		RotasAdminA novarota4 = new RotasAdminA("4","f","g");
		Rotas.add(novarota4);
		Paragens novaParagem4 = new Paragens("Rua 15", "Paragem 31", "Zona 71");
		Paragens.add(novaParagem4);

	}




}