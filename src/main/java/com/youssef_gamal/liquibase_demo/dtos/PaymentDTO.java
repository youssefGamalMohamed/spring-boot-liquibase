package com.youssef_gamal.liquibase_demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentDTO(
        Long id,
        @NotNull Long orderId,
        @NotNull LocalDateTime paymentDate,
        @NotNull @Positive BigDecimal amount,
        @NotBlank String paymentMethod,
        @NotBlank String transactionId
) {}
