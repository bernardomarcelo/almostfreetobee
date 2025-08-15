package modelo.dao.endereco;



import java.util.List;

import modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void editarEndereco(Endereco endereco);

	List<Endereco> recuperarEndereco();
	
	List<Endereco> recuperarEnderecos();

}
