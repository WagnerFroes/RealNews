package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

public class ExcluirNoticia implements Command{
	
	@Override                                                                      
	public void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {    
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
