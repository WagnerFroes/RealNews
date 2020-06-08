package Model;


public class Comentario {

	public int idComentario;
	public String nome;
	public String textoComentario;

	public Comentario() {

	}

	public Comentario(int idComentario, String nome, String textoComentario) {
		this.idComentario = idComentario;
		this.nome = nome;
		this.textoComentario = textoComentario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	@Override
	public String toString() {
		return "Comentario idComentario=" + idComentario + ", nome=" + nome + ", textoComentario=" + textoComentario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (textoComentario == null) {
			if (other.textoComentario != null)
				return false;
		} else if (!textoComentario.equals(other.textoComentario))
			return false;
		if (idComentario != other.idComentario)
			return false;
		return false;

	}
}
