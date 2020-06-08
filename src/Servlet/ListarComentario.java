package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comentario;
import Service.ComentarioService;

@WebServlet("/ListarComentario.do")
public class ListarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// Pegando a lista de noticias
		ComentarioService cm = new ComentarioService();
		
		// Criando um arrayList para armazenar as noticias que vieram da service
		ArrayList<Comentario> listaComentario = (ArrayList<Comentario>) cm.listarComentario();
		
		// Definir o tipo de conteudo da resposta
		response.setContentType("text/html");
		
		// Criando um objeto de saida de dados
		PrintWriter saida = response.getWriter();
		
		saida.println("Lista de Comentarios:  <br>");
		
		//Percorrendo o ArrayList e imprindo os dados da noticia
		listaComentario.forEach(n -> {
			saida.println("Nome: " +n.getNome());
			saida.println("<br>");
			saida.println("Comentário: " +n.getTextoComentario());
			saida.println("<br>");
		});
	}

}
