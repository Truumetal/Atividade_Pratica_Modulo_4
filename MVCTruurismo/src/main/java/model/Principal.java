package model;


import java.util.Scanner;


public class Principal {

	public static void main(String args[]) {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		// Cria um contato e salva no banco
		Usuario usuario = new Usuario();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String nome, email, senha;
		int codigo = 0;

		do {

			System.out.println("===== USUÁRIO =====");
			System.out.println("1 - Cadastro de usuário");
			System.out.println("2 - Excluir usuário");
			System.out.println("3 - Atualizar usuário");
			System.out.println("4 - Mostrar usuárioS");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				
				System.out.println("Digite o nome do usuário: ");
				nome = entrada.next();
				usuario.setNome(nome);

				System.out.println("Digite a email do usuário: ");
				email = entrada.next();
				usuario.setEmail(email);
				
				System.out.println("Digite a senha do usuário: ");
				senha = entrada.next();
				usuario.setSenha(senha);

				usuarioDAO.save(usuario);
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do contato para exclusao: ");
				try {
					codigo = entrada.nextInt();
					
					usuarioDAO.removeById(codigo);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" Nenhum contato para excluir ");
				}

				break;
			}
			case 3: {

				System.out.println("Digite o codigo do contato para atualizar: ");
				codigo = entrada.nextInt();

				System.out.println("Digite o novo nome do usuário: ");
				nome = entrada.next();
				usuario.setNome(nome);
				
				System.out.println("Digite o novo email do usuário: ");
				email = entrada.next();
				usuario.setEmail(email);
				
				System.out.println("Digite o novo senha do usuário: ");
				senha = entrada.next();
				usuario.setSenha(senha);


				usuario.setId(codigo);

				usuarioDAO.update(usuario);
			}
			case 4: {
				for (Usuario u : usuarioDAO.getUsuarios()) {

					System.out.println("NOME: " + u.getNome());
					System.out.println("EMAIL: " + u.getEmail());
					System.out.println("SENHA: " + u.getSenha());


					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int id = entrada.nextInt();
				
				Usuario u = new Usuario();

				u = usuarioDAO.getUsuarioById(id);

				System.out.println("NOME: " + u.getNome());
				System.out.println("EMAIL: " + u.getEmail());
				System.out.println("SENHA: " + u.getSenha());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por usar nossa Agenda === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			};

		} while (opcao != 6);

		entrada.close();

		
		
	}
					
}
	