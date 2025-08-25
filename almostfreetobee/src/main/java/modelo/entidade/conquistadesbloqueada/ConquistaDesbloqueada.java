package modelo.entidade.conquistadesbloqueada;

import java.time.LocalDate;
import modelo.entidade.conquista.Conquista;
import modelo.entidade.foto.Foto;
import modelo.entidade.usuario.Usuario;

public class ConquistaDesbloqueada {
    private Conquista conquista;
    private Usuario usuario;
    private LocalDate dataConquista;

    public ConquistaDesbloqueada(Conquista conquista, Usuario usuario, LocalDate dataConquista) {
        setConquista(conquista);
        setUsuario(usuario);
        setDataConquista(dataConquista);
    }

    public Conquista getConquista() {
        return conquista;
    }

    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataConquista() {
        return dataConquista;
    }

    public void setDataConquista(LocalDate dataConquista) {
        this.dataConquista = dataConquista;
    }

    public void gerarPontos(Usuario usuario, Conquista conquista){
        if(usuario != null && conquista != null){
            int pontos = conquista.getPontos();
            usuario.pontosUsuario(pontos);
            setDataConquista(LocalDate.now());
        }
    }

}
