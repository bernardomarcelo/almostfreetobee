package modelo.entidade.estabelecimento;

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
    private String horarioFuncionamento;
    private Foto foto;


    public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, String telefone, String horarioFuncionamento) {
    	setNome(nome);
    	setTipoEstabelecimento(tipoEstabelecimento);
    	setTelefone(telefone);
    	setHorarioFuncionamento(horarioFuncionamento);
    	
    }
    
    public Estabelecimento(Long id, String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco, String cnpj, String email, String telefone, String horarioFuncionamento, Foto foto) {
        setId(id);
        setNome(nome);
        setTipoEstabelecimento(tipoEstabelecimento);
        setEndereco(endereco);
        setCnpj(cnpj);
        setEmail(email);
        setTelefone(telefone);
        setHorarioFuncionamento(horarioFuncionamento);
        setFoto(foto);
    }
    
    
    public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco, String cnpj, String email, String telefone, String horarioFuncionamento, Foto foto) {
        setNome(nome);
        setTipoEstabelecimento(tipoEstabelecimento);
        setEndereco(endereco);
        setCnpj(cnpj);
        setEmail(email);
        setTelefone(telefone);
        setHorarioFuncionamento(horarioFuncionamento);
        setFoto(foto);
    }
    
    public Estabelecimento(String nome, TipoEstabelecimento tipoEstabelecimento, Endereco endereco, String cnpj, String email, String telefone, String horarioFuncionamento) {
        setNome(nome);
        setTipoEstabelecimento(tipoEstabelecimento);
        setEndereco(endereco);
        setCnpj(cnpj);
        setEmail(email);
        setTelefone(telefone);
        setHorarioFuncionamento(horarioFuncionamento);
    }

    public Estabelecimento() {
		
	}

	public Estabelecimento(String nome, String telefone, String email) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);

	}

	public Estabelecimento(String nome, String telefone) {
		// TODO Auto-generated constructor stub
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

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
}