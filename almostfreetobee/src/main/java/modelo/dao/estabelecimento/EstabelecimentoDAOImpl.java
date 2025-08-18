package modelo.dao.estabelecimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.endereco.Endereco;
import modelo.entidade.estabelecimento.Estabelecimento;
import modelo.entidade.foto.Foto;
import modelo.enumeracao.estabelecimento.TipoEstabelecimento;
import modelo.conexao.factory.ConexaoFactory;

public class EstabelecimentoDAOImpl implements EstabelecimentoDAO{
	
	
	private Connection conexao;
	
	public EstabelecimentoDAOImpl() {
	
	try {
		this.conexao = ConexaoFactory.getConnection();

	} catch (Exception e) {
		e.printStackTrace();
	}

}
	
	public void inserirEstabelecimento(Estabelecimento estabelecimento, Long idEndereco) {

		PreparedStatement insertEstabelecimento = null;
		

		try {

			
			insertEstabelecimento = conexao.prepareStatement("INSERT INTO estabelecimento ("
					+ "nome_estabelecimento, "
					+ "tipo_estabelecimento, "
					+ "cnpj_estabelecimento, "
					+ "email_estabelecimento, "
					+ "telefone_estabelecimento, "
					+ "horario_estabelecimento, "
					+ "id_foto_estabelecimento, "
					+ "id_endereco_estabelecimento) "
					+ "VALUES (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			insertEstabelecimento.setString(1, estabelecimento.getNome());
			insertEstabelecimento.setString(2, estabelecimento.getTipoEstabelecimento().toString()); // setString?
			insertEstabelecimento.setString(3, estabelecimento.getCnpj());
			insertEstabelecimento.setString(4, estabelecimento.getEmail());
			insertEstabelecimento.setString(5, estabelecimento.getTelefone());
			insertEstabelecimento.setString(6, estabelecimento.getHorarioFuncionamento());
			
			insertEstabelecimento.setLong(8, idEndereco);

			insertEstabelecimento.execute();
			

			ResultSet chavePrimariaEstabelecimento = insertEstabelecimento.getGeneratedKeys();
			
            if (chavePrimariaEstabelecimento.next()) {
                Long idEstabelecimento = chavePrimariaEstabelecimento.getLong(1);
                estabelecimento.setId(idEstabelecimento);
                
            }
                
		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (insertEstabelecimento != null)
					insertEstabelecimento.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void deletarEstabelecimento(Estabelecimento estabelecimento) {
		
		PreparedStatement delete = null;

		try {

			
			delete = conexao.prepareStatement("DELETE FROM estabelecimento WHERE id_estabelecimento = ?");

			delete.setLong(1, estabelecimento.getId());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void editarNomeEstabelecimento(Estabelecimento estabelecimento, String novoNome) {
		
		PreparedStatement update = null;

		try {

			update = conexao.prepareStatement("UPDATE estabelecimento SET nome_estabelecimento = ? WHERE id_estabelecimento = ?");
			
			update.setString(1, novoNome);
			update.setLong(2, estabelecimento.getId());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	public void editarTipoEstabelecimento(Estabelecimento estabelecimento, TipoEstabelecimento novoTipo) {
		
	}

	public void editarEnderecoEstabelecimento(Estabelecimento estabelecimento, Endereco novoEndereco) {
		
	}

	public void editarCnpjEstabelecimento(Estabelecimento estabelecimento, String novoCpnj) {
		
	}
	
	public void editarEmailEstabelecimento(Estabelecimento estabelecimento, String novoEmail) {
		
	}
	
	public void editarTelefoneEstabelecimento(Estabelecimento estabelecimento, String novoTelefone) {
		
	}
	
	public void editarHorarioEstabelecimento(Estabelecimento estabelecimento, String novoHorario) {
		
	}
	
	public void editarFotoEstabelecimento(Estabelecimento estabelecimento, Foto novasFoto) {
		
	}

	@Override
	public List<Estabelecimento> recuperarEstabelecimentoUnico(Long id){
	
		ArrayList<Estabelecimento>estabelecimentoRecuperado = new ArrayList<>();
	
		return estabelecimentoRecuperado;
	}
	
	
	@Override
	public List<Estabelecimento> recuperarEstabelecimentos(){
		
		try {
			this.conexao = ConexaoFactory.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		List<Estabelecimento>estabelecimentosRecuperados = new ArrayList<>();
		
		PreparedStatement selectEstabelecimentos = null;
		
		try{
					
			selectEstabelecimentos = conexao.prepareStatement("select estabelecimento.*, foto.*, endereco.* "
					+ "from foto right join estabelecimento "
					+ "on foto.id_foto = estabelecimento.id_foto_estabelecimento left join endereco "
					+ "on estabelecimento.id_endereco_estabelecimento = endereco.id_endereco;");
			
			ResultSet resultado = selectEstabelecimentos.executeQuery();
			
			while(resultado.next()) {
				Long idEstabelecimento = resultado.getLong("id_estabelecimento");
				String nome = resultado.getString("nome_estabelecimento");
				TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(resultado.getString("tipo_estabelecimento"));
				String cnpj = resultado.getString("cnpj_estabelecimento");
				String email = resultado.getString("email_estabelecimento");
				String telefone = resultado.getString("telefone_estabelecimento");
				String horario = resultado.getString("horario_estabelecimento");
				
				Long idFoto = resultado.getLong("id_foto");
				String nomeArquivo = resultado.getString("caminho_arquivo_foto");
				byte[] conteudoFoto = resultado.getBytes("conteudo_foto");
				
				Long idEndereco = resultado.getLong("id_endereco");				
				String estado = resultado.getString("estado");
				String cidade = resultado.getString("cidade");
				String bairro = resultado.getString("bairro");
				int cep = resultado.getInt("cep");
				String logradouro = resultado.getString("logradouro");						 
				
				Foto foto = new Foto(idFoto, nomeArquivo, conteudoFoto);
						
				Endereco endereco = new Endereco(idEndereco, estado, cidade, bairro, cep, logradouro);

				estabelecimentosRecuperados.add(new Estabelecimento(idEstabelecimento, nome, tipo, endereco, cnpj, email, telefone, horario, foto));
			}
			
		}catch(SQLException erro) {
			erro.printStackTrace();
		}
		
		
		return estabelecimentosRecuperados;
	}

	@Override
	public List<Estabelecimento> pesquisarEstabelecimento(String nomePesquisa) {
		
List<Estabelecimento>estabelecimentosRecuperados = new ArrayList<>();
		
		PreparedStatement selectEstabelecimentos = null;
		
		try{
					
			selectEstabelecimentos = conexao.prepareStatement("select estabelecimento.*, foto.*, endereco.* "
					+ "from foto right join estabelecimento "
					+ "on foto.id_foto = estabelecimento.id_foto_estabelecimento left join endereco "
					+ "on estabelecimento.id_endereco_estabelecimento = endereco.id_endereco where nome = ?;");
			
			
			
			selectEstabelecimentos.setString(1,"nome_estabelecimento");
			ResultSet resultado = selectEstabelecimentos.executeQuery();
			
			
			while(resultado.next()) {
				
				String nome = resultado.getString("nome_estabelecimento");
				TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(resultado.getString("tipo_estabelecimento"));
				String telefone = resultado.getString("telefone_estabelecimento");
				String horario = resultado.getString("horario_estabelecimento");
				
				/*Long idFoto = resultado.getLong("id_foto");
				String nomeArquivo = resultado.getString("caminho_arquivo_foto");rx
				byte[] conteudoFoto = resultado.getBytes("conteudo_foto");
				
						
				String estado = resultado.getString("estado");
				String cidade = resultado.getString("cidade");
				String bairro = resultado.getString("bairro");
				int cep = resultado.getInt("cep");
				String logradouro = resultado.getString("logradouro");						 
				
				Foto foto = new Foto(idFoto, nomeArquivo, conteudoFoto);
						
				Endereco endereco = new Endereco(estado, cidade, bairro, cep, logradouro);
					*/
				//estabelecimentosRecuperados.add(new Estabelecimento(nome, tipo, endereco, cnpj, email, telefone, horario, foto));
				estabelecimentosRecuperados.add(new Estabelecimento(nome, tipo, telefone, horario));
			}
			
		}catch(SQLException erro) {
			erro.printStackTrace();
		}
		
		
		return estabelecimentosRecuperados;
	}
	


}