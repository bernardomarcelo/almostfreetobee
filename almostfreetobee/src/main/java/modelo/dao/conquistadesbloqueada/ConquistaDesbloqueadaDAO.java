package modelo.dao.conquistadesbloqueada;

import modelo.entidade.conquistadesbloqueada.ConquistaDesbloqueada;

import java.util.List;


public interface ConquistaDesbloqueadaDAO {
    void adicionarConquista(ConquistaDesbloqueada conquistaDesbloqueada);
    void deletarConquistaDesbloqueada(ConquistaDesbloqueada conquistaDesbloqueada);
    ConquistaDesbloqueada recuperarConquistaDesbloqueada(long conquistaId, long usuarioId);
    List<ConquistaDesbloqueada> recuperarTodasConquistasDesbloqueadas(long conquistaId, long usuarioId);
}
