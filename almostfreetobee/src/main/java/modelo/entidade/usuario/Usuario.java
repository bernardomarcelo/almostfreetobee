package modelo.entidade.usuario;


//import br.senac.modelo.entidade.Foto;

public class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String pronome;
    private String email;
    private String apelido;
    private String senha;
    //private Foto foto;
    /*private Estabelecimento[] estabelecimentosFavoritos;
    private NivelUsuario nivelUsuario;
    private ConquistaDesbloqueada[] conquistaDesbloqueada;
    private EstabelecimentosFavoritos[] estabelecimentosFavoritos;*/

    public Usuario(){

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
/*

    public Usuario(String senha, String apelido, String sobrenome, String pronome, String email, String nome, Long id, Foto foto) {
        setSenha(senha);
        setApelido(apelido);
        setSobrenome(sobrenome);
        setEmail(email);
        setNome(nome);
        setId(id);
        setFoto(foto);
    }

    public Usuario(String senha, String apelido, String sobrenome, String pronome, String email, String nome, Long id, Foto foto, Estabelecimento estabelecimentosFavoritos[]) {
        setSenha(senha);
        setApelido(apelido);
        setSobrenome(sobrenome);
        setEmail(email);
        setNome(nome);
        setId(id);
        setFoto(foto);
    }

    public Usuario() {

    }

    public Usuario(Long id, String nome, String sobrenome, String pronome, String email, String apelido, String senha, Foto foto, NivelUsuario nivelUsuario) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setApelido(apelido);
        setSenha(senha);
        setFoto(foto);
        setNivelUsuario(nivelUsuario);
    }

    public Usuario(Long id, String nome, String sobrenome, String pronome, String email, String apelido, String senha, Foto foto, NivelUsuario nivelUsuario, ConquistaDesbloqueada[] conquistaDesbloqueada) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setApelido(apelido);
        setSenha(senha);
        setFoto(foto);
        setNivelUsuario(nivelUsuario);
        setConquistaDesbloqueada(conquistaDesbloqueada);
    }

    public Usuario(Long id, String nome, String sobrenome, String pronome, String email, String apelido, String senha, Foto foto, NivelUsuario nivelUsuario, ConquistaDesbloqueada[] conquistaDesbloqueada, EstabelecimentosFavoritos[] estabelecimentosFavoritos) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setApelido(apelido);
        setSenha(senha);
        setFoto(foto);
        setNivelUsuario(nivelUsuario);
        setConquistaDesbloqueada(conquistaDesbloqueada);
        setEstabelecimentosFavoritos(estabelecimentosFavoritos);
    }*/

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
/*
    /*public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public ConquistaDesbloqueada[] getConquistaDesbloqueada() {
        return conquistaDesbloqueada;
    }

    public void setConquistaDesbloqueada(ConquistaDesbloqueada[] conquistaDesbloqueada) {
        this.conquistaDesbloqueada = conquistaDesbloqueada;
    }

    public EstabelecimentosFavoritos[] getEstabelecimentosFavoritos() {
        return estabelecimentosFavoritos;
    }

    public void setEstabelecimentosFavoritos(EstabelecimentosFavoritos[] estabelecimentosFavoritos) {
        this.estabelecimentosFavoritos = estabelecimentosFavoritos;
    }*/

}

