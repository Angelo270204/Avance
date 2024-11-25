package controlador;

import dao.OrdenCompraDao;
import modelo.OrdenCompra;
import util.DataSource;

import java.sql.Connection;
import java.util.List;

public class cOrdenCompra {

    private final OrdenCompraDao ordenCompraDao;

    public cOrdenCompra() {
        Connection connection = DataSource.obtenerConexion();
        this.ordenCompraDao = new OrdenCompraDao(connection);
    }

    public boolean registrarOrdenCompra(OrdenCompra orden) {
        return ordenCompraDao.registrarOrdenCompra(orden);
    }

    public List<OrdenCompra> obtenerOrdenesCompra() {
        return ordenCompraDao.obtenerOrdenesCompra();
    }

    public boolean actualizarOrdenCompra(OrdenCompra orden) {
        return ordenCompraDao.actualizarOrdenCompra(orden);
    }

    public boolean eliminarOrdenCompra(int idOrden) {
        return ordenCompraDao.eliminarOrdenCompra(idOrden);
    }

    public List<OrdenCompra> buscarPedidos(String nombreProveedor) {
        return ordenCompraDao.obtenerOrdenesCompraPorNombre(nombreProveedor);
    }
}
