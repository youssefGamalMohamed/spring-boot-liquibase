package com.youssef_gamal.liquibase_demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderDTO(
        Long id,
        @NotNull Long customerId,
        @NotNull LocalDateTime orderDate,
        @NotNull @Positive BigDecimal totalAmount,
        @NotBlank String status,
        Set<OrderItemDTO> orderItems,
        PaymentDTO payment
) {}