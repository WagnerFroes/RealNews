package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comentario;
import Service.ComentarioService;


@WebServlet("/CriarComentario.do")
public class CriarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pNome = request.getParameter("nome");
		String pTextoComentario = request.getParameter("textoComentario");
		
		Comentario comentario = new Comentario();
		comentario.setNome(pNome);
		comentario.setTextoComentario(pTextoComentario);
		
		ComentarioService cm = new ComentarioService();
		cm.criar(comentario);
	}

}
