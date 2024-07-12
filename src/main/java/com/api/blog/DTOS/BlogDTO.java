package com.api.blog.DTOS;

import jakarta.validation.constraints.NotNull;

public record BlogDTO(@NotNull String titulo, @NotNull String descricao) {
}
