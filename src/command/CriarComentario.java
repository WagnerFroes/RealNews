package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comentario;
import Service.ComentarioService;

public class CriarComentario implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pTextoComentario = request.getParameter("textoComentario");
		
		Comentario comentario = new Comentario();
		comentario.setNome(pNome);
		comentario.setTextoComentario(pTextoComentario);
		
		ComentarioService cm = new ComentarioService();
		cm.criar(comentario);
	}
}
