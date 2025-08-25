package modelo.dao.estabelecimento;



import java.util.List;

import modelo.entidade.endereco.Endereco;
import modelo.entidade.estabelecimento.Estabelecimento;
import modelo.entidade.foto.Foto;
import modelo.enumeracao.estabelecimento.TipoEstabelecimento;

public interface EstabelecimentoDAO {
	

		void inserirEstabelecimento(Estabelecimento estabelecimento, Long idEndereco);

		void deletarEstabelecimento(Estabelecimento estabelecimento);

		void editarNomeEstabelecimento(Estabelecimento estabelecimento, String novoNome);

		void editarTipoEstabelecimento(Estabelecimento estabelecimento, TipoEstabelecimento novoTipo);

		void editarEnderecoEstabelecimento(Estabelecimento estabelecimento, Endereco novoEndereco);

		void editarCnpjEstabelecimento(Estabelecimento estabelecimento, String novoCpnj);
		
		void editarEmailEstabelecimento(Estabelecimento estabelecimento, String novoEmail);
		
		void editarTelefoneEstabelecimento(Estabelecimento estabelecimento, String novoTelefone);
		
		void editarHorarioEstabelecimento(Estabelecimento estabelecimento, String novoHorario);
		
		void editarFotoEstabelecimento(Estabelecimento estabelecimento, Foto novasFoto);

		List <Estabelecimento >pesquisarEstabelecimentos (String nomePesquisa);
		
		Estabelecimento recuperarEstabelecimentoUnico(Long id);
		
		List<Estabelecimento> recuperarEstabelecimentos();
		
		List<Estabelecimento> recuperarEstabelecimentosUsuario(Long usuarioId);

}
