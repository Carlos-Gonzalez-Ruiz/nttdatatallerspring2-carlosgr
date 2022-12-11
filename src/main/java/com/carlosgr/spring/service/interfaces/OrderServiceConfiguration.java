package com.carlosgr.spring.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.carlosgr.spring.persistence.Order;
import com.carlosgr.spring.persistence.Product;

/**
 * NTT Data - Spring - Taller 2
 * 
 * Clase de configuración de beans para . En función de si está dentro o fuera
 * de la península (qualifier), se instanciará un OrderServiceGenericImpl con
 * datos espíficos como comunidades y porcentaje de impuestos.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Configuration
public class OrderServiceConfiguration {

	@Qualifier("serviceSpain")
	@Primary
	@Bean
	public OrderServiceGenericImpl service1(@Autowired List<Order> orders, @Autowired List<Product> products) {
		OrderServiceGenericImpl orderServiceGeneric = new OrderServiceGenericImpl(orders, products);
		orderServiceGeneric.setPriceTaxFactor(1.21f);

		Order.Community[] communities = { Order.Community.ANDALUCIA, Order.Community.ARAGON, Order.Community.ASTURIAS,
				Order.Community.BALEARES, Order.Community.CANTABRIA, Order.Community.CASTILLA_LAMANCHA,
				Order.Community.CASTILLA_LEON, Order.Community.CATALUNYA, Order.Community.VALENCIANA,
				Order.Community.EXTREMADURA, Order.Community.GALACIA, Order.Community.RIOJA, Order.Community.MADRID,
				Order.Community.MURCIA, Order.Community.NAVARRA, Order.Community.VASCO };
		orderServiceGeneric.setCommunities(List.of(communities));

		return orderServiceGeneric;
	}

	@Qualifier("serviceSpainOutter")
	@Bean
	public OrderServiceGenericImpl service2(@Autowired List<Order> orders, @Autowired List<Product> products) {
		OrderServiceGenericImpl orderServiceGeneric = new OrderServiceGenericImpl(orders, products);
		orderServiceGeneric.setPriceTaxFactor(1.04f);

		Order.Community[] communities = { Order.Community.CANARIAS, Order.Community.CEUTA, Order.Community.MELILLA };
		orderServiceGeneric.setCommunities(List.of(communities));

		return orderServiceGeneric;
	}

}
