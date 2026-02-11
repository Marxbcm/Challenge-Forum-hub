package com.ForumAlura.model.topico;

import java.time.LocalDateTime;


public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Estado estado,
        String autor,
        String curso) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId, topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstado(), topico.getAutor(), topico.getCurso());
    }
}