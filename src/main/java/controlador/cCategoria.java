package controlador;

import modelo.Categoria;
import dao.CategoriaDao;

public class cCategoria {
    private final CategoriaDao categoriaDao;

    public cCategoria() {
        this.categoriaDao = new CategoriaDao();
    }

    public boolean registrarCategoria(Categoria categoria) {
        return categoriaDao.crear(categoria);
    }

    public Categoria obtenerCategoria(int id) {
        return categoriaDao.leer(id);
    }

    public boolean actualizarCategoria(Categoria categoria) {
        return categoriaDao.actualizar(categoria);
    }

    public boolean eliminarCategoria(int id) {
        return categoriaDao.eliminar(id);
    }
}
