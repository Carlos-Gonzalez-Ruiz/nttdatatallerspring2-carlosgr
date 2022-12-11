package com.carlosgr.spring.persistence;

import java.io.Serializable;
import java.util.Objects;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase para la tabla de Producto.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public class Product implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;

	/** ID del producto */
	private Long productId;
	/** Nombre del producto */
	private String name;
	/** Precio PVP */
	private Float priceRetail;
	/** Precio sin impuestos */
	private Float priceTaxFree;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the priceRetail
	 */
	public Float getPriceRetail() {
		return priceRetail;
	}

	/**
	 * @param priceRetail the priceRetail to set
	 */
	public void setPriceRetail(Float priceRetail) {
		this.priceRetail = priceRetail;
	}

	/**
	 * @return the priceTaxFree
	 */
	public Float getPriceTaxFree() {
		return priceTaxFree;
	}

	/**
	 * @param priceTaxFree the priceTaxFree to set
	 */
	public void setPriceTaxFree(Float priceTaxFree) {
		this.priceTaxFree = priceTaxFree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, priceRetail, priceTaxFree, productId);
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
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(priceRetail, other.priceRetail)
				&& Objects.equals(priceTaxFree, other.priceTaxFree) && Objects.equals(productId, other.productId);
	}

	@Override
	public String toString() {
		/* @formatter:off */
		return "[productId=" + productId + ", " +
				"name=\"" + name + "\", " +
				"priceRetail=" + priceRetail + ", " +
				"priceTaxFree=" + priceTaxFree + "]";
		/* @formatter:on */
	}

}
