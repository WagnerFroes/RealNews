package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Pegando o parâmetro que representa o titulo da noticia
		//que o usuario pretende excluir
		String titulo = request.getParameter("titulo");
		
		// Craindo um objeto da Service:
		NoticiaService ns = new NoticiaService();
		
		// Solicitando a service que exclua o professor
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		ns.excluir(noticia);
		
		//Informando alguma mensagem ao usuario
		PrintWriter saida = response.getWriter();
		saida.println("A Notícia " +titulo + " foi removido com sucesso");
	
	
	}

}
