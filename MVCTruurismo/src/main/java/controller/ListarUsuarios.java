package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;


@WebServlet("/Listar")
public class ListarUsuarios extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Usuario> cadastro = new ArrayList<Usuario>();
		UsuarioDAO cdao = new UsuarioDAO();		
		cadastro = cdao.getUsuarios();		
		request.setAttribute("listaUsuarios", cadastro);
		
		// REDIRECIONA PARA PÁGINA CADASTRO COM A LISTA ATUALIZADA
		// TAMBÉM POSSO FAZER UMA PAG DE CADASTRO SEM LISTAR OS DADOS E OUTRA PÁG PARA CADASTRO E EXIBIÇÃO DA LISTA.
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
		
		
	}



}
