package com.example.subdel_api.dtos.request;

import jakarta.validation.constraints.*;


/**
 * @param name название продукта
 * @param price цена продукта
 */
public record ProductRequest(

        @NotBlank(message = "Название не может быть пустым")
        String name,

        @NotNull(message = "Цена не может быть пустой")
        @Positive(message = "Цена должна быть положительной")
        Double price

) {}
