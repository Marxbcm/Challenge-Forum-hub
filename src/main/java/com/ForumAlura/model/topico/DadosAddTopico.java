package com.ForumAlura.model.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAddTopico(@NotBlank
                             String titulo,
                             @NotBlank
                             String mensagem,
                             @NotBlank
                             String autor,
                             @NotBlank
                             String curso) {
}
