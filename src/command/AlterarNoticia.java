package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

public class AlterarNoticia implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
