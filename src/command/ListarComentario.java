package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comentario;
import Service.ComentarioService;

public class ListarComentario implements Command{
	
	@Override                                                                      
	public void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {           
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
