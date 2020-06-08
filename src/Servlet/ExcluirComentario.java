package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comentario;
import Service.ComentarioService;

@WebServlet("/ExcluirComentario.do")
public class ExcluirComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Pegando o parâmetro que representa o titulo da noticia
		//que o usuario pretende excluir
		String nome = request.getParameter("nome");
		
		// Craindo um objeto da Service:
		ComentarioService cm = new ComentarioService();
		
		// Solicitando a service que exclua o professor
		Comentario comentario = new Comentario();
		comentario.setNome(nome);
		cm.excluir(comentario);
		
		//Informando alguma mensagem ao usuario
		PrintWriter saida = response.getWriter();
		saida.println("O comentario do(a)" +comentario + " foi removido com sucesso");
	
	
	}

}
