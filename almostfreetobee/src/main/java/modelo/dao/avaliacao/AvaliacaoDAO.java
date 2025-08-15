package modelo.dao.avaliacao;

import java.util.List;

import modelo.entidade.avaliacao.Avaliacao;

public interface AvaliacaoDAO {

	void inserirAvaliacao(Avaliacao avaliacao);
	void editarAvaliacao(Avaliacao avaliacao);
	void deletarAvaliacao(Avaliacao avaliacao);
	Avaliacao recuperarAvaliacao(long id);
	List<Avaliacao> recuperarAvaliacoes();
}
