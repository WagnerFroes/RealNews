package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

public class CriarNoticia implements Command {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {   
		String pDescricao = request.getParameter("descricao");
		String pTitulo = request.getParameter("titulo");
		String pTextoNoticia = request.getParameter("textoNoticia");
		
		Noticia noticia = new Noticia();
		noticia.setDescricao(pDescricao);
		noticia.setTitulo(pTitulo);
		noticia.setTextoNoticia(pTextoNoticia);
		
		NoticiaService ns = new NoticiaService();
		ns.criar(noticia);
	}
}
