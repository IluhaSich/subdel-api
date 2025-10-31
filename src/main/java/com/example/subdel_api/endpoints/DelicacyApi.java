package com.example.subdel_api.endpoints;

import com.example.subdel_api.dtos.request.DelicacyRequest;
import com.example.subdel_api.dtos.response.DelicacyResponse;
import com.example.subdel_api.dtos.response.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "delicacies", description = "API для работы с деликатесами")
@RequestMapping("/api/delicacies")
public interface DelicacyApi {

    @Operation(summary = "Получить список всех деликатесов с фильтрацией и пагинацией")
    @ApiResponse(responseCode = "200", description = "Список деликатесов")
    @GetMapping
    PagedModel<EntityModel<DelicacyResponse>> getAllDelicacies(
            @Parameter(description = "Фильтр по ID деликатеса") @RequestParam(required = false) Long delicacyId,
            @Parameter(description = "Номер страницы (0..N)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Размер страницы") @RequestParam(defaultValue = "10") int size
    );


    @Operation(summary = "Получить деликатес по ID")
    @ApiResponse(responseCode = "200", description = "Деликатес найден")
    @ApiResponse(responseCode = "404", description = "Деликатес не найден", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @GetMapping("/{id}")
    EntityModel<DelicacyResponse> getDelicacyById(@PathVariable Long id);

    @Operation(summary = "Создать новый деликатес")
    @ApiResponse(responseCode = "201", description = "Деликатес успешно создан")
    @ApiResponse(responseCode = "400", description = "Невалидный запрос", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<DelicacyResponse>> createDelicacy(@Valid @RequestBody DelicacyRequest request);

    @Operation(summary = "Обновить деликатес по ID")
    @ApiResponse(responseCode = "200", description = "Деликатес успешно обновлён")
    @ApiResponse(responseCode = "404", description = "Деликатес не найден", content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    @PutMapping("/{id}")
    EntityModel<DelicacyResponse> updateDelicacy(@PathVariable Long id, @Valid @RequestBody DelicacyRequest request);

    @Operation(summary = "Удалить деликатес по ID")
    @ApiResponse(responseCode = "204", description = "Деликатес успешно удалён")
    @ApiResponse(responseCode = "404", description = "Деликатес не найден")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDelicacy(@PathVariable Long id);
}
