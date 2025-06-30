package com.youssef_gamal.liquibase_demo.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youssef_gamal.liquibase_demo.dtos.OrderDTO;
import com.youssef_gamal.liquibase_demo.dtos.OrderItemDTO;
import com.youssef_gamal.liquibase_demo.entities.Customer;
import com.youssef_gamal.liquibase_demo.entities.Order;
import com.youssef_gamal.liquibase_demo.entities.OrderItem;
import com.youssef_gamal.liquibase_demo.entities.Payment;
import com.youssef_gamal.liquibase_demo.entities.Product;
import com.youssef_gamal.liquibase_demo.mappers.OrderMapper;
import com.youssef_gamal.liquibase_demo.repos.CustomerRepository;
import com.youssef_gamal.liquibase_demo.repos.OrderRepository;
import com.youssef_gamal.liquibase_demo.repos.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(orderDTO.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + orderDTO.customerId()));

        Order order = Order.builder()
                .customer(customer)
                .orderDate(LocalDateTime.now())
                .status("PENDING")
                .build();

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItemDTO itemDTO : orderDTO.orderItems()) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + itemDTO.productId()));

            if (product.getStockQuantity() < itemDTO.quantity()) {
                throw new IllegalArgumentException("Not enough stock for product: " + product.getName());
            }

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(itemDTO.quantity())
                    .unitPrice(product.getPrice()) // Use current product price
                    .build();
            order.addOrderItem(orderItem);

            totalAmount = totalAmount.add(product.getPrice().multiply(BigDecimal.valueOf(itemDTO.quantity())));

            // Decrease stock
            product.setStockQuantity(product.getStockQuantity() - itemDTO.quantity());
            productRepository.save(product);
        }

        order.setTotalAmount(totalAmount);

        // Handle payment if provided
        if (orderDTO.payment() != null) {
            Payment payment = Payment.builder()
                    .paymentDate(LocalDateTime.now())
                    .amount(orderDTO.payment().amount())
                    .paymentMethod(orderDTO.payment().paymentMethod())
                    .transactionId(orderDTO.payment().transactionId())
                    .build();
            order.setPayment(payment);
        }

        return orderMapper.toDto(orderRepository.save(order));
    }

    @Transactional(readOnly = true)
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO updateOrderStatus(Long id, String newStatus) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        existingOrder.setStatus(newStatus);
        return orderMapper.toDto(orderRepository.save(existingOrder));
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}