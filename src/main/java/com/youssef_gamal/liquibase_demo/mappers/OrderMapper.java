package com.youssef_gamal.liquibase_demo.mappers;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.youssef_gamal.liquibase_demo.dtos.OrderDTO;
import com.youssef_gamal.liquibase_demo.dtos.OrderItemDTO;
import com.youssef_gamal.liquibase_demo.dtos.PaymentDTO;
import com.youssef_gamal.liquibase_demo.entities.Order;
import com.youssef_gamal.liquibase_demo.entities.OrderItem;
import com.youssef_gamal.liquibase_demo.entities.Payment;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProductMapper.class})
public interface OrderMapper {
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(target = "orderItems", source = "orderItems")
    @Mapping(target = "payment", source = "payment")
    OrderDTO toDto(Order order);

    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "orderItems", ignore = true) // Handled manually in service or via helper
    @Mapping(target = "payment", ignore = true) // Handled manually in service or via helper
    Order toEntity(OrderDTO orderDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(source = "productId", target = "product.id")
    OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(source = "orderId", target = "order.id")
    Payment toPaymentEntity(PaymentDTO paymentDTO);

    OrderItemDTO toOrderItemDto(OrderItem orderItem);
    PaymentDTO toPaymentDto(Payment payment);

    Set<OrderItemDTO> toOrderItemDtoSet(Set<OrderItem> orderItems);
    Set<OrderItem> toOrderItemEntitySet(Set<OrderItemDTO> orderItemDTOS);
}
