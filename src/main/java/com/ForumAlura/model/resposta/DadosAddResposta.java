package com.ForumAlura.model.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosAddResposta(@NotBlank String mensagem, @NotBlank String topico, @NotBlank String autor){
}
