package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Comentario;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(nome, textoComentario) VALUES (?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTextoComentario());
			stm.execute();
			String enviar = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(enviar); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setIdComentario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getIdComentario();
	}

	public void atualizar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET nome=?, textoComentario=? WHERE idComentario=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTextoComentario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Comentario comentario) {
		String sqlDelete = "DELETE FROM comentario WHERE nome = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, comentario.getNome());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comentario carregar(int idComentario) {
		Comentario comentario = new Comentario();
		comentario.setIdComentario(idComentario);
		String sqlSelect = "SELECT nome, textoComentario FROM comentario WHERE comentario.idComentario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, comentario.getIdComentario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNome(rs.getString("nome"));
					comentario.setTextoComentario(rs.getString("textoComentario"));
				} else {
					comentario.setIdComentario(-1);
					comentario.setNome(null);
					comentario.setTextoComentario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}

	public ArrayList<Comentario> listarComentarios() {
		Comentario comentario;
		ArrayList<Comentario> lista = new ArrayList<>();
		String sqlSelect = "SELECT nome, textoComentario FROM comentario";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					comentario = new Comentario();
					comentario.setNome(rs.getString("nome"));
					comentario.setTextoComentario(rs.getString("textoComentario"));
					lista.add(comentario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
