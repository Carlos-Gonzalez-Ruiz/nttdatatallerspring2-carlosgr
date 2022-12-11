package com.carlosgr.spring.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.carlosgr.spring.exceptions.OrderServiceException;
import com.carlosgr.spring.persistence.Order;
import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.service.implementations.OrderServiceI;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase que implementa la funcionalidad base del servicio de pedido, evitando
 * así código repetido.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Service("Generic")
@Primary
public class OrderServiceGenericImpl implements OrderServiceI {

	/** Porcentaje de IVA a aplicar al PVP */
	private float priceTaxFactor;

	/** Comunidades que permite este servicio */
	private List<Order.Community> communities;
	/** Simular tabla de pedidos */
	private List<Order> orders;
	/** Simular tabla de productos */
	private List<Product> products;

	/**
	 * Método constructor de la clase.
	 * 
	 */
	public OrderServiceGenericImpl(List<Order> orders, List<Product> products) {
		super();
		this.orders = orders;
		this.products = products;
	}

	/**
	 * @return the priceTaxFactor
	 */
	public float getPriceTaxFactor() {
		return priceTaxFactor;
	}

	/**
	 * @param priceTaxFactor the priceTaxFactor to set
	 */
	public void setPriceTaxFactor(float priceTaxFactor) {
		this.priceTaxFactor = priceTaxFactor;
	}

	/**
	 * @return the communinites
	 */
	public List<Order.Community> getCommunities() {
		return communities;
	}

	/**
	 * @param communinites the communinites to set
	 */
	public void setCommunities(List<Order.Community> communities) {
		this.communities = communities;
	}

	@Override
	public void insertOrder(Order order) throws OrderServiceException {

		// Comprobar que no esté dentro de las comunidades permitidas.
		if (communities.contains(order.getAutonomousCommunity())) {

			if (orders.contains(order)) {

				// Lanzar excepción en caso de insertar más de 1 vez el mismo pedido.
				throw new OrderServiceException("El pedido, con ID " + order.getOrderId() + ", ya ha sido insertado.");

			} else {

				// Establecer ID al pedido, iterando y buscando el ID "más alto" en la lista de
				// pedidos.
				Long id = Long.valueOf(0);
				for (Order o : orders) {
					if (o.getOrderId() > id) {
						id = o.getOrderId();
					}
				}
				order.setOrderId(id + 1);

				orders.add(order);
			}

		} else {
			throw new OrderServiceException("La comunidad del pedido debe ser en " + communities.toString());
		}
	}

	@Override
	public void removeOrder(Order order) {
		orders.remove(order);
	}

	@Override
	public void addProduct(Product product, Order order) throws OrderServiceException {
		// Establecer ID al producto, iterando y buscando el ID "más alto" en la lista
		// de productos.
		Long id = Long.valueOf(0);
		for (Product p : products) {
			if (p.getProductId() > id) {
				id = p.getProductId();
			}
		}
		product.setProductId(id + 1);

		// Instanciar lista de productos en caso de que sea nula..
		if (order.getProducts() == null) {
			order.setProducts(new ArrayList<>());
		}

		if (order.getProducts().contains(product)) {

			// Lanzar excepción en caso de insertar más de 1 vez el mismo producto.
			throw new OrderServiceException("El producto, con ID " + product.getProductId()
					+ ",  ya ha sido insertado en el pedido con ID " + order.getOrderId());

		} else {
			// Aplicar impuestos. Eliminar decimales sobrantes mediante redondeo.
			product.setPriceRetail(Math.round(product.getPriceTaxFree() * priceTaxFactor * 100) / 100.0f);

			// Añadir producto a la tabla de productos.
			products.add(product);

			// Añadir al pedido.
			order.getProducts().add(product);
		}

	}

	@Override
	public void removeProduct(Product product, Order order) {
		products.remove(product);
		order.getProducts().remove(product);
	}

	@Override
	public List<Order> findAllOrders() {
		return orders;
	}

	@Override
	public List<Product> findAllProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "[Servicio de pedido genérico]";
	}

}
