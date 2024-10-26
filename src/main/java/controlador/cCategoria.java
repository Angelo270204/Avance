package controlador;

import modelo.Categoria;
import dao.CategoriaDao;
import java.sql.Connection;
import java.util.List;

public class cCategoria {
    private final CategoriaDao categoriaDao;

    public cCategoria(Connection connection) {
        this.categoriaDao = new CategoriaDao(connection);
    }

    public boolean registrarCategoria(Categoria categoria) {
        if (categoria == null) {
            return false;
        }
        categoriaDao.addCategoria(categoria);
        return true;
    }

    public Categoria obtenerCategoria(int id) {
        return categoriaDao.leer(id);
    }

    public boolean actualizarCategoria(Categoria categoria) {
        if (categoria == null) {
            return false;
        }
        return categoriaDao.actualizar(categoria);
    }

    public boolean eliminarCategoria(int id) {
        return categoriaDao.eliminar(id);
    }

    /**
     *
     * @return
     */
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaDao.getAllCategorias();
    }
}
