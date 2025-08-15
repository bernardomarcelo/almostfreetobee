package modelo.entidade.endereco;

public class Endereco {
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private int cep;
    private String logradouro;

    public Endereco(Long id, String estado, String cidade, String bairro, int cep, String logradouro) {
        setId(id);
        setEstado(estado);
        setCidade(cidade);
        setBairro(bairro);
        setCep(cep);
        setLogradouro(logradouro);
    }
    
    public Endereco(String estado, String cidade, String bairro, int cep, String logradouro) {
        setEstado(estado);
        setCidade(cidade);
        setBairro(bairro);
        setCep(cep);
        setLogradouro(logradouro);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}