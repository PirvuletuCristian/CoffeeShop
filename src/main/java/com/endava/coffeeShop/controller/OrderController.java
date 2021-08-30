package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.EmployeeNotFoundException;
import com.endava.coffeeShop.model.Order;
import com.endava.coffeeShop.repository.OrderRepository;
import com.endava.coffeeShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    public final OrderRepository orderRepository;

    public final OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    List<Order> all(){return orderRepository.findAll();}

    @GetMapping("/orders/{id}")
    Optional<Order> one(@PathVariable Long id){
        return orderRepository.findById(id);
    }

    @PostMapping("/orders")
    public Order postOrder(Order order){
        System.out.println("Order" + order.getId());

        orderService.addOrder(order);

        return order;
    }

    @PutMapping("/orders/{id}/{newAmount}/{newDelivery}")
    public Order update(@PathVariable Long id, @PathVariable int newAmount, @PathVariable boolean newDelivery){
        Order order = orderRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        order.setAmount(newAmount);
        order.setDelivery(newDelivery);

        return orderRepository.save(order);
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id){orderRepository.deleteById(id);}
}
