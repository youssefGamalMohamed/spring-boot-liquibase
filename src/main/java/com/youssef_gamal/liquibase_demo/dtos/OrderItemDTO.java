package com.youssef_gamal.liquibase_demo.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record OrderItemDTO(
        Long id,
        @NotNull Long productId,
        @NotNull @Positive Integer quantity,
        @NotNull @Positive BigDecimal unitPrice
) {}