package modelo.entidade.depoimento;

import java.time.LocalDate;
import java.time.LocalDateTime;

import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.usuario.Usuario;

public class Depoimento {
	
	private Long id;
	private Usuario usuario;
	private String conteudoDepoimento;
	private Avaliacao avaliacao;
	private LocalDateTime dataDepoimento;
	
	public Depoimento () {}
	
	public Depoimento(Long id, Usuario usuario, String conteudoDepoimento, Avaliacao avaliacao, LocalDateTime dataDepoimento) {
		setId(id);
		setUsuario(usuario);
		setConteudoDepoimento(conteudoDepoimento);
		setAvaliacao(avaliacao);
		setDataDepoimento(dataDepoimento);
	}
	
	public Depoimento( Usuario usuario, String conteudoDepoimento, Avaliacao avaliacao, LocalDateTime dataDepoimento) {
		setUsuario(usuario);
		setConteudoDepoimento(conteudoDepoimento);
		setAvaliacao(avaliacao);
		setDataDepoimento(dataDepoimento);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConteudoDepoimento() {
		return conteudoDepoimento;
	}
	public void setConteudoDepoimento(String conteudoDepoimento) {
		this.conteudoDepoimento = conteudoDepoimento;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public LocalDateTime getDataDepoimento() {
		return dataDepoimento;
	}
	
	public void setDataDepoimento(LocalDateTime dataDepoimento) {
		this.dataDepoimento = dataDepoimento;
	}
	
	
	
	

}
