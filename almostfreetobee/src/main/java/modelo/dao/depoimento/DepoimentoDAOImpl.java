package modelo.dao.depoimento;

import modelo.conexao.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.depoimento.Depoimento;
import modelo.entidade.usuario.Usuario;
import modelo.dao.depoimento.DepoimentoDAO;


public class DepoimentoDAOImpl implements DepoimentoDAO{

	
	private Connection conexao;

	public DepoimentoDAOImpl() {

		try {
			this.conexao = ConexaoFactory.getConnection();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	
	@Override
	public void inserirDepoimento(Depoimento depoimento) {
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO depoimento (conteudo_depoimento, data_depoimento, id_usuario, id_avaliacao) VALUES (?, ?, ?, ?)";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, depoimento.getConteudoDepoimento());
			stmt.setTimestamp(2, java.sql.Timestamp.valueOf(depoimento.getDataDepoimento()));
			stmt.setLong(3, depoimento.getUsuario().getId());
			stmt.setLong(4,depoimento.getAvaliacao().getId());
			stmt.executeUpdate();
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(stmt != null) stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void deletarDepoimento(Depoimento depoimento) {
		PreparedStatement stmt = null;
		
		if (depoimento.getId() == null) 
	        System.err.println("DEPOIMENTO NÃO ENCONTRADO"); // adicionar return
		
		
	        
		String sql = "DELETE FROM depoimento WHERE id_depoimento = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,depoimento.getId());
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(stmt != null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void editarDepoimento(Depoimento depoimento) {
		
		PreparedStatement stmt = null;
		
		if(depoimento.getId() == null) 
			 System.err.println("DEPOIMENTO NÃO ENCONTRADO"); //adicionar return
			 
			 String sql = "UPDATE depoimento SET conteudo_depoimento = ? WHERE id_depoimento = ?";
			 
			 try {
				 stmt = conexao.prepareStatement(sql);
				 stmt.setString(1,depoimento.getConteudoDepoimento());
				 stmt.setLong(2,depoimento.getId());
				 stmt.executeUpdate();
				 
				 
			 }catch(SQLException e) {
				 e.printStackTrace();
			 } finally {
				 
				 try {
					 if(stmt != null) stmt.close();
				 } catch (SQLException e) {
					 e.printStackTrace();
					 
				 }
			 }
			
		}
		
		
	

	@Override
	public Depoimento recuperarDepoimento(Long id) {
		
		
		
		Depoimento depoimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id_depoimento, conteudo_depoimento, data_depoimento, id_usuario, id_avaliacao FROM depoimento WHERE id_depoimento = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				depoimento = new Depoimento();
				depoimento.setId(rs.getLong("id_depoimento"));
				depoimento.setConteudoDepoimento(rs.getString("conteudo_depoimento"));
				  java.sql.Timestamp timestamp = rs.getTimestamp("data_depoimento");
				  depoimento.setDataDepoimento(timestamp.toLocalDateTime());
				  
				  Usuario usuario = new Usuario();  //Apenas id do usuario, mudanças futuras
					usuario.setId(rs.getLong("id_usuario"));
					depoimento.setUsuario(usuario);
													
					Avaliacao avaliacao = new Avaliacao(); //Apenas id da avaliação, mudanças futuras.
					avaliacao.setId(rs.getLong("id_avaliacao"));
					depoimento.setAvaliacao(avaliacao);
					
					
					
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if( rs != null) rs.close();
			if(stmt != null) stmt.close();
	
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		}
		
		
		return depoimento;
	}

	@Override
	public List<Depoimento> recuperarDepoimentos() {
		List<Depoimento> depoimentos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id_depoimento, conteudo_depoimento, data_depoimento, id_usuario, id_avaliacao FROM depoimento";
		
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Depoimento depoimento = new Depoimento();
				
				depoimento.setId(rs.getLong("id_depoimento"));
				depoimento.setConteudoDepoimento(rs.getString("conteudo_depoimento"));
				  java.sql.Timestamp timestamp = rs.getTimestamp("data_depoimento");
				  depoimento.setDataDepoimento(timestamp.toLocalDateTime());
				  
				  Usuario usuario = new Usuario();  //Apenas id do usuario, mudanças futuras
					usuario.setId(rs.getLong("id_usuario"));
					depoimento.setUsuario(usuario);
													
					Avaliacao avaliacao = new Avaliacao(); //Apenas id da avaliação, mudanças futuras.
					avaliacao.setId(rs.getLong("id_avaliacao"));
					depoimento.setAvaliacao(avaliacao);
					
					depoimentos.add(depoimento);				
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs !=null) rs.close();
				if(stmt != null) stmt.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return depoimentos;
	}

}
