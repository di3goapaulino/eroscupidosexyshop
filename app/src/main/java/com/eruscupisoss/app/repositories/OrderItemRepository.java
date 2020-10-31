package com.eruscupisoss.app.repositories;

import com.eruscupisoss.app.entities.OrderItem;
import com.eruscupisoss.app.entities.pk.OrderItemPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
