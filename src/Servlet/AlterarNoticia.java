package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recebendo os dados do formulario 
		String pDescricao = request.getParameter("descricao");
		String pTitulo = request.getParameter("titulo");
		String pTextoNoticia = request.getParameter("textoNoticia");
		
		// Pedir para a Service
		Noticia noticia = new Noticia();
		noticia.setDescricao(pDescricao);
		noticia.setTitulo(pTitulo);
		noticia.setTextoNoticia(pTextoNoticia);
		
		NoticiaService ns = new NoticiaService();
		ns.atualizar(noticia);
	
	
	}

}
