package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Order;
import com.endava.coffeeShop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order addOrder(Order order){
        order = orderRepository.save(order);

        return order;
    }
}
