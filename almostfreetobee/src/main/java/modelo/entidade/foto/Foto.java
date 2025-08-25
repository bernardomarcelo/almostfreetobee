package modelo.entidade.foto;

public class Foto {
    private Long id;
    private byte[] conteudoFoto;
    private String extensaoFoto;

    public Foto(Long id, byte[] conteudoFoto, String extensaoFoto){
        setId(id);
        setConteudoFoto(conteudoFoto);
        setExtensaoFoto(extensaoFoto);
    }

    public Foto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getConteudoFoto() {
        return conteudoFoto;
    }

    public void setConteudoFoto(byte[] conteudoFoto) {
        this.conteudoFoto = conteudoFoto;
    }

    public String getExtensaoFoto() {
        return extensaoFoto;
    }

    public void setExtensaoFoto(String extensaoFoto) {
        this.extensaoFoto = extensaoFoto;
    }
}