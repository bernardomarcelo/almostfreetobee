package modelo.dao.depoimento;

import modelo.entidade.depoimento.Depoimento;
import java.util.List;


public interface DepoimentoDAO {
	
	void inserirDepoimento(Depoimento depoimento);
	void deletarDepoimento(Depoimento depoimento);
	void editarDepoimento(Depoimento depoimento);
	Depoimento recuperarDepoimento(Long id);
	List<Depoimento> recuperarDepoimentos();

}
