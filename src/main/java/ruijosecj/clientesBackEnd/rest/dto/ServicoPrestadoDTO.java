package ruijosecj.clientesBackEnd.rest.dto;

import java.util.Objects;

public class ServicoPrestadoDTO {
	private String descricao;
	private String preco;
	private String data;
	private Integer idCliente;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, idCliente, preco);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoPrestadoDTO other = (ServicoPrestadoDTO) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(idCliente, other.idCliente) && Objects.equals(preco, other.preco);
	}
	
	
}
