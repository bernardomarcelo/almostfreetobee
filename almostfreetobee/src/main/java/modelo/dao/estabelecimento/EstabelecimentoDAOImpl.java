package modelo.dao.estabelecimento;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.avaliacao.Avaliacao;
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
					+ "horario_abertura_estabelecimento, "
					+ "horario_fechamento_estabelecimento,"
					+ "id_usuario,"
					
					+ "id_endereco, id_foto) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			insertEstabelecimento.setString(1, estabelecimento.getNome());
			insertEstabelecimento.setString(2, estabelecimento.getTipoEstabelecimento().toString()); // setString?
			//insertEstabelecimento.setString(2, estabelecimento.getTipoEstabelecimento().name());
			insertEstabelecimento.setString(3, estabelecimento.getCnpj());
			insertEstabelecimento.setString(4, estabelecimento.getEmail());
			insertEstabelecimento.setString(5, estabelecimento.getTelefone());
			insertEstabelecimento.setTime(6, estabelecimento.getHorarioAbertura());
			insertEstabelecimento.setTime(7, estabelecimento.getHorarioFechamento());
			insertEstabelecimento.setLong(8, estabelecimento.getUsuario().getId());
			insertEstabelecimento.setLong(10,estabelecimento.getFoto().getId());
			
			insertEstabelecimento.setLong(9, idEndereco);

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
	public Estabelecimento recuperarEstabelecimentoUnico(Long id){
		
		try {
			this.conexao = ConexaoFactory.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		    }
	
		Estabelecimento estabelecimento = null;
		Endereco endereco = null;
		Foto foto = null;
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conexao.prepareStatement("SELECT estabelecimento.*, foto.*, endereco.* "
					+ "FROM foto "
					+ "INNER JOIN estabelecimento "
					+ "ON estabelecimento.id_foto = foto.id_foto "
					+ "INNER JOIN endereco "
					+ "ON estabelecimento.id_endereco = endereco.id_endereco WHERE id_estabelecimento = ?;");
		
			 stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				estabelecimento = new Estabelecimento();
				
				estabelecimento.setId(rs.getLong("id_estabelecimento"));
	            estabelecimento.setNome(rs.getString("nome_estabelecimento"));
	          	estabelecimento.setCnpj(rs.getString("cnpj_estabelecimento"));
	            String tipoStr = rs.getString("tipo_estabelecimento");
	            TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(tipoStr.toUpperCase());
	            estabelecimento.setTipoEstabelecimento(tipo);
	            estabelecimento.setEmail(rs.getString("email_estabelecimento"));
	            estabelecimento.setTelefone(rs.getString("telefone_estabelecimento"));
	        
	            endereco = new Endereco();
	            endereco.setId(rs.getLong("id_endereco"));
	            endereco.setEstado(rs.getString("estado_endereco"));
	            endereco.setCidade(rs.getString("cidade_endereco"));
	            endereco.setCep(rs.getString("cep_endereco"));
	            endereco.setLogradouro(rs.getString("logradouro_endereco"));
	            estabelecimento.setEndereco(endereco);
	            
	            
	            foto = new Foto();
	            
	            foto.setId(rs.getLong("id_foto"));
	            foto.setConteudoFoto(rs.getBytes("conteudo_foto"));
	            foto.setExtensaoFoto(rs.getString("extensao_foto"));
	            estabelecimento.setFoto(foto);
	            
			}
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return estabelecimento;
	}
	
	
	
	@Override
	public List<Estabelecimento> recuperarEstabelecimentos() {
	    
	    try {
	        this.conexao = ConexaoFactory.getConnection();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    List<Estabelecimento> estabelecimentosRecuperados = new ArrayList<>();
	    Estabelecimento estabelecimento = null;
		Endereco endereco = null;
		Foto foto = null;
	    PreparedStatement stmt = null;
	    

	    try {
			stmt = conexao.prepareStatement("SELECT estabelecimento.*, foto.*, endereco.* "
					+ "FROM foto "
					+ "INNER JOIN estabelecimento "
					+ "ON estabelecimento.id_foto = foto.id_foto "
					+ "INNER JOIN endereco "
					+ "ON estabelecimento.id_endereco = endereco.id_endereco;");
		
			 
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				estabelecimento = new Estabelecimento();
				
				estabelecimento.setId(rs.getLong("id_estabelecimento"));
	            estabelecimento.setNome(rs.getString("nome_estabelecimento"));
	          	estabelecimento.setCnpj(rs.getString("cnpj_estabelecimento"));
	            String tipoStr = rs.getString("tipo_estabelecimento");
	            TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(tipoStr.toUpperCase());
	            estabelecimento.setTipoEstabelecimento(tipo);
	            estabelecimento.setEmail(rs.getString("email_estabelecimento"));
	            estabelecimento.setTelefone(rs.getString("telefone_estabelecimento"));
	        
	            endereco = new Endereco();
	            endereco.setId(rs.getLong("id_endereco"));
	            endereco.setEstado(rs.getString("estado_endereco"));
	            endereco.setCidade(rs.getString("cidade_endereco"));
	            endereco.setCep(rs.getString("cep_endereco"));
	            endereco.setLogradouro(rs.getString("logradouro_endereco"));
	            estabelecimento.setEndereco(endereco);
	            
	            
	            foto = new Foto();
	        
	            foto.setId(rs.getLong("id_foto"));
	            foto.setConteudoFoto(rs.getBytes("conteudo_foto"));
	            foto.setExtensaoFoto(rs.getString("extensao_foto"));
	            estabelecimento.setFoto(foto);
	            estabelecimentosRecuperados.add(estabelecimento);
	            
			}
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return estabelecimentosRecuperados;
	}
	@Override
	public List<Estabelecimento> pesquisarEstabelecimentos(String nomePesquisa) {
		
List<Estabelecimento>estabelecimentosRecuperados = new ArrayList<>();
		
		PreparedStatement selectEstabelecimentos = null;
		
		try{
					
			selectEstabelecimentos = conexao.prepareStatement("SELECT estabelecimento.* FROM estabelecimento WHERE nome_estabelecimento LIKE ?;");
			
			
			selectEstabelecimentos.setString(1, "%" + nomePesquisa + "%");
			ResultSet resultado = selectEstabelecimentos.executeQuery();
			
			
			while(resultado.next()) {
				Long idEstabelecimento = resultado.getLong("id_estabelecimento");
				String nome = resultado.getString("nome_estabelecimento");
				String email = resultado.getString("email_estabelecimento");
				//TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(resultado.getString("tipo_estabelecimento"));
				String telefone = resultado.getString("telefone_estabelecimento");
				//String horario = resultado.getString("horario_estabelecimento");
				
				/*Long idFoto = resultado.getLong("id_foto");
				String nomeArquivo = resultado.getString("caminho_arquivo_foto");rx
				byte[] conteudoFoto = resultado.getBytes("conteudo_foto");
				*/
			
						
			/*	String estado = resultado.getString("estado_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cep = resultado.getString("cep_endereco");
				String logradouro = resultado.getString("logradouro_endereco");						 
				
				//Foto foto = new Foto(idFoto, nomeArquivo, conteudoFoto);
						
				Endereco endereco = new Endereco(estado, cidade, bairro, cep, logradouro);
					*/
				//estabelecimentosRecuperados.add(new Estabelecimento(nome, tipo, endereco, cnpj, email, telefone, horario, foto));
				estabelecimentosRecuperados.add(new Estabelecimento(idEstabelecimento, nome, email, telefone));
				
			}
			
		}catch(SQLException erro) {
			erro.printStackTrace();
		}
		
	
		
		
		return estabelecimentosRecuperados;
	}

	    @Override
		public List<Estabelecimento> recuperarEstabelecimentosUsuario(Long usuarioId) {
		List<Estabelecimento> estabelecimentos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultado = null;

		String sql = "SELECT * FROM estabelecimento WHERE id_usuario = ?";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, usuarioId);
			resultado = stmt.executeQuery();
			
			 while (resultado.next()) {
		            Long idEstabelecimento = resultado.getLong("id_estabelecimento");
		            String nome = resultado.getString("nome_estabelecimento");
		            TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(resultado.getString("tipo_estabelecimento"));
		            String cnpj = resultado.getString("cnpj_estabelecimento");
		            String email = resultado.getString("email_estabelecimento");
		            String telefone = resultado.getString("telefone_estabelecimento");

		            /* NOVO: horários como Time
		            Time horarioAbertura = resultado.getTime("horario_abertura_estabelecimento");
		            Time horarioFechamento = resultado.getTime("horario_fechamento_estabelecimento");
					*/
		         //   Long idFoto = resultado.getLong("id_foto");
		          //  String nomeArquivo = resultado.getString("caminho_arquivo_foto");
		           // byte[] conteudoFoto = resultado.getBytes("conteudo_foto");
		          //  Foto foto = new Foto(idFoto, nomeArquivo, conteudoFoto);

		          /*  Long idEndereco = resultado.getLong("id_endereco_estabelecimento");                
		            String estado = resultado.getString("estado_endereco");
		            String cidade = resultado.getString("cidade_endereco");
		            String bairro = resultado.getString("bairro_endereco");
		            String cep = resultado.getString("cep_endereco");
		           */ //String logradouro = resultado.getString("logradouro_endereco");                         
		            //Endereco endereco = new Endereco(idEndereco, estado, cidade, bairro, cep, logradouro);

		            estabelecimentos.add(
		            		new Estabelecimento(idEstabelecimento, nome, tipo, email, telefone));
		            
				            

		}
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (resultado != null)
					resultado.close();
				if (stmt != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return estabelecimentos;
	
	
	    }

		public byte[] recuperarFotoEstabelecimento(Long id) {
			ResultSet rs = null;
	        PreparedStatement stmt = null;
	        String sql = "SELECT f.conteudo_foto " +
	                "FROM estabelecimento e " +
	                "JOIN foto f ON e.id_foto = f.id_foto " +
	                "WHERE e.id_estabelecimento = ?";
	        try {
	            stmt = conexao.prepareStatement(sql);
	           
	            
	            stmt.setLong(1, id);
	            rs = stmt.executeQuery();
	            
	            if(rs.next()) {
	            	return rs.getBytes("conteudo_foto");
	            }
	            		
	        }catch(SQLException e) {
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
	        
			
			return null;
		}
	
	
	}
	


