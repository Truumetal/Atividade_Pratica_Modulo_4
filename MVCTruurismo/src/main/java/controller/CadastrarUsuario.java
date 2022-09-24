package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Usuario;
import model.UsuarioDAO;


@WebServlet("/Cadastrar")
public class CadastrarUsuario extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		
		// criando o objeto contato 
		Usuario objUsuario =  new Usuario();
		
		// guardando os dados do formulario do objeto
		objUsuario.setNome(nome);
		objUsuario.setEmail(email);
		objUsuario.setSenha(senha);

		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		UsuarioDAO udao = new UsuarioDAO();		
		udao.save(objUsuario);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("cadastro.jsp");
		
		
		
	}

}
