package Service;

import java.util.ArrayList;


import dao.NoticiaDAO;
import Model.Noticia;

public class NoticiaService {
	NoticiaDAO dao = new NoticiaDAO();

	public int criar(Noticia noticia) {
		return dao.criar(noticia);
	}

	public void atualizar(Noticia noticia) {
		dao.atualizar(noticia);
	}

	public void excluir(Noticia noticia) {
		dao.excluir(noticia);
	}

	public Noticia carregar(int idNoticia) {
		return dao.carregar(idNoticia);
	}
	
	public ArrayList<Noticia> listarNoticia(){
		return dao.listarNoticia();
	}
}
