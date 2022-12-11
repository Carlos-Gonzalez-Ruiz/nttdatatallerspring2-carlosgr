package com.carlosgr.spring.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.carlosgr.spring.exceptions.OrderServiceException;
import com.carlosgr.spring.persistence.Order;
import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.service.implementations.OrderServiceI;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase que implementa el servicio de envío de productos por pedido, para
 * aquellos pedidos que se realizen fuera de la península ibérica.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Service("SpainOutter")
public class OrderServiceSpainOutterImpl implements OrderServiceI {

	/** Servicio de pedido genérico */
	@Autowired
	@Qualifier("serviceSpainOutter")
	private OrderServiceI orderGenericService;

	/**
	 * Método constructor de la clase.
	 * 
	 */
	public OrderServiceSpainOutterImpl() {
		super();
	}

	@Override
	public void insertOrder(Order order) throws OrderServiceException {
		orderGenericService.insertOrder(order);
	}

	@Override
	public void removeOrder(Order order) {
		orderGenericService.removeOrder(order);
	}

	@Override
	public void addProduct(Product product, Order order) {
		orderGenericService.addProduct(product, order);
	}

	@Override
	public void removeProduct(Product product, Order order) {
		orderGenericService.removeProduct(product, order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderGenericService.findAllOrders();
	}

	@Override
	public List<Product> findAllProducts() {
		return orderGenericService.findAllProducts();
	}

	@Override
	public String toString() {
		return "[Servicio de pedido fuera de la península]";
	}

}
