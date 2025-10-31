package com.example.subdel_api.dtos.request;

import jakarta.validation.constraints.*;


/**
 * @param name название продукта
 */
public record ProductRequest(

        @NotBlank(message = "Название не может быть пустым")
        String name
) {}
