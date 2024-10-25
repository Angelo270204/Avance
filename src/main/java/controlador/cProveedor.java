package controlador;

import modelo.Proveedor;
import dao.ProveedorDao;

public class cProveedor {
    private final ProveedorDao proveedorDao;

    public cProveedor() {
        this.proveedorDao = new ProveedorDao();
    }

    public boolean registrarProveedor(Proveedor proveedor) {
        return proveedorDao.crear(proveedor);
    }

    public Proveedor obtenerProveedor(int id) {
        return proveedorDao.leer(id);
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        return proveedorDao.actualizar(proveedor);
    }

    public boolean eliminarProveedor(int id) {
        return proveedorDao.eliminar(id);
    }
}
