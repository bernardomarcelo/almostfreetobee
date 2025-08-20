package modelo.entidade.estabelecimento;

import java.sql.Time;

import modelo.entidade.endereco.Endereco;
import modelo.entidade.foto.Foto;
import modelo.enumeracao.estabelecimento.TipoEstabelecimento;

public class Estabelecimento {

	private Long id;
	private String nome;
	private TipoEstabelecimento tipoEstabelecimento;
	private Endereco endereco;
	private String cnpj;
	private String email;
	private String telefone;
	private Time horarioAbertura;
	private Time horarioFechamento;
	private Foto foto;

	public Estabelecimento(Long id, String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco,
			String cnpj, String email, String telefone, Time horarioAbertura, Time horarioFechamento) {
		setId(id);
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setEndereco(endereco);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);

	}

	public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, String telefone, Time horarioAbertura,
			Time horarioFechamento) {
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setTelefone(telefone);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);

	}

	public Estabelecimento(Long id, String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco,
			String cnpj, String email, String telefone, Time horarioAbertura, Time horarioFechamento, Foto foto) {
		setId(id);
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setEndereco(endereco);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);

		setFoto(foto);
	}

	public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco, String cnpj,
			String email, String telefone, Time horarioAbertura, Time horarioFechamento, Foto foto) {
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setEndereco(endereco);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
		setFoto(foto);
	}

	public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco, String cnpj,
			String email, String telefone, Time horarioAbertura, Time horarioFechamento) {
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setEndereco(endereco);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
	}

	public Estabelecimento() {

	}

	public Estabelecimento(Long idEstabelecimento, String nome, TipoEstabelecimento tipo, Endereco endereco,
			String cnpj, String email, String telefone) {

		setId(id);
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		setEndereco(endereco);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);

	}

	public Estabelecimento(Long idEstabelecimento, String nome, TipoEstabelecimento tipo, String email,
			String telefone) {
		setId(id);
		setNome(nome);
		setTipoEstabelecimento(tipoEstabelecimento);
		
		setEmail(email);
		setTelefone(telefone);
	}

	public Estabelecimento(String nome, String email, String telefone) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Time getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(Time horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Time getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(Time horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
}