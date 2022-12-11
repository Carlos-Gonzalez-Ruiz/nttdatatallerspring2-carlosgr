package com.carlosgr.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carlosgr.spring.persistence.Order;
import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.service.implementations.OrderServiceI;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase principal de la aplicación.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@SpringBootApplication
public class Spring2Application implements CommandLineRunner {

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(Spring2Application.class);

	/** Servicio de envío de productos por pedido en España (primary) */
	@Autowired
	@Qualifier("Spain")
	private OrderServiceI orderServiceSpain;
	/** Servicio de envío de productos por pedido fuera de la península */
	@Autowired
	@Qualifier("SpainOutter")
	private OrderServiceI orderServiceSpainOutter;

	/**
	 * Método principal de la clase.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
	}

	/**
	 * Método que Spring llama al inicializar la aplicación tras iniciar Spring
	 * Boot.
	 * 
	 * @param args (vaargs)
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {

		Order order;
		Product product;

		// Instanciar e insertar pedido.
		order = new Order();
		order.setDestinationAddress("Alcalá de Guadíra, Sevilla");
		order.setReceiver("Carlos González Ruiz");
		order.setAutonomousCommunity(Order.Community.ANDALUCIA);
		orderServiceSpain.insertOrder(order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Cepillo de dientes");
		product.setPriceTaxFree(1.99f);
		orderServiceSpain.addProduct(product, order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Móvil Huawei");
		product.setPriceTaxFree(149.99f);
		orderServiceSpain.addProduct(product, order);

		// Instanciar e insertar pedido.
		order = new Order();
		order.setDestinationAddress("Calle Alameda, 132");
		order.setReceiver("Pepe Márquez");
		order.setAutonomousCommunity(Order.Community.CEUTA);
		orderServiceSpainOutter.insertOrder(order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Pasta de dientes");
		product.setPriceTaxFree(4.00f);
		orderServiceSpainOutter.addProduct(product, order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Tarjeta gráfica");
		product.setPriceTaxFree(149.99f);
		orderServiceSpainOutter.addProduct(product, order);

		// Instanciar e insertar pedido.
		order = new Order();
		order.setDestinationAddress("Calle Pinos, 456");
		order.setReceiver("Luis Vázquez");
		order.setAutonomousCommunity(Order.Community.CANARIAS);
		orderServiceSpainOutter.insertOrder(order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Pantalla 16:9 ASUS");
		product.setPriceTaxFree(229.99f);
		orderServiceSpainOutter.addProduct(product, order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Teclado Olivetti Vintage Segunda Mano");
		product.setPriceTaxFree(79.99f);
		orderServiceSpainOutter.addProduct(product, order);
		// Instanciar y añadir producto al pedido.
		product = new Product();
		product.setName("Cascos con micrófono PC2");
		product.setPriceTaxFree(18.00f);
		orderServiceSpainOutter.addProduct(product, order);

		List<Order> orders;
		StringBuilder string = new StringBuilder();

		// Mostrar pedidos dentro en la península de manera más legible.
		orders = orderServiceSpain.findAllOrders();
		string.append("\n\nPedidos dentro en la península: \n");
		for (Order o : orders) {
			string.append("\torderId = " + o.getOrderId() + "\n");
			string.append("\treceiver = " + o.getReceiver() + "\n");
			string.append("\tdestionationAddress = " + o.getDestinationAddress() + "\n");
			string.append("\tproducts = \n");
			for (Product p : o.getProducts()) {
				string.append("\t\t" + p.toString() + "\n");
			}
		}

		// Mostrar pedidos fuera en la península de manera más legible.
		orders = orderServiceSpainOutter.findAllOrders();
		string.append("\n\nPedidos fuera en la península: \n");
		for (Order o : orders) {
			string.append("\torderId = " + o.getOrderId() + "\n");
			string.append("\treceiver = " + o.getReceiver() + "\n");
			string.append("\tdestionationAddress = " + o.getDestinationAddress() + "\n");
			string.append("\tproducts = \n");
			for (Product p : o.getProducts()) {
				string.append("\t\t" + p.toString() + "\n");
			}
			string.append("\n");
		}

		LOG.info("{}", string);
	}

}