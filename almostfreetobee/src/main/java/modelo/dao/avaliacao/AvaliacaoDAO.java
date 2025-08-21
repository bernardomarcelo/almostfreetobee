package modelo.dao.avaliacao;

import java.util.List;

import modelo.entidade.avaliacao.Avaliacao;

public interface AvaliacaoDAO {

	void inserirAvaliacao(Avaliacao avaliacao);
	void editarAvaliacao(Avaliacao avaliacao);
	void deletarAvaliacao(Avaliacao avaliacao);
	Avaliacao recuperarAvaliacao(Long id);
	List<Avaliacao> recuperarAvaliacoes();
	List<Avaliacao> recuperarAvaliacoesEstabelecimento(Long estabelecimentoId);
	List<Avaliacao> recuperarAvaliacoesUsuario(Long usuarioId);
}
