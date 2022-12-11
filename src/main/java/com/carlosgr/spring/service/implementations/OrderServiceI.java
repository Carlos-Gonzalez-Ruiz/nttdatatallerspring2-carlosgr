package com.carlosgr.spring.service.implementations;

import java.util.List;

import com.carlosgr.spring.exceptions.OrderServiceException;
import com.carlosgr.spring.persistence.Order;
import com.carlosgr.spring.persistence.Product;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Interfaz de servicio de envío de productos por pedido.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public interface OrderServiceI {

	/**
	 * Método para realizar un nuevo pedido. Lanza una expceción en caso de insertar
	 * un pedido con el mismo ID o en caso de estar fuera de las comunidades de las
	 * que se permite.
	 * 
	 * @param order
	 * @throws OrderServiceException
	 */
	public void insertOrder(final Order order) throws OrderServiceException;

	/**
	 * Método para eliminar un pedido.
	 * 
	 * @param order
	 */
	public void removeOrder(final Order order);

	/**
	 * Método para añadir un producto a un pedido. Lanza una expceción en caso de
	 * insertar un producto con el mismo ID.
	 * 
	 * @param product
	 * @param order
	 * @throws OrderServiceException
	 */
	public void addProduct(final Product product, final Order order) throws OrderServiceException;

	/**
	 * Método para eliminar un producto (el primer producto que encuentre) a un
	 * pedido.
	 * 
	 * @param product
	 * @param order
	 */
	public void removeProduct(final Product product, final Order order);

	/**
	 * Método para que devuelve una lista con todos los pedidos, simulando el
	 * proceso de consulta a la base de datos.
	 * 
	 * @return List<Order>
	 */
	public List<Order> findAllOrders();

	/**
	 * Método para que devuelve una lista con todos los productos, simulando el
	 * proceso de consulta a la base de datos.
	 * 
	 * @return List<Product>
	 */
	public List<Product> findAllProducts();

}
