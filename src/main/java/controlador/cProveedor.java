package controlador;

import modelo.Proveedor;
import dao.ProveedorDao;
import java.util.List;

public class cProveedor {
    private final ProveedorDao proveedorDao;

    public List<Proveedor> listarProveedores(){
        return proveedorDao.getAllProveedores();
    }
    
    public cProveedor(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    public void registrarProveedor(Proveedor proveedor) {
        proveedorDao.addProveedor(proveedor);
    }

    public Proveedor obtenerProveedor(int id) {
        // Método para obtener un proveedor por ID (borrar si deseas)
        return proveedorDao.getAllProveedores().stream()
                .filter(p -> p.getIdProveedor() == id)
                .findFirst()
                .orElse(null);
    }
    public boolean actualizarProveedor(Proveedor proveedor) {
        return proveedorDao.updateProveedor(proveedor);
    }

    public boolean eliminarProveedor(int id) {
        return proveedorDao.deleteProveedor(id);
    }
}
