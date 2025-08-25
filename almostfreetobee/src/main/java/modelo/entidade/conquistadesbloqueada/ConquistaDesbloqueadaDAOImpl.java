package modelo.entidade.conquistadesbloqueada;



import modelo.conexao.factory.ConexaoFactory;
import modelo.dao.conquistadesbloqueada.ConquistaDesbloqueadaDAO;
import modelo.dao.foto.FotoDAOImpl;
import modelo.entidade.conquista.Conquista;
import modelo.entidade.conquistadesbloqueada.ConquistaDesbloqueada;
import modelo.entidade.foto.Foto;
import modelo.entidade.usuario.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConquistaDesbloqueadaDAOImpl implements ConquistaDesbloqueadaDAO {

	private  Connection conexao;

    public ConquistaDesbloqueadaDAOImpl() {
    	try {
			this.conexao = ConexaoFactory.getConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}
    }

    @Override
    public void adicionarConquista(ConquistaDesbloqueada conquistaDesbloqueada) {
        String sql = "INSERT INTO conquistaDesbloqueada (conquista_id, usuario_id, dataConquista) VALUES (?, ?, ?)";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, conquistaDesbloqueada.getConquista().getId());
            stmt.setLong(2, conquistaDesbloqueada.getUsuario().getId());
            stmt.setDate(3, Date.valueOf(conquistaDesbloqueada.getDataConquista()));

            stmt.executeUpdate();
            System.out.println("Conquista desbloqueada adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarConquistaDesbloqueada(ConquistaDesbloqueada conquistaDesbloqueada) {
        String sql = "DELETE FROM conquistaDesbloqueada WHERE conquista_id = ? AND usuario_id = ?";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, conquistaDesbloqueada.getConquista().getId());
            stmt.setLong(2, conquistaDesbloqueada.getUsuario().getId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Você perdeu sua conquista!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ConquistaDesbloqueada recuperarConquistaDesbloqueada(long conquistaId, long usuarioId) {
        String sql = "SELECT cd.dataConquista, " +
                "c.nomeConquista, c.descricaoConquista, c.pontos, c.iconeConquista_id " +
                "FROM conquistaDesbloqueada cd " +
                "JOIN conquista c ON cd.conquista_id = c.id " +
                "WHERE cd.conquista_id = ? AND cd.usuario_id = ?";

        ConquistaDesbloqueada conquistaDesbloqueada = null;

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, conquistaId);
            stmt.setLong(2, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Conquista conquista = new Conquista();
                    conquista.setId(conquistaId);
                    conquista.setNomeConquista(rs.getString("nomeConquista"));
                    conquista.setDescricaoConquista(rs.getString("descricaoConquista"));
                    conquista.setPontos(rs.getInt("pontos"));

                    Long idFoto = rs.getLong("iconeConquista_id");
                    if (!rs.wasNull()) {
                        FotoDAOImpl fotoDAO = new FotoDAOImpl();
                        Foto foto = new Foto();
                        foto.setId(idFoto);
                        Foto fotoIcone = fotoDAO.recuperarFoto(foto);
                        conquista.setIconeConquista(fotoIcone);
                    }


                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioId);


                    LocalDate dataConquista = rs.getDate("dataConquista").toLocalDate();
                    conquistaDesbloqueada = new ConquistaDesbloqueada(conquista, usuario, dataConquista);
                } else {
                    System.out.println("Nenhuma conquista desbloqueada encontrada com os dados fornecidos.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conquistaDesbloqueada;
    }

    @Override
    public List<ConquistaDesbloqueada> recuperarTodasConquistasDesbloqueadas(long conquistaId, long usuarioId) {
        List<ConquistaDesbloqueada> listaConquistas = new ArrayList<>();

        String sql = "SELECT cd.conquista_id, cd.usuario_id, cd.dataConquista, " +
                "c.nomeConquista, c.descricaoConquista, c.pontos, c.iconeConquista_id " +
                "FROM conquistaDesbloqueada cd " +
                "JOIN conquista c ON cd.conquista_id = c.id " +
                "WHERE cd.usuario_id = ?";

        try (
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Conquista conquista = new Conquista();
                    conquista.setId(rs.getLong("conquista_id"));
                    conquista.setNomeConquista(rs.getString("nomeConquista"));
                    conquista.setDescricaoConquista(rs.getString("descricaoConquista"));
                    conquista.setPontos(rs.getInt("pontos"));

                    Long idFoto = rs.getLong("iconeConquista_id");
                    if (!rs.wasNull()) {
                        FotoDAOImpl fotoDAO = new FotoDAOImpl();
                        Foto foto = new Foto();
                        foto.setId(idFoto);
                        Foto fotoCompleta = fotoDAO.recuperarFoto(foto);
                        conquista.setIconeConquista(fotoCompleta);
                    }


                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioId);

                    // Montar a data da conquista
                    LocalDate dataConquista = rs.getDate("dataConquista").toLocalDate();


                    ConquistaDesbloqueada conquistaDesbloqueada = new ConquistaDesbloqueada(conquista, usuario, dataConquista);

                    listaConquistas.add(conquistaDesbloqueada);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (List<ConquistaDesbloqueada>) recuperarConquistaDesbloqueada(conquistaId, usuarioId);
    }
}
