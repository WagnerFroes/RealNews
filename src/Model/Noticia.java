package Model;



public class Noticia {
	
	public int idNoticia;
	public String descricao;
	public String titulo;
	public String textoNoticia;
	
	public Noticia() {
		
	}
	
	public Noticia(int idNoticia, String descricao, String titulo, String textoNoticia) {
		
		this.idNoticia = idNoticia;
		this.descricao = descricao;
		this.titulo = titulo;
		this.textoNoticia = textoNoticia;
	}
	
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTextoNoticia() {
		return textoNoticia;
	}
	public void setTextoNoticia(String textoNoticia) {
		this.textoNoticia = textoNoticia;
	}
	@Override
	public String toString() {
		return "Noticia idNoticia" + idNoticia + ", descricao=" + descricao + ", titulo=" + titulo +", textoNoticia" + textoNoticia;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!textoNoticia.equals(other.textoNoticia))
			return false;
		if (textoNoticia != other.textoNoticia)
			return false;
		if (textoNoticia == null) {
			if (other.titulo != null)
				return false;
		} else if (!textoNoticia.equals(other.textoNoticia))
			return false;
		return true;
	}

}
