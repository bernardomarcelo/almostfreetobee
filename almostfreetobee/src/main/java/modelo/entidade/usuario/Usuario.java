package modelo.entidade.usuario;


import modelo.entidade.foto.Foto;
import modelo.entidade.conquista.Conquista;
import modelo.entidade.conquistadesbloqueada.ConquistaDesbloqueada;
import modelo.entidade.estabelecimento.Estabelecimento;

public class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String pronome;
    private String email;
    private String apelido;
    private String senha;
    private Foto foto;
    private int pontosUsuario;

    private Conquista[] conquistas;
    private Estabelecimento[] estabelecimentosCadastrados;
    private ConquistaDesbloqueada[] conquistaDesbloqueada;
    private Estabelecimento[] estabelecimentosFavoritos;

    public Usuario() {
    }

    

    public Usuario(String nome, String sobrenome, String apelido, String email, String senha) {
        setNome(nome);
        setSobrenome(sobrenome);
        setApelido(apelido);
        setEmail(email);
        setSenha(senha);
    }



   public Usuario(String senha, String apelido, String sobrenome, String pronome, String email, String nome, Long id) {
        setSenha(senha);
        setApelido(apelido);
        setSobrenome(sobrenome);
        setEmail(email);
        setNome(nome);
        setId(id);
    }

    public Usuario(String senha, String sobrenome, String email, String nome, Long id) {
        setSenha(senha);
        setSobrenome(sobrenome);
        setEmail(email);
        setNome(nome);
        setId(id);
    }
    
    
    
    public Usuario(int pontosUsuario) {
        setPontosUsuario(pontosUsuario);
    }

    public Usuario(Conquista[] conquistas) {
        setConquistas(conquistas);
    }

    public Usuario(ConquistaDesbloqueada[] conquistaDesbloqueada) {
        setConquistaDesbloqueada(conquistaDesbloqueada);
    }

    public Usuario(Long id, String nome, String sobrenome, String email, String apelido, String senha) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setApelido(apelido);
        setSenha(senha);
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { //Exceção para não inserir nulo
        if (email == null) {
            throw new IllegalArgumentException("Email não pode ser nulo.");
        }
        this.email = email;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public int getPontosUsuario() {
        return pontosUsuario;
    }

    public void setPontosUsuario(int pontosUsuario) {
        this.pontosUsuario = pontosUsuario;
    }

    public void adicionarPontos(int pontos) {
        this.pontosUsuario += pontos;
    }

    public Conquista[] getConquistas() {
        return conquistas;
    }

    public void setConquistas(Conquista[] conquistas) {
        this.conquistas = conquistas;
    }

    public Estabelecimento[] getEstabelecimentosCadastrados() {
        return estabelecimentosCadastrados;
    }

    public void setEstabelecimentosCadastrados(Estabelecimento[] estabelecimentosCadastrados) {
        this.estabelecimentosCadastrados = estabelecimentosCadastrados;
    }

    public ConquistaDesbloqueada[] getConquistaDesbloqueada() {
        return conquistaDesbloqueada;
    }

    public void setConquistaDesbloqueada(ConquistaDesbloqueada[] conquistaDesbloqueada) {
        this.conquistaDesbloqueada = conquistaDesbloqueada;
    }

    public Estabelecimento[] getEstabelecimentosFavoritos() {
        return estabelecimentosFavoritos;
    }

    public void setEstabelecimentosFavoritos(Estabelecimento[] estabelecimentosFavoritos) {
        this.estabelecimentosFavoritos = estabelecimentosFavoritos;
    }


    public boolean possuiConquista(Conquista conquista) {
        if (conquistaDesbloqueada == null || conquista == null)
            return false;

        for (ConquistaDesbloqueada cd : conquistaDesbloqueada) {
            if (cd.getConquista().equals(conquista)) {
                return true;
            }
        }
        return false;
    }

    public void pontosUsuario(int pontos) {
        this.pontosUsuario += pontos;
    }
}