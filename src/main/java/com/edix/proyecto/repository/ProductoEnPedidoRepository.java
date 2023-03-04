package com.edix.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.edix.proyecto.beans.ProductosEnPedido;

public interface ProductoEnPedidoRepository extends JpaRepository<ProductosEnPedido, Integer> {
	
	@Query("SELECT p FROM ProductosEnPedido p WHERE p.numeroOrden=?1")
	ProductosEnPedido buscarUno(int numeroOrden);

	@Query(value = "SELECT PEP.* FROM proyecto_servidor.PEDIDOS PED JOIN proyecto_servidor.productos_en_pedidos PEP ON PED.ID_PEDIDO = PEP.ID_PEDIDO WHERE PED.ID_USUARIO = ?1 AND PED.ESTADO = 'CARRITO'", nativeQuery = true)
	List<ProductosEnPedido>	ProductosEnPedidoPorUsuario(Integer idUsuario);
}
