package com.example.subdel_api.dtos.request;

import com.example.subdel_api.dtos.response.DelicacyResponse;
import com.example.subdel_api.dtos.response.ProductResponse;
import com.example.subdel_api.dtos.response.UserResponse;
import jakarta.validation.constraints.*;

import java.util.List;

/**
 * DTO для создания или обновления пользователя.
 *
 * @param name название деликатеса
 * @param delicacies список деликатесов или подписок
 */
public record UserRequest(

        @NotBlank(message = "Имя не может быть пустым")
        String name,

        List<DelicacyResponse> delicacies
) {}
