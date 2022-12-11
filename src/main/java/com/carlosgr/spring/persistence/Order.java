package com.carlosgr.spring.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase para la tabla de Pedido.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public class Order implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;

	/** Enumarados con todas las comunidades de España */
	public enum Community {
		ANDALUCIA, ARAGON, ASTURIAS, BALEARES, CANTABRIA, CANARIAS, CASTILLA_LAMANCHA, CASTILLA_LEON, CATALUNYA, CEUTA,
		VALENCIANA, EXTREMADURA, GALACIA, RIOJA, MADRID, MELILLA, MURCIA, NAVARRA, VASCO
	}

	/** ID del pedido */
	private Long orderId;
	/** Destinatario del pedido */
	private String receiver;
	/** Dirección de entrega */
	private String destinationAddress;
	/** Comunidad autónoma a la que se entrega */
	private Community autonomousCommunity;

	/** Lista de productos */
	private List<Product> products;

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the destinationAddress
	 */
	public String getDestinationAddress() {
		return destinationAddress;
	}

	/**
	 * @param destinationAddress the destinationAddress to set
	 */
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	/**
	 * @return the autonomousCommunity
	 */
	public Community getAutonomousCommunity() {
		return autonomousCommunity;
	}

	/**
	 * @param autonomousCommunity the autonomousCommunity to set
	 */
	public void setAutonomousCommunity(Community autonomousCommunity) {
		this.autonomousCommunity = autonomousCommunity;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autonomousCommunity, destinationAddress, orderId, products, receiver);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return autonomousCommunity == other.autonomousCommunity
				&& Objects.equals(destinationAddress, other.destinationAddress)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(products, other.products)
				&& Objects.equals(receiver, other.receiver);
	}

	@Override
	public String toString() {
		/* @formatter:off */
		return	"[orderId=" + orderId + ", " +
				"receiver=\"" + receiver + "\", " +
				"destinationAddress=\"" + destinationAddress + "\", " +
				"produts=" + products.toString() + "]";
		/* @formatter:on */
	}

}
