package com.example.subdel_api.endpoints;

import com.example.subdel_api.dtos.request.ProductRequest;
import com.example.subdel_api.dtos.response.ProductResponse;
import com.example.subdel_api.dtos.response.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "products", description = "API для работы с продуктами")
@RequestMapping("/api/products")
public interface ProductApi {

    @Operation(summary = "Получить список всех продуктов")
    @ApiResponse(responseCode = "200", description = "Список продуктов")
    @GetMapping
    CollectionModel<EntityModel<ProductResponse>> getAllProducts();

    @Operation(summary = "Получить продукт по ID")
    @ApiResponse(responseCode = "200", description = "Продукт найден")
    @ApiResponse(responseCode = "404", description = "Продукт не найден", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @GetMapping("/{id}")
    EntityModel<ProductResponse> getProductById(@PathVariable Long id);

    @Operation(summary = "Создать новый продукт")
    @ApiResponse(responseCode = "201", description = "Продукт успешно создан")
    @ApiResponse(responseCode = "400", description = "Невалидный запрос", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest request);

    @Operation(summary = "Обновить продукт по ID")
    @ApiResponse(responseCode = "200", description = "Продукт успешно обновлён")
    @ApiResponse(responseCode = "404", description = "Продукт не найден", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @PutMapping("/{id}")
    EntityModel<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request);

    @Operation(summary = "Удалить продукт по ID")
    @ApiResponse(responseCode = "204", description = "Продукт успешно удалён")
    @ApiResponse(responseCode = "404", description = "Продукт не найден")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable Long id);
}
