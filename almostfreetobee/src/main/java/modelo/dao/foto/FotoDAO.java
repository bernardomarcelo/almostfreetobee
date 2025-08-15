package modelo.dao.foto;

import modelo.entidade.foto.Foto;

public interface FotoDAO {

    void adicionarFoto(Foto foto);

    void deletarFoto(Foto foto);

    void atualizarFoto(Foto foto);

    Foto recuperarFoto(Foto foto);
}