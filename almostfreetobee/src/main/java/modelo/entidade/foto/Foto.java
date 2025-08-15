package modelo.entidade.foto;

public class Foto {
    private Long id;
    private String caminhoArquivo;
    private byte[] conteudoFoto;

    public Foto(Long id, String nomeArquivo, byte[] conteudoFoto){
        setId(id);
        setCaminhoArquivo(nomeArquivo);
        setConteudoFoto(conteudoFoto);
    }
    
    public Foto(String nomeArquivo, byte[] conteudoFoto){
        setCaminhoArquivo(nomeArquivo);
        setConteudoFoto(conteudoFoto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public byte[] getConteudoFoto() {
        return conteudoFoto;
    }

    public void setConteudoFoto(byte[] conteudoFoto) {
        this.conteudoFoto = conteudoFoto;
    }

}