package modelo.dao.foto;

import modelo.entidade.foto.Foto;
import modelo.conexao.factory.ConexaoFactory;

import java.sql.*;

public class FotoDAOImpl implements FotoDAO {
    
	private  Connection conexao;

    public FotoDAOImpl() {
    	try {
			this.conexao = ConexaoFactory.getConnection();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

    @Override
    public void adicionarFoto(Foto foto) {

        String sql = "INSERT INTO foto (extensao_foto, conteudo_foto) VALUES (?, ?)";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, foto.getExtensaoFoto()); // verifique se esse nome corresponde a caminhoArquivo
            stmt.setBytes(2, foto.getConteudoFoto());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    foto.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarFoto(Foto foto) {

        String sql = "DELETE FROM foto WHERE id_foto = ?";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, foto.getId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Foto deletada com sucesso!");
            } else {
                System.out.println("Nenhuma foto encontrada com o ID fornecido.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarFoto(Foto foto) {

        String sql = "UPDATE foto SET extensao_foto = ?, conteudo_foto = ? WHERE id_foto = ?";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, foto.getExtensaoFoto()); // verifique se deve ser realmente extensão ou caminho
            stmt.setBytes(2, foto.getConteudoFoto());
            stmt.setLong(3, foto.getId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Foto atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma foto encontrada com o ID fornecido.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Foto recuperarFoto(Foto foto)  {
        String sql = "SELECT id_foto, extensao_foto, conteudo_foto FROM foto WHERE id_foto = ?";
        Foto resultado = null;

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, foto.getId());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    resultado = new Foto();
                    resultado.setId(rs.getLong("id_foto"));
                    resultado.setExtensaoFoto(rs.getString("extensao_foto"));
                    resultado.setConteudoFoto(rs.getBytes("conteudo_foto"));
                } else {
                    System.out.println("Nenhuma foto encontrada com o ID fornecido.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}

