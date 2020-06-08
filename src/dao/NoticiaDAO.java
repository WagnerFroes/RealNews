package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Noticia;


public class NoticiaDAO {
	public int criar(Noticia noticia) {
		String sqlInsert = "INSERT INTO noticia(descricao, titulo , textoNoticia) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTextoNoticia());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					noticia.setIdNoticia(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticia.getIdNoticia();
	}

	public void atualizar(Noticia noticia) {
		String inserir = "UPDATE noticia SET idNoticia =?, descricao=?, titulo=?, textoNoticia=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(inserir);) {
			stm.setInt(1, noticia.getIdNoticia());
			stm.setString(2, noticia.getDescricao());
			stm.setString(3, noticia.getTitulo());
			stm.setString(4, noticia.getTextoNoticia());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Noticia noticia) {
		String inserir = "DELETE FROM noticia WHERE titulo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(inserir);) {
			stm.setString(1, noticia.getTitulo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Noticia carregar(int idNoticia) {
		Noticia noticia= new Noticia();
		noticia.setIdNoticia(idNoticia);
		String sqlSelect = "SELECT idNoticia, descricao, titulo, textoNoticia FROM noticia WHERE noticia.Titulo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, noticia.getIdNoticia());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setDescricao(rs.getString("descricao"));
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setTextoNoticia(rs.getString("textoNoticia"));
				} else {
					noticia.setIdNoticia(-1);
					noticia.setDescricao(null);
					noticia.setTitulo(null);
					noticia.setTextoNoticia(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}

	public ArrayList<Noticia> listarNoticia() {
		Noticia noticia;
		ArrayList<Noticia> listaNoticia = new ArrayList<>();
		String sqlSelect = "SELECT idNoticia, descricao,  titulo, textoNoticia FROM noticia";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					noticia = new Noticia();
					noticia.setIdNoticia(rs.getInt("idNoticia"));
					noticia.setDescricao(rs.getString("descricao"));
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setTextoNoticia(rs.getString("textoNoticia"));
					listaNoticia.add(noticia);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaNoticia;
	}






}
