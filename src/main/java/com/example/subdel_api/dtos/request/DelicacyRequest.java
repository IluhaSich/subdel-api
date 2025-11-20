package com.example.subdel_api.dtos.request;

import com.example.subdel_api.dtos.response.ProductResponse;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.*;

import java.util.List;

/**
 * DTO для создания или обновления деликатеса.
 *
 * @param name название деликатеса
 * @param mass масса продукта (в граммах)
 * @param proteins количество белков (г на 100 г)
 * @param fats количество жиров (г на 100 г)
 * @param carbohydrates количество углеводов (г на 100 г)
 * @param kcal калорийность (ккал на 100 г)
 * @param country страна происхождения
 * @param products список связанных продуктов (ингредиенты или состав)
 */
public record DelicacyRequest(

        @NotBlank(message = "Название не может быть пустым")
        String name,

        @NotNull(message = "Масса не может быть пустой")
        @Positive(message = "Масса должна быть положительной")
        Double mass,

        @NotNull(message = "Количество белков не может быть пустым")
        @PositiveOrZero(message = "Количество белков не может быть отрицательным")
        Double proteins,

        @NotNull(message = "Количество жиров не может быть пустым")
        @PositiveOrZero(message = "Количество жиров не может быть отрицательным")
        Double fats,

        @NotNull(message = "Количество углеводов не может быть пустым")
        @PositiveOrZero(message = "Количество углеводов не может быть отрицательным")
        Double carbohydrates,

        @NotNull(message = "Количество калорий (ккал) не может быть пустым")
        @PositiveOrZero(message = "Количество калорий не может быть отрицательным")
        Double kcal,

        @NotNull(message = "Страна не может быть пустой")
        String country,

        @NotNull(message = "Список продуктов не может быть пустым")
        @Size(min = 1, message = "Должен быть указан как минимум один продукт")
        List<@NotNull ProductResponse> products
) {}
