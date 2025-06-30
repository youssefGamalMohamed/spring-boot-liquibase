package com.youssef_gamal.liquibase_demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        @NotBlank String name,
        String description,
        @NotNull @Positive BigDecimal price,
        @NotNull @Positive Integer stockQuantity
) {}