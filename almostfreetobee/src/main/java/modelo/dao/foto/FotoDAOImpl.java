package modelo.dao.foto;


/*import modelo.entidade.foto.Foto;
import modelo.conexao.factory.ConexaoFactory;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class FotoDAOImpl implements FotoDAO{
    private ConexaoFactory conexao;

    public FotoDAOImpl() {
        this.conexao = new ConexaoFactory();
    }

    @Override
    public void adicionarFoto(Foto foto) {

        String sql = "INSERT INTO foto (id, caminhoArquivo, conteudoFoto) VALUES (?, ?, ?)";

        try Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))catch(ClassNotFoundException e) {

            stmt.setLong(1, foto.getId());
            stmt.setString(2, foto.getCaminhoArquivo());
            stmt.setBytes(3, foto.getConteudoFoto());
            stmt.executeUpdate();
            stmt.close();

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
        String sql = "DELETE FROM foto WHERE id = ?";

        try (Connection connection = conexao.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

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
        String sql = "UPDATE foto SET caminhoArquivo = ?, conteudoFoto = ? WHERE id = ?";

        try (Connection connection = ConexaoFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, foto.getCaminhoArquivo());
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
    public Foto recuperarFoto(Foto foto) {
        String sql = "SELECT id, caminhoArquivo, conteudoFoto FROM foto WHERE id = ?";
        //Foto foto = null;

        try (Connection connection = conexao.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, foto.getId());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   // foto = new Foto();
                    foto.setId(rs.getLong("id"));
                    foto.setNomeArquivo(rs.getString("caminhoArquivo"));
                    foto.setConteudoFoto(rs.getBytes("conteudoFoto"));
                } else {
                    System.out.println("Nenhuma foto encontrada com o ID fornecido.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foto;
    }
}*/