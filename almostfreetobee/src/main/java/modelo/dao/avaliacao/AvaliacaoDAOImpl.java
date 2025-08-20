package modelo.dao.avaliacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

import modelo.conexao.factory.ConexaoFactory;
import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.estabelecimento.Estabelecimento;
import modelo.entidade.usuario.Usuario;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {

	private Connection conexao;

	public AvaliacaoDAOImpl() {

		try {
			this.conexao = ConexaoFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void inserirAvaliacao(Avaliacao avaliacao) {
		PreparedStatement stmt = null;

		String sql = "INSERT INTO avaliacao (nota_avaliacao, descricao_avaliacao, id_usuario, id_estabelecimento) VALUES (?, ?, ?, ?)";

		try {
			stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getDescricao());
			stmt.setLong(3, avaliacao.getUsuario().getId());
			stmt.setLong(4, avaliacao.getEstabelecimento().getId());
			stmt.executeUpdate();
			
			 ResultSet generatedKeys = stmt.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            Long avaliacaoId = generatedKeys.getLong(1);
		            avaliacao.setId(avaliacaoId); 
		        }

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void editarAvaliacao(Avaliacao avaliacao) {
		PreparedStatement stmt = null;

		if (avaliacao.getId() == null) {
			throw new IllegalArgumentException("ID não encontrado");
		}

		String sql = "UPDATE avaliacao SET nota_avaliacao = ?, descricao_avaliacao = ? WHERE id_avaliacao = ?";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getDescricao());
			stmt.setLong(3, avaliacao.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deletarAvaliacao(Avaliacao avaliacao) {
		PreparedStatement stmt = null;

		if (avaliacao.getId() == null) {
			throw new IllegalArgumentException("ID não encontrado");
		}

		String sql = "DELETE FROM avaliacao WHERE id_avaliacao = ?";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, avaliacao.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (stmt != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Avaliacao recuperarAvaliacao(long id) {
		Avaliacao avaliacao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id_avaliacao, nota_avaliacao, descricao_avaliacao, id_usuario, id_estabelecimento FROM avaliacao WHERE id_avaliacao = ?";

		try {

			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				avaliacao = new Avaliacao();

				avaliacao.setId(rs.getLong("id_avaliacao"));
				avaliacao.setNota(rs.getInt("nota_avaliacao"));
				avaliacao.setDescricao(rs.getString("descricao_avaliacao"));

				Usuario usuario = new Usuario();  //Apenas id do usuario
				usuario.setId(rs.getLong("id_usuario"));
				avaliacao.setUsuario(usuario);

				Estabelecimento estabelecimento = new Estabelecimento();    // Apenas id do estabelecimento
				estabelecimento.setId(rs.getLong("id_estabelecimento"));
				avaliacao.setEstabelecimento(estabelecimento);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return avaliacao;
	}

	@Override
	public List<Avaliacao> recuperarAvaliacoes() {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT id_avaliacao, nota_avaliacao, descricao_avaliacao, id_usuario, id_estabelecimento FROM avaliacao";

		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Avaliacao avaliacao = new Avaliacao();

				avaliacao.setId(rs.getLong("id_avaliacao"));
				avaliacao.setNota(rs.getInt("nota_avaliacao"));
				avaliacao.setDescricao(rs.getString("descricao_avaliacao"));

				Usuario usuario = new Usuario();  //Apenas id do usuario
				usuario.setId(rs.getLong("id_usuario"));
				avaliacao.setUsuario(usuario);
									
				Estabelecimento estabelecimento = new Estabelecimento(); //Apenas id do estabelecimento
				estabelecimento.setId(rs.getLong("id_estabelecimento"));
				avaliacao.setEstabelecimento(estabelecimento);

				avaliacoes.add(avaliacao);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return avaliacoes;
	}

}
