package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Noticia;
import Service.NoticiaService;

public class ListarNoticia implements Command{
	
	@Override                                                                     
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   
		// Pegando a lista de noticias
				NoticiaService ns = new NoticiaService();
				
				// Criando um arrayList para armazenar as noticias que vieram da service
				ArrayList<Noticia> listaNoticia = ns.listarNoticia();
				
				// Definir o tipo de conteudo da resposta
				response.setContentType("text/html");
				
				// Criando um objeto de saida de dados
				PrintWriter saida = response.getWriter();
				
				saida.println("Lista de Noticias Cadastradas:  <br>");
				
				//Percorrendo o ArrayList e imprindo os dados da noticia
				listaNoticia.forEach(n -> {
					saida.println(n.getDescricao() +":");
					saida.println("<br>");
					saida.println(n.getTitulo());
					saida.println("<br>");
					saida.println(n.getTextoNoticia());
					saida.println("<br>");
					saida.println("<br>");
				});
				
	}
}
