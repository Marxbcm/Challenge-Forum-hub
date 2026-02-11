package com.ForumAlura.model.resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        String topico,
        LocalDateTime data,
        String autor) {


    public DadosDetalhamentoResposta(Resposta resposta) {
        this(resposta.getId(),resposta.GetMensagem(),resposta.getTopico(), resposta.getData(), resposta.getAutor());
    }
}