package com.spand0x.gamestore.services;

import com.spand0x.gamestore.domain.entities.Order;
import com.spand0x.gamestore.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Order order) {
        this.orderRepository.saveAndFlush(order);
    }
}
