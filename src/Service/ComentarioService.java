package Service;

import java.util.List;

import dao.ComentarioDAO;
import Model.Comentario;

public class ComentarioService {
	ComentarioDAO dao = new ComentarioDAO();

	public int criar(Comentario comentario) {
		return dao.criar(comentario);
	}

	public void atualizar(Comentario comentario) {
		dao.atualizar(comentario);
	}

	public void excluir(Comentario comentario) {
		dao.excluir(comentario);
	}

	public Comentario carregar(int idComentario) {
		return dao.carregar(idComentario);
	}

	public List<Comentario> listarComentario() {
		return dao.listarComentarios();
	}

}
