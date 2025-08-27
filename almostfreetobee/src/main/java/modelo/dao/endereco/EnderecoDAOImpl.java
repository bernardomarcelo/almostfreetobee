package modelo.dao.endereco;

import java.sql.Connection;
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

public class EnderecoDAOImpl implements EnderecoDAO{

private Connection conexao;
	
	public EnderecoDAOImpl() {
	
	try {
		this.conexao = ConexaoFactory.getConnection();

	} catch (Exception e) {
		e.printStackTrace();
	}

}
	@Override
	public void inserirEndereco(Endereco endereco) {

		PreparedStatement insertEndereco = null;
		

		try {

			
			insertEndereco = conexao.prepareStatement("INSERT INTO endereco ("
					+ "estado_endereco, "
					+ "cidade_endereco, "
					+ "bairro_endereco, "
					+ "cep_endereco, "
					+ "logradouro_endereco) "
					+ "VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			insertEndereco.setString(1, endereco.getEstado());
			insertEndereco.setString(2, endereco.getCidade()); // setString?
			insertEndereco.setString(3, endereco.getBairro());
			insertEndereco.setString(4, endereco.getCep());
			insertEndereco.setString(5, endereco.getLogradouro());

			insertEndereco.executeUpdate();
			

			ResultSet chavePrimariaEndereco = insertEndereco.getGeneratedKeys();
			
            if (chavePrimariaEndereco.next()) {
                Long idEndereco = chavePrimariaEndereco.getLong(1);
                endereco.setId(idEndereco);
                
            }
                
		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (insertEndereco != null)
					insertEndereco.close();

				

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	@Override
	public void deletarEndereco(Endereco endereco) {
		
		PreparedStatement delete = null;

		try {

			
			delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");

			delete.setLong(1, endereco.getId());

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
	
	@Override
	public void editarEndereco (Endereco endereco) {
		
	}


	public List<Endereco> recuperarEndereco(){
	
		ArrayList<Endereco>enderecoRecuperado = new ArrayList<>();
	
		return enderecoRecuperado;
	}
	
	public List<Endereco> recuperarEnderecos(){
		
	
		ArrayList<Endereco> enderecosRecuperados = new ArrayList<>();
		
		return enderecosRecuperados;
	}
	
}